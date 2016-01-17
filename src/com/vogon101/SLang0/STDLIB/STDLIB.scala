package com.vogon101.SLang0.STDLIB

import com.vogon101.SLang0.STDLIB.Control.ControlFunctions
import com.vogon101.SLang0.STDLIB.Math.MathFunctions
import com.vogon101.SLang0.STDLIB.STDIO.STDIOFunctions

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
