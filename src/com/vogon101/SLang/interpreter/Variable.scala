package com.vogon101.SLang.interpreter

/**
 * Contains a reference to a variable
 */
class Variable (val name: String) extends Element{

  def run(): Any = {
    Program.p.getVariable(name)
  }

  override def debug(): Unit = {
    println("Assignment")
    super.debug()
  }

}
