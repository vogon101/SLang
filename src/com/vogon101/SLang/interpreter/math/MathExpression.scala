package com.vogon101.SLang.interpreter.math

import com.vogon101.SLang.interpreter.Element

/**
 * Created by Freddie Poser on 25/12/2015.
 *
 */
class MathExpression (value: MathExpression = null) extends Element{

  def run(): Any = value.run()

  override def debug(): Unit = {
    println("Math Expression")
    super.debug()
  }

}

class Power(a:Element, b:Element) extends MathExpression {
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

class Add(a:Element, b:Element) extends MathExpression {
  override def run(): Any = (a.run(),b.run()) match {
    case (a:Int, b:Int) => a+b
    case (a:Float, b:Float) => a+b
    case (a: Int, b:Float) => a+b
    case (a: Float, b:Int) => a+b
    case (a:String, b:String) => a+b
    case (a:List[Any], b:Any) => a :+ b

  }
}

class Subtract(a:Element, b:Element) extends MathExpression {
  override def run(): Any = (a.run(),b.run()) match {
    case (a:Int, b:Int) => a-b
    case (a:Float, b:Float) => a-b
    case (a: Int, b:Float) => a-b
    case (a: Float, b:Int) => a-b
    case (a:List[Any], b:Any) => a.filter(x=>x!=b)
  }
}

class Divide(a:Element, b:Element) extends MathExpression {
  override def run(): Any = {(a.run(),b.run()) match {
    case (a:Int, b:Int) => a/b
    case (a:Float, b:Float) => a/b
    case (a: Int, b:Float) => a/b
    case (a: Float, b:Int) => a/b
  }}
}

class Multiply (a:Element, b:Element) extends MathExpression {
  override def run(): Any = (a.run(),b.run()) match {
    case (a:Int, b:Int) => a*b
    case (a:Float, b:Float) => a*b
    case (a: Int, b:Float) => a*b
    case (a: Float, b:Int) => a*b
    case (a:String, b:Int) => a*b
  }
}