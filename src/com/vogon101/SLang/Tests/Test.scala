package com.vogon101.SLang.Tests

import com.vogon101.SLang.STDLIB.STDIO.STDIOFunctions
import com.vogon101.SLang.interpreter.Program
import com.vogon101.SLang.parsers.SLangParser

import scala.io.{ Source, StdIn }

/**
 * Testing SLang
 */
object Test extends App{

  println("Testing SLANG")

  while (true) {
    val parser = new SLangParser( )
    val program = new
         Program( parser, Source.fromFile( "Examples/" + StdIn.readLine( "Enter File to Run (Examples/<file-name>.slang)" ) + ".slang" ).mkString )
    println( "" )
    println( "========START========" )
    println( "" )
    program.loadLib( new STDIOFunctions( ) )
    program.interpret( )
    println( "" )
    println("=======RESTART=======")
    println( "" )
  }

}
