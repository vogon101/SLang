package com.vogon101.SLang.STDLIB.Math

import com.vogon101.SLang.interpreter._

import com.vogon101.SLang.interpreter.Library

/**
 * Created by Freddie Poser on 22/12/2015.
 */
class MathFunctions extends Library{

  def getFunctions = {
    Map(
      "sqrt" -> new SquareRootFunction
    )
  }

}

class SquareRootFunction extends Function ("sqrt"){

  def call (args: List[Element]): Any = {
    if (args.length != 1) {
      throw new IllegalArgumentException ("Wrong number of arguments for require function")
    }
    math.sqrt(args(0).run().toString.toFloat)
  }


}