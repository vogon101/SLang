package com.vogon101.SLang.interpreter

/**
 * Contains an Element which is the base of SLang
 *
 */
abstract class Element extends Line with Runnable{

  override def debug() = {
    println("Element")
    super.debug()
  }

}


