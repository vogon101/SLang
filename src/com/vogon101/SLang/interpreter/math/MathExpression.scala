package com.vogon101.SLang.interpreter.math

import com.vogon101.SLang.interpreter.Element

/**
 * Created by Freddie Poser on 25/12/2015.
 *
 */
class MathExpression (value: MathExpression = null) extends Element{

  def run(): Any = value.run()

}

class Power(a:Element, b:Element) extends MathExpression {
  override def run(): Any = (a.run(),b.run()) match {
    case (a:Int, b:Int) => math.pow(a,b)
    case (a:Float, b:Float) => math.pow(a,b)
    case (a: Int, b:Float) => math.pow(a,b)
    case (a: Float, b:Int) => math.pow(a,b)
  }
}

class Add(a:Element, b:Element) extends MathExpression {
  override def run(): Any = (a.run(),b.run()) match {
    case (a:Int, b:Int) => a+b
    case (a:Float, b:Float) => a+b
    case (a: Int, b:Float) => a+b
    case (a: Float, b:Int) => a+b
    case (a:String, b:String) => a+b

  }
}

class Subtract(a:Element, b:Element) extends MathExpression {
  override def run(): Any = (a.run(),b.run()) match {
    case (a:Int, b:Int) => a-b
    case (a:Float, b:Float) => a-b
    case (a: Int, b:Float) => a-b
    case (a: Float, b:Int) => a-b
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
  }
}