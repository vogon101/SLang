package com.vogon101.SLang.interpreter

/**
 * Contains nothing, represent where a comment is in the code
 */
class Comment extends Line{

  def run () ={}

  override def debug(): Unit = {
    println("Comment")
    super.debug()
  }

}
