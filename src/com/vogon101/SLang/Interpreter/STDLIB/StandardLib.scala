package com.vogon101.SLang.Interpreter.STDLIB


import com.vogon101.SLang.Interpreter.STDLIB.Math.MathFunctions
import com.vogon101.SLang.Interpreter.STDLIB.STDIO.STDIOFunctions


/**
 * Created by Freddie Poser on 22/12/2015.
 */
object StandardLib {

  def libs = Map (
    "STDIO" -> new STDIOFunctions(),
    "MATH"  -> new MathFunctions()
  )

}
