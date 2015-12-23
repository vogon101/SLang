package com.vogon101.SLang.parsers

import com.vogon101.SLang.interpreter._

import scala.util.parsing.combinator._

import com.vogon101.SLang.interpreter.Element

/**
 * Main parsers for SLang. Base is program. parseAll(program,text) will return the tree
 * for running correct program
 */
class SLangParser extends JavaTokenParsers {

  def program = rep(line) ^^ {x=>new Program(x)}

  def line = (assignment | element) <~ ";" ^^ (x=>x.asInstanceOf[Line])

  def assignment = assignmentPartOne ~ element ^^ (x=> {/*println(s"ASSIGN $x"); */x match {

    case variable ~ e => new Assignment(variable, e.asInstanceOf[Element])
  }})

  def assignmentPartOne = variable <~ "=" ^^ (x=>x.name)


  def element: Parser[Any] = value | variable | function_call ^^ (x=> {/*println(s"ELEMENT $x"); */x match {

    case default => default.asInstanceOf[Element]
  }})

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

  //TODO: Make this accept ints and floats
  def number = floatingPointNumber ^^ (x => {
    try {
      x.toInt
    }
    catch {
      case e:NumberFormatException => x.toFloat
    }

  })
}