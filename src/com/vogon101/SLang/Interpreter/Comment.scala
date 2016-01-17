package com.vogon101.SLang.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class Comment extends Line{

  def run(): Any = {}

  override def debug(): Unit = {
    println(s"Comment")
    super.debug()
  }

}
