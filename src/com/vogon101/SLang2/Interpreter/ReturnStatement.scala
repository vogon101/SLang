package com.vogon101.SLang2.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class ReturnStatement (elem: Element) extends Element{

  def run():Any = elem.run()

}
