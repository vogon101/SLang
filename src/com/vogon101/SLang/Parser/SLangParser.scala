package com.vogon101.SLang.Parser

import com.vogon101.SLang.Interpreter._

import scala.util.parsing.combinator.{ PackratParsers, JavaTokenParsers }

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class SLangParser extends JavaTokenParsers with MathParsers with BooleanParsers with ListParsers{

  lazy val program:PackratParser[Program] = rep(line) ^^ (x => new Program(x))

  lazy val line:PackratParser[Line] = ((assignment | element | comment) <~ (";" | "[\n\r]*".r)) ^^ (x=>x.asInstanceOf[Line])

  lazy val assignment:PackratParser[Assignment] = assignmentLHS ~ element ^^ {
    case x ~ y => new Assignment(x,y)
  }

  lazy val assignmentLHS = identifier <~ "="

  lazy val identifier:Parser[String] = "[a-zA-Z]+[a-zA-Z0-9]*".r

  lazy val comment:Parser[Comment] = "//.*".r ^^ (x => new Comment())

  lazy val functionCall:PackratParser[FunctionCall] = identifier ~ parameters ^^ {
    case n~ p => new FunctionCall(n,p)
  }

  lazy val parameters: PackratParser[List[Element]] = "(" ~> repsep(element, ",") <~ ")"

  lazy val codeBlock:PackratParser[CodeBlock] = "{" ~> rep(line) <~ "}" ^^ (x=>new CodeBlock(x))

  lazy val expression:PackratParser[Element] = (
      booleanExpression
      | mathExpression
      | listExpression
    )

  lazy val value:PackratParser[Value] = (
      string^^ (x => new Value(x.toString.substring(1,x.length-1)))
    | number
    | list
    )

  lazy val functionDef:PackratParser[FunctionDef] = (((identifierList <~ "=>") ^^ (x=>x)) ~ codeBlock) ^^ {
    case x~y => new FunctionDef(y,x)
  }

  lazy val identifierList:PackratParser[List[String]] = "(" ~> rep(identifier) <~ ")"

  lazy val string:PackratParser[String] = stringLiteral

  lazy val reference: PackratParser[Reference] = identifier ^^ (x=>new Reference(x))

  lazy val element:PackratParser[Element] =(
        functionDef
      | comparison
      | expression
      | boolean
      | controlStatement
      | functionCall
      | reference
      | value
      | codeBlock

    )

  lazy val controlStatement:PackratParser[Element] = returnStatement | ifStatement | whileLoop

  lazy val returnStatement:PackratParser[ReturnStatement] = "return" ~> element ^^ (new ReturnStatement(_))

  lazy val ifStatement:PackratParser[IfStatement] = (
    ("if" ~ "(" ~> element <~ ")") ~ element ~ ((elseifStatement | elseStatement)?)) ^^ {
        case (x:Element) ~ (y:Element) ~ (z:Option[Element]) => {
          new IfStatement(x, y, if (z.isDefined) z.get else new CodeBlock())
        }
      }

  lazy val elseifStatement:PackratParser[Element] = "else" ~> ifStatement

  lazy val elseStatement:PackratParser[Element] = "else" ~> element

  lazy val whileLoop:PackratParser[WhileLoop] = (("while" ~ "(" ~> element <~ ")") ~ element) ^^ {

    case (x:Element) ~ (y:Element) => new WhileLoop(x,y)

  }

}
