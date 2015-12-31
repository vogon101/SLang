package com.vogon101.SLang.interpreter

/**
 * Contains a line of code that can be run
 */
abstract class Line extends Runnable {

  def run(): Any

  def debug() = {
    println("Line")
  }

}
