package com.vogon101.SLang.parsers

import com.vogon101.SLang.interpreter._
import com.vogon101.SLang.interpreter.control.CodeBlock

import scala.util.parsing.combinator._

import com.vogon101.SLang.interpreter.Element

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

  //TODO: Actually do this
  def booleanStatement = "(" ~> "true" | "false" <~ ")"

  def codeBlock = "{" ~> rep(line) <~ "}" ^^ (x => new CodeBlock(x))

  lazy val element: PackratParser[Any] = mathExpression |variable | function_call | codeBlock | value  ^^ {
    case default => default.asInstanceOf[Element]
  }

  def variable  = "$" ~> "[a-zA-Z0-9]+".r ^^ (x=> {/*println(s"VARIABLE $x");*/ new Variable("$" + x)})

  def function_call = function_name ~ parameters ^^ {
    case name ~ elements => /*println(s"Function call $name");*/new FunctionCall(name , elements)
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
    | "true" ^^ (x => true)
    | "false" ^^ (x => false)
   ) ^^ (x => new Value(x))
}