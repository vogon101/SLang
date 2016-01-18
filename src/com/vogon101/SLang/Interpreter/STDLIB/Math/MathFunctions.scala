package com.vogon101.SLang.Interpreter.STDLIB.Math

import com.vogon101.SLang.Interpreter.{Element, Function}
import com.vogon101.SLang.Interpreter.STDLIB.Library

/**
 * Created by Freddie Poser on 22/12/2015.
 */
class MathFunctions extends Library{

  def getFunctions = {
    Map(
      "sqrt" -> new SquareRootFunction,
      "toInt" -> new toIntFunction,
      "toFloat" -> new toIntFunction
    )
  }

}


class SquareRootFunction extends Function{
  def call (args: List[Element]): Any = {
    if (args.length != 1) {
      throw new IllegalArgumentException ("Wrong number of arguments for sqrt function")
    }
    math.sqrt(args(0).run().toString.toFloat)
  }
}

class toIntFunction extends Function{
  def call (args: List[Element]): Any = {
    if (args.length != 1) {
      throw new IllegalArgumentException ("Wrong number of arguments for sqrt function")
    }
    args(0).run().toString.toInt
  }
}

class toFloat extends Function{
  def call (args: List[Element]): Any = {
    if (args.length != 1) {
      throw new IllegalArgumentException ("Wrong number of arguments for sqrt function")
    }
    args(0).run().toString.toFloat
  }
}