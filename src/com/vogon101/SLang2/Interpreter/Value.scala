package com.vogon101.SLang2.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class Value (value: Any) extends Element{

  def run() = value

  override def debug(): Unit = {
    println(s"VALUE: $value")
    super.debug()
  }

}
