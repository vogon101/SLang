package com.vogon101.SLang.Interpreter.math

import com.vogon101.SLang.Interpreter.{Value, Element}

/**
 * Created by Freddie Poser on 25/12/2015.
 *
 */
abstract class MathExpression extends Element{

  override def debug(): Unit = {
    println("Math Expression")
    super.debug()
  }

}

abstract class BinaryOp(lhs:Element, rhs:Element) extends MathExpression {

  override def simplify() = (lhs.simplify(), rhs.simplify()) match {
    case (a:Value, b:Value) => new Value(run())
    case _ => this
  }

}

class Power(a:Element, b:Element) extends BinaryOp(a,b) {
  override def run(): Any = {
    val result = (a.run(),b.run()) match {
      case (a:Int, b:Int) => math.pow(a,b)
      case (a:Float, b:Float) => math.pow(a,b)
      case (a: Int, b:Float) => math.pow(a,b)
      case (a: Float, b:Int) => math.pow(a,b)
    }
    if(result % 1 == 0) {
      return result.toInt
    }
    result.toFloat
  }
}


class Add(a:Element, b:Element) extends BinaryOp(a,b) {
  override def run(): Any = (a.run(),b.run()) match {
    case (a:Int, b:Int) => a+b
    case (a:Float, b:Float) => a+b
    case (a: Int, b:Float) => a+b
    case (a: Float, b:Int) => a+b
    case (a:String, b:String) => a+b
    case (a:List[Any], b:Any) => a :+ b
  }
  override def debug(): Unit = {
    println(s"Add ${a.debug()} + ${b.debug()}")
    super.debug()
  }
}


class Subtract(a:Element, b:Element) extends BinaryOp(a,b) {
  override def run(): Any = (a.run(),b.run()) match {
    case (a:Int, b:Int) => a-b
    case (a:Float, b:Float) => a-b
    case (a: Int, b:Float) => a-b
    case (a: Float, b:Int) => a-b
    case (a:List[Any], b:Any) => a.filter(x=>x!=b)
  }
}


class Divide(a:Element, b:Element) extends BinaryOp(a,b) {
  override def run(): Any = {(a.run(),b.run()) match {
    case (a:Int, b:Int) => a/b
    case (a:Float, b:Float) => a/b
    case (a: Int, b:Float) => a/b
    case (a: Float, b:Int) => a/b
  }}
}


class Multiply (a:Element, b:Element) extends BinaryOp(a,b) {
  override def run(): Any = (a.run(),b.run()) match {
    case (a:Int, b:Int) => a*b
    case (a:Float, b:Float) => a*b
    case (a: Int, b:Float) => a*b
    case (a: Float, b:Int) => a*b
    case (a:String, b:Int) => a*b
  }
}