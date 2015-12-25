package com.vogon101.SLang.parsers

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * Created by Freddie Poser on 25/12/2015.
 *
 */
trait SLangMathsParsers extends JavaTokenParsers{

  def number = float | integer

  def integer = wholeNumber ^^ {i => i.toInt}
  def float = """[+-]?[0-9]*((\.[0-9]+([eE][+-]?[0-9]+)?[fF]?)|([fF])|([eE][+-]?[0-9]+))\b""".r ^^ {f => f.toFloat}

}
