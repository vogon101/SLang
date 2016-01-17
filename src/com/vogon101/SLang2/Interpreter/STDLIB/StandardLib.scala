package com.vogon101.SLang2.Interpreter.STDLIB

import com.vogon101.SLang2.Interpreter.STDLIB.Control.ControlFunctions
import com.vogon101.SLang2.Interpreter.STDLIB.Math.MathFunctions
import com.vogon101.SLang2.Interpreter.STDLIB.STDIO.STDIOFunctions


/**
 * Created by Freddie Poser on 22/12/2015.
 */
object StandardLib {

  def libs = Map (
    "STDIO" -> new STDIOFunctions(),
    "MATH"  -> new MathFunctions(),
    "CONT"  -> new ControlFunctions()
  )

}
