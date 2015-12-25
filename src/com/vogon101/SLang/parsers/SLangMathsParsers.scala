package com.vogon101.SLang.parsers

import com.vogon101.SLang.interpreter.{ Element, Value }
import com.vogon101.SLang.interpreter.math.{ Multiply, Divide, Subtract, Add }

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * Created by Freddie Poser on 25/12/2015.
 *
 */
trait SLangMathsParsers extends JavaTokenParsers{

  //TODO: Make this work with elements

  def element: Parser[Any]
  def variable: Parser[Any]
  def value: Parser[Any]

  def number = float | integer

  def integer = wholeNumber ^^ {i => new Value(i.toInt)}
  def float = """[+-]?[0-9]*((\.[0-9]+([eE][+-]?[0-9]+)?[fF]?)|([fF])|([eE][+-]?[0-9]+))\b""".r ^^ {f => new Value(f.toFloat)}

  def mathExpression:Parser[Any]  = (term ~ rep("[+-]".r ~ term)) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "+" ~ y) => new Add(x,y)
      case (x, "-" ~ y) => new Subtract(x,y)
    }
  }

  def term = factor ~ rep("[*/]".r ~ factor) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "/" ~ y) => new Divide (x.asInstanceOf[Element], y.asInstanceOf[Element])
      case (x, "*" ~ y) => new Multiply (x.asInstanceOf[Element], y.asInstanceOf[Element])
    }.asInstanceOf[Element]
  }

  def factor = "(" ~> mathExpression <~ ")" | number ^^ (x=>x.asInstanceOf[Element])

}
