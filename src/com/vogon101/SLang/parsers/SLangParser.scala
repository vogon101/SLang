package com.vogon101.SLang.parsers

import com.vogon101.SLang.interpreter._

import scala.util.parsing.combinator._

/**
 * Main parsers for SLang. Base is program. parseAll(program,text) will return the tree
 * for running correct program
 */
class SLangParser extends SLangMathsParsers with SLangBooleanParsers with PackratParsers{

  //TODO: Make scala tests for the parsers

  def program = rep(line) ^^ {x=>new Program(x)}

  def line = (assignment | element | comment /*| controlStatement*/) <~ (";" | "[\n\r]*".r) ^^ (x=>x.asInstanceOf[Line])

  def comment = "//.*".r ^^ (x=>new Comment())

  def assignment = assignmentPartOne ~ element ^^ {
    case variable ~ e => new Assignment(variable, e.asInstanceOf[Element])
  }

  def assignmentPartOne = variable <~ "=" ^^ (x=>x.name)

  //def controlStatement = (("if" | "while") ~ booleanStatement ~ codeBlock) ^^ {
  //  case "if" ~ bs ~ cb => new IfStatement(bs, cb.asInstanceOf[CodeBlock])

  //}

  def codeBlock = "{" ~> rep(line) <~ "}" ^^ (x => new CodeBlock(x))

  lazy val element: PackratParser[Element] = (
    comparison          |
    boolean_expression  |
    mathExpression      |
    boolean             |
    function_call       |
    variable            |
    value               |
    codeBlock
    ) ^^ {
    case default => default.asInstanceOf[Element]
  }

  def variable  = "$" ~> "[a-zA-Z0-9]+".r ^^ (x=> {/*println(s"VARIABLE $x");*/ new Variable("$" + x)})

  def function_call = ((function_name | variable) ~ parameters) ^^ {
    case t ~ ts => (t, ts) match {
      case (t:Variable, ts:List[Element]) => new FunctionCall(t.name, ts, anon = true)
      case (t:String, ts:List[Element]) => new FunctionCall(t,ts)
    }
  }

  def parameters = "(" ~> repsep(element, ",") <~ ")" ^^ {
    case elements:List[Any] => elements.map(x=>x.asInstanceOf[Element])
  }

  def function_name = "[a-zA-Z0-9]+".r ^^ (x=>x.toString)

  def list = "[" ~> repsep(element, ",") <~ "]" ^^ (x=>new Value(x))

  def value = (
      stringLiteral ^^ (x => x.toString.substring(1,x.length-1))
    | number
    | list
    | "null" ^^ (x => null)

   ) ^^ (x => new Value(x))
}