package com.vogon101.SLang.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 *
 */
class ReturnStatement (elem: Element) extends Element{

  def run():Any = elem.run()

  override def simplify() = new ReturnStatement(elem.simplify())

}
