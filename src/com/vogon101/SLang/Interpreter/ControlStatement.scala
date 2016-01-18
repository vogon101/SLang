package com.vogon101.SLang.Interpreter

/**
 * Created by Freddie Poser on 18/01/2016.
 */
abstract class ControlStatement extends Element{

}

class IfStatement(val condition: Element, val onTrue: Element, val onFalse: Element) extends ControlStatement {

  def run(): Any = {
    if(condition.run().asInstanceOf[Boolean]) {
      onTrue.run()
    }
    else {
      onFalse.run()
    }
  }

}

class WhileLoop(val condition: Element, val code: Element) extends ControlStatement {

  def run(): Any = {
    while(condition.run().asInstanceOf[Boolean]) {
      code.run()
    }
  }

}
