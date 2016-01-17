package com.vogon101.SLang2.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class CodeBlock(code: List[Line]) extends Element{

  def run(): Any = {
    for (x <- code){
      if (x.isInstanceOf[ReturnStatement])
        return x.run()
      x.run()
    }
    null
  }

  override def debug(): Unit = {
    println(s"CodeBlock with ${code.length} lines")
    super.debug()
  }
}
