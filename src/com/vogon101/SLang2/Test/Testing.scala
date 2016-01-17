package com.vogon101.SLang2.Test

import com.vogon101.SLang2.Parser.SLangParser

import scala.io.{ Source, StdIn }

/**
 * Created by Freddie Poser on 16/01/2016.
 */
object Testing extends App{

  while(true) {
    val path = "Examples\\2\\" + StdIn.readLine( ">>" ) + ".slang"
    val text = Source.fromFile( path ).mkString
    val p = new SLangParser()
    val parsed = p.parseAll(p.program, text)
    println(parsed)
    if (!parsed.isEmpty){
      println(parsed.get)
      //parsed.get.debug()
      parsed.get.run()
    }

  }

}
