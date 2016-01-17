package com.vogon101.SLang.Interpreter.STDLIB

import com.vogon101.SLang.Interpreter.Function

/**
 * Contains a map of functions that can be added to a Program so they can be accessed
 */
abstract class Library {

  def getFunctions: Map[String,Function]

}
