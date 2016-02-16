package com.vogon101.SLang.Interpreter

/**
 * Created by Freddie Poser on 18/01/2016.
 *
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

  override def debug(): Unit = {
    println("IF STATEMENT")
    println("Condition:")
    condition.debug()
    println("OnTrue:")
    onTrue.debug()
    println("OnFalse:")
    onFalse.debug()
    println("END IF STATEMENT")
    super.debug()
  }

  override def simplify() = new IfStatement(condition.simplify(), onTrue.simplify(), onFalse.simplify())

}

class WhileLoop(val condition: Element, val code: Element) extends ControlStatement {

  def run(): Any = {
    while(condition.run().asInstanceOf[Boolean]) {
      code.run()
    }
  }

  override def simplify() = new WhileLoop(condition.simplify(), code.simplify())

}
