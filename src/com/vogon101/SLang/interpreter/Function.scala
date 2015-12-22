package com.vogon101.SLang.interpreter

/**
 * Contains a function, written in scala, that can be called from SLang code
 */
abstract class Function (val name: String){

  def call(args: List[Element]):Any

}
