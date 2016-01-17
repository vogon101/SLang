package com.vogon101.SLang.Parser

import com.vogon101.SLang.Interpreter.math._

import scala.util.parsing.combinator.{ PackratParsers, JavaTokenParsers }
import com.vogon101.SLang.Interpreter.{ Value, Element }

/**
 * Created by Freddie Poser on 16/01/2016.
 */
trait MathParsers extends JavaTokenParsers with PackratParsers{

  def element: Parser[Element]
  //def variable: Parser[Any]
  //def value: Parser[Any]

  def number = float | integer

  def integer = """[+-]?\d+""".r ^^ {i => new Value(i.toInt)}
  def float = """[+-]?[0-9]+((\.[0-9]+([eE][+-]?[0-9]+)?[fF]?)|([fF])|([eE][+-]?[0-9]+))\b""".r ^^ {f => new Value(f.toFloat)}

  lazy val mathExpression:PackratParser[Element]  = (term ~ rep("[+-]".r ~ term)) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "+" ~ y) => new Add(x.asInstanceOf[Element],y.asInstanceOf[Element])
      case (x, "-" ~ y) => new Subtract(x.asInstanceOf[Element],y.asInstanceOf[Element])
    }
  }

  lazy val term:PackratParser[Element] = exponent ~ rep("[*/]".r ~ exponent) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "/" ~ y) => new Divide (x.asInstanceOf[Element], y.asInstanceOf[Element])
      case (x, "*" ~ y) => new Multiply (x.asInstanceOf[Element], y.asInstanceOf[Element])
    }
  }

  lazy val exponent:PackratParser[Element] = factor ~ rep("""[\^]""".r ~ factor) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "^" ~ y) => new Power(x.asInstanceOf[Element], y.asInstanceOf[Element])
    }
  }

  lazy val factor:PackratParser[Element] = "(" ~> mathExpression <~ ")" | element | number ^^ (x=>x.asInstanceOf[Element])

}
