package com.vogon101.SLang.application

import com.vogon101.SLang.parsers.SLangParser

/**
 * Created by Freddie Poser on 26/12/2015.
 */
object GeneralConsoleLineApplication extends ConsoleLineApplication{

  def NAME_MODIFIER = ""

  def run(p: SLangParser, text: String): Unit = {

    val r = p.parseAll(p.program, text)
    if (r.isEmpty) {
      println(r)
    }
    r.get.interpret()

  }

}
