package com.vogon101.SLang.interpreter

/**
 * Contains a value ie string literal, number
 */
class Value (val value:Any) extends Element{

  def run () :Any = {
    value match {
      case v:List[Value] => v.map(x=>x.run())
      case v:Value =>v.run()
      case v => v
    }
  }

}
