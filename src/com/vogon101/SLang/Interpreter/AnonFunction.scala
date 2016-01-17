package com.vogon101.SLang.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class AnonFunction(argNames: List[String], code:CodeBlock) extends Function{

  def call(args:List[Element]): Any = {
    Program().scope.pushNewScope()
    if (args.length != argNames.length)
      throw new Exception(s"Wrong number of arguments for function {anon} [expected ${argNames.length} got ${args.length}")
    args.zipWithIndex.foreach { case (e: Element, i: Int) => {
        Program( ).scope.set( argNames( i ), e.run() )
      }
    }
    val ret = code.run()
    Program().scope.popTopScope()
    ret
  }

  def debug(): Unit = {
    println(s"ANON FUNCTION with ${argNames.length} arguments")
  }



}
