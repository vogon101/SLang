package com.vogon101.SLang0.interpreter

/**
 * Controls the assignment of one variable to one value, NOT BY REFERENCE
 */
class Assignment (val variable: String, val value: Element) extends Line{

  def run(): Any = {
    //println(variable)
    Program.p.setVariable(variable, value.run())
  }

  override def debug(): Unit = {
    println("Assignment")
    super.debug()
  }

  //println("Variable: " + variable)
  //println(s"Value: $value")

}
