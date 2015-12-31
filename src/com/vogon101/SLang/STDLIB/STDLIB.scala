package com.vogon101.SLang.STDLIB

import com.vogon101.SLang.STDLIB.Control.ControlFunctions
import com.vogon101.SLang.STDLIB.Math.MathFunctions
import com.vogon101.SLang.STDLIB.STDIO.STDIOFunctions

/**
 * Created by Freddie Poser on 22/12/2015.
 */
object STDLIB {

  def libs = Map (
    "STDIO" -> new STDIOFunctions(),
    "MATH"  -> new MathFunctions(),
    "CONT"  -> new ControlFunctions()
  )

}
