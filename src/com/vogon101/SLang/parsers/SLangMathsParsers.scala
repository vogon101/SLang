package com.vogon101.SLang.parsers

import com.vogon101.SLang.interpreter.{ Element, Value }
import com.vogon101.SLang.interpreter.math._

import scala.util.parsing.combinator.{ PackratParsers, JavaTokenParsers }

/**
 * Created by Freddie Poser on 25/12/2015.
 *
 */
trait SLangMathsParsers extends JavaTokenParsers with PackratParsers{

  //TODO: Make this work with elements

  def element: Parser[Any]
  def variable: Parser[Any]
  def value: Parser[Any]

  def number = float | integer

  def integer = wholeNumber ^^ {i => new Value(i.toInt)}
  def float = """[+-]?[0-9]*((\.[0-9]+([eE][+-]?[0-9]+)?[fF]?)|([fF])|([eE][+-]?[0-9]+))\b""".r ^^ {f => new Value(f.toFloat)}

  lazy val mathExpression:PackratParser[Any]  = (term ~ rep("[+-]".r ~ term)) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "+" ~ y) => new Add(x.asInstanceOf[Element],y.asInstanceOf[Element])
      case (x, "-" ~ y) => new Subtract(x.asInstanceOf[Element],y.asInstanceOf[Element])
    }
  }

  lazy val term:PackratParser[Any] = exponent ~ rep("[*/]".r ~ exponent) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "/" ~ y) => new Divide (x.asInstanceOf[Element], y.asInstanceOf[Element])
      case (x, "*" ~ y) => new Multiply (x.asInstanceOf[Element], y.asInstanceOf[Element])
    }
  }

  lazy val exponent:PackratParser[Any] = factor ~ rep("""[\^]""".r ~ factor) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "^" ~ y) => new Power(x.asInstanceOf[Element], y.asInstanceOf[Element])
    }.asInstanceOf[Element]
  }

  lazy val factor:PackratParser[Any] = "(" ~> mathExpression <~ ")" | element | number ^^ (x=>x.asInstanceOf[Element])

}
