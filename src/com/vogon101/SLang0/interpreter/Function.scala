package com.vogon101.SLang0.interpreter

/**
 * Contains a function, written in scala, that can be called from SLang code
 */
abstract class Function (val name: String){

  def call(args: List[Element]):Any

}

class AnonomousFunctuion(element: Element) extends Function("Anon-" + Math.random()){

  def call(args:List[Element]) = element.run()

}

