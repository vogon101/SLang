package com.vogon101.SLang2.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class Assignment (name:String, value:Element) extends Line{

  def run():Any = {
    Program().scope.set(name, value.run())
  }

  override def debug(): Unit = {
    println(s"Assignment of $name to ${value.debug()}")
    super.debug()
  }

}
