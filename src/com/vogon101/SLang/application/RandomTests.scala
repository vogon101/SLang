package com.vogon101.SLang.application

import com.vogon101.SLang.parsers.SLangParser

/**
 * Created by Freddie on 30/12/2015.
 */
object RandomTests extends App{

  val p = new SLangParser()
  val r = p.parseAll(p.element, "2==2")
  println(r)
  println(r.get)

}
