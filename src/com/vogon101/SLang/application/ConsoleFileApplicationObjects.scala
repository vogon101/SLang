package com.vogon101.SLang.application

import com.vogon101.SLang.parsers.SLangParser

/**
 * Created by Freddie Poser on 26/12/2015.
 */
object DebugConsoleFileApplication extends ConsoleFileApplication{

  def NAME_MODIFIER = "Debug "

  override def run(p:SLangParser, text:String): Unit = {
    val r = p.parseAll(p.program, text)
    println(r)
    r.get.interpret()
  }

}

object GeneralConsoleFileApplication extends ConsoleFileApplication{

  def NAME_MODIFIER = ""

}

object DebugTestsExampleDir extends ConsoleFileApplication{

  def NAME_MODIFIER = "Examples "

  override def DIRECTORY = "Examples/"

  override def ADD_EXT = true

}