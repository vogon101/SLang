package com.vogon101.SLang.application

import com.vogon101.SLang.SLangConfig
import com.vogon101.SLang.parsers.SLangParser
import com.vogon101.SLang.utils.ExceptionUtils

/**
 * Created by Freddie Poser on 25/12/2015.
 */
trait ConsoleLineApplication extends App {

  def NAME_MODIFIER: String

  frame()

  def frame (): Unit = {
    val p = new SLangParser()
    println (SLangConfig.CONSOLE_WELCOME_STRING(NAME_MODIFIER))
    while (true) {
      try {
        run( p, readLine( SLangConfig.CONSOLE_PROMPT_STRING ) )
      }
      catch {
        case e:MatchError => println("Type error encountered"); println(ExceptionUtils.ExceptionToString(e))
        case e:RuntimeException => println(ExceptionUtils.ExceptionToString(e))
      }
    }
  }

  def run(p: SLangParser, text:String)

}
