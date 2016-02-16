package com.vogon101.SLang.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 *
 */
class FunctionDef (codeBlock: CodeBlock, names: List[String]) extends Element{

  def run():Function = new AnonFunction(names, codeBlock)

  override def debug(): Unit = {
    println(s"Function def of ${names.length} arguments to ${codeBlock.debug()}")
    super.debug()
  }

  override def simplify() = new FunctionDef(codeBlock.simplify(), names)

}
