package com.vogon101.SLang.interpreter

/**
 * Contains a value ie string literal, number
 */
class Value (val value:Any) extends Element{

  def run () :Any = value

}
