package com.vogon101.SLang2.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class Reference(name: String) extends Element{

  def run():Any = Program().scope.get[Any](name)

  override def debug(): Unit = {
    println(s"Reference to $name")
    super.debug()
  }

}
