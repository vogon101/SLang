package com.vogon101.SLang.Tests

import com.vogon101.SLang.parsers.SLangParser

/**
 * Created by Freddie Poser on 25/12/2015.
 */
object AnyTest extends App {

  val p = new SLangParser()
  println(p.parseAll(p.program, "print (2)"))

}
