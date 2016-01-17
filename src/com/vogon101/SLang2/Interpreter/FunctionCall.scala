package com.vogon101.SLang2.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class FunctionCall (name:String, args:List[Element]) extends Element{

  def run():Any = Program().scope.get[Function](name).call(args)

  override def debug(): Unit = {
    println(s"Function Call of $name")
    println("ARGS")
    args.foreach(_.debug())
    println("ENDARGS")
    super.debug()
  }

}
