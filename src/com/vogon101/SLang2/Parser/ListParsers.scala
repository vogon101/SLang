package com.vogon101.SLang2.Parser

import com.vogon101.SLang2.Interpreter.{ Element, Value }

import scala.util.parsing.combinator.{ PackratParsers, JavaTokenParsers }

/**
 * Created by Freddie Poser on 16/01/2016.
 */
trait ListParsers extends JavaTokenParsers with PackratParsers{

  def element: Parser[Any]

  val list: PackratParser[Value] = "[" ~> repsep(element, ",") <~ "]" ^^ (x=>new Value(x))

  val listExpression: PackratParser[Element] = list

}
