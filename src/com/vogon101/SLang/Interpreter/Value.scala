package com.vogon101.SLang.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class Value (value: Any) extends Element{

  def run() = value match {
    case value:List[Element] => value.map(_.run())
    case value:Element       => value.run()
    case _                   => value
  }

  override def debug(): Unit = {
    println(s"VALUE: $value")
    super.debug()
  }

}
