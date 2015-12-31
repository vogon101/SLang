package com.vogon101.SLang.interpreter.booleans
import com.vogon101.SLang.interpreter.Element

/**
 * Created by Freddie Poser on 27/12/2015.
 */
class BooleanExpression (value: BooleanExpression = null) extends Element{

  def run(): Boolean = value.run()

  override def debug(): Unit = {
    println("BOOLEAN EXPR")
    super.debug()
  }

}

class And (x: Element, y: Element) extends BooleanExpression {

  override def run () = x.run().asInstanceOf[Boolean] && y.run().asInstanceOf[Boolean]

  override def debug(): Unit = {
    println("AND")
    println("LHS")
    println(x.debug())
    println("RHS")
    println(y.debug())
    super.debug()
  }

}

class Or (x: Element, y:Element) extends BooleanExpression {

  override def run() = x.run().asInstanceOf[Boolean] | y.run().asInstanceOf[Boolean]

  override def debug(): Unit = {
    println("OR")
    super.debug()
  }

}

class Equals (x: Element, y:Element) extends BooleanExpression {

  override def run() = x.run() == y.run()

  override def debug(): Unit = {
    println("EQUALS")
    println("LHS")
    println(x.debug())
    //println(x.run())
    println("RHS")
    println(y.debug())
    //println(y.run())
    super.debug()
  }
}

class NotEquals (x: Element, y:Element) extends BooleanExpression {

  override def run() = x.run() != y.run()

  override def debug(): Unit = {
    println("NOT EQUALS")
    println("LHS")
    println(x.debug())
    //println(x.run())
    println("RHS")
    println(y.debug())
    //println(y.run())
    super.debug()
  }

}

class GT (x: Element, y:Element) extends BooleanExpression {

  override def run() = (x.run(), y.run()) match {
    case (x:Int, y:Int) => x > y
    case (x:Float, y:Int) => x > y
    case (x:Int, y:Float) => x > y
    case (x:Float, y:Float) => x > y
  }

}

class LT (x: Element, y:Element) extends BooleanExpression {

  override def run() = (x.run(), y.run()) match {
    case (x:Int, y:Int) => x < y
    case (x:Float, y:Int) => x < y
    case (x:Int, y:Float) => x < y
    case (x:Float, y:Float) => x < y
  }

}

class GTE (x: Element, y:Element) extends BooleanExpression {

  override def run() = (x.run(), y.run()) match {
    case (x:Int, y:Int) => x >= y
    case (x:Float, y:Int) => x >= y
    case (x:Int, y:Float) => x >= y
    case (x:Float, y:Float) => x >= y
  }

}

class LTE (x: Element, y:Element) extends BooleanExpression {

  override def run() = (x.run(), y.run()) match {
    case (x:Int, y:Int) => x <= y
    case (x:Float, y:Int) => x <= y
    case (x:Int, y:Float) => x <= y
    case (x:Float, y:Float) => x <= y
  }

}
