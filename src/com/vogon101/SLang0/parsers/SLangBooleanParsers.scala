package com.vogon101.SLang0.parsers

import com.vogon101.SLang0.interpreter.{ Element, Value }
import com.vogon101.SLang0.interpreter.math._

import scala.util.parsing.combinator.{ PackratParsers, JavaTokenParsers }
import com.vogon101.SLang0.interpreter.booleans._

/**
 * Created by Freddie Poser on 25/12/2015.
 *
 */
trait SLangBooleanParsers extends JavaTokenParsers with PackratParsers{

  //TODO:Fix evaluation of boolean expressions
  //Fails on 2==2 && 3!=4  Needs brackets
  //Parses it as Equals(2,NotEquals(And(2,3),4))
  //Cant fix it now :(

  val element: PackratParser[Any]

  lazy val comparison:PackratParser[Element] = element ~ rep1(("==" | "<=" | ">=" | "!=" | ">" | "<") ~ element) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case ((x:Element), "==" ~ (y:Element)) => new Equals(x,y)
      case ((x:Element), ">"  ~ (y:Element)) => new GT(x,y)
        case ((x:Element), "<"  ~ (y:Element)) => new LT(x,y)
      case ((x:Element), "<=" ~ (y:Element)) => new LTE(x,y)
      case ((x:Element), ">=" ~ (y:Element)) => new GTE(x,y)
      case ((x:Element), "!=" ~ (y:Element)) => new NotEquals(x,y)
    }.asInstanceOf[Element]
  }

  lazy val boolean_expression:PackratParser[Element] = boolean ~ rep1(("|" | "&&") ~ boolean) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "&&" ~ y) => new And(x.asInstanceOf[Element], y.asInstanceOf[Element])
      case (x, "|" ~ y) => new Or(x.asInstanceOf[Element], y.asInstanceOf[Element])
    }
  }

  lazy val boolean:PackratParser[Element] = (
      element ^^ (x=>x.asInstanceOf[Element])
    | "(" ~> comparison <~ ")"
    | "(" ~> boolean_expression <~ ")"
    | "true" ^^ (x =>new Value(true).asInstanceOf[Element])
    | "false" ^^ (x => new Value(false).asInstanceOf[Element])
  )

  /*
  lazy val boolean_expression:PackratParser[Any] = (boolean_factor ~ rep(("==" | ">" | "<" | "<=" | "<=" | "!=") ~ boolean_factor)) ^^ {

    case t ~ ts => ts.foldLeft(t) {
      case (x:Element, "=="~(y:Element)) => new Equals(x,y)
      case (x:Element, ">" ~(y:Element)) => new GT(x,y)
      case (x:Element, "<" ~(y:Element)) => new LT(x,y)
      case (x:Element, ">=" ~(y:Element)) => new GTE(x,y)
      case (x:Element, "<=" ~(y:Element)) => new LTE(x,y)
    }

  }

  lazy val boolean_term:PackratParser[Element] = (boolean_factor ~ rep([&\|]""".r ~ boolean_factor)) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "&" ~y) => new And(x,y)
      case (x, "|" ~y) => new Or (x,y)
    }
  }

  lazy val boolean_factor:PackratParser[Element] = ("(" ~> boolean_expression <~ ")" | element | boolean_literal) ^^ (x=>x.asInstanceOf[Element])

  lazy val boolean_literal:PackratParser[Element] = ("true" | "false") ^^ (x => {
    new Value(x match {case "true" => true; case "false" => false})
  })
  */

}
