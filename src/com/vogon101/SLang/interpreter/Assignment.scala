package com.vogon101.SLang.interpreter

/**
 * Controls the assignment of one variable to one value, NOT BY REFERENCE
 */
class Assignment (val variable: String, val value: Element) extends Line{

  def run(): Any = {
    //println(variable)
    Program.p.setVariable(variable, value.run())
  }

  //println("Variable: " + variable)
  //println(s"Value: $value")

}
