package com.vogon101.SLang.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 *
 */
abstract class Element extends Line{

  override def debug(): Unit = {
    println("ELEMENT")
    super.debug()
  }

  override def simplify():Element = this

}
