package com.vogon101.SLang0.interpreter

/**
 * Contains a reference to a variable
 */
class Variable (val name: String) extends Element{

  def run(): Any = {
    Program.p.getVariable(name)
  }

  override def debug(): Unit = {
    println(s"Variable $name")
    super.debug()
  }

  def set (value: Any): Unit = {
    Program.p.setVariable(name, value)
  }

  def get() = Program.p.getVariable(name)

}
