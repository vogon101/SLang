package com.vogon101.SLang.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 *
 */
class CodeBlock(code: List[Line]) extends Element{

  def this() = this(List())

  def run(): Any = {
    for (x <- code){
      if (x.isInstanceOf[ReturnStatement])
        return x.run()
      x.run()
    }
    null
  }

  override def simplify() = new CodeBlock(code.map(_.simplify()))

  override def debug(): Unit = {
    println(s"CodeBlock with ${code.length} lines")
    super.debug()
  }
}
