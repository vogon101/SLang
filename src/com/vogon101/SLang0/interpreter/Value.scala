package com.vogon101.SLang0.interpreter

/**
 * Contains a value ie string literal, number
 */
class Value (val value:Any) extends Element{

  def run () :Any = {
    value match {
      case v:List[Element] => v.map(x=>x.run())
      case v:Value =>v.run()
      case v => v
    }
  }

  override def debug(): Unit = {
    println("Value")
    super.debug()
  }

}
