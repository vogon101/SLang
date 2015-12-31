package com.vogon101.SLang.interpreter

/**
 * Controls the calling of a function with an array of arguments
 */
class FunctionCall (val name: String, val args: List[Element]) extends Element {

  def run () :Any = {

    //println(s"Running function $name")
    //println("Arguments:")
    //args.foreach(x => println(x))
    val func = Program.p.getFunction(name)
    if (func == null) {
      throw new Exception(s"Function $name not found")
    }
    else {
      func.call(args)
    }

  }

  override def toString: String = {
    val length = args.length
    s"Function : $name with $length args"
  }

  override def debug(): Unit = {
    println("Function Call")
    println("Arguments")
    args.foreach(x=>x.debug())
    println("End Args")
    super.debug()
  }

}
