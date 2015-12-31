package com.vogon101.SLang.application

import com.vogon101.SLang.parsers.SLangParser

/**
 * Created by Freddie Poser on 26/12/2015.
 */
object DebugConsoleLineApplication extends ConsoleLineApplication{

  def NAME_MODIFIER = "debug "
  
  def run(p: SLangParser, text: String): Unit = {

    val r = p.parseAll( p.program, text )
    println( r )
    r.get.debug()
    r.get.interpret( )

  }

}
