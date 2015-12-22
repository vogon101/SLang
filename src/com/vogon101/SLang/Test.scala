package com.vogon101.SLang

import com.vogon101.SLang.STDLIB.STDIO.STDIOFunctions
import com.vogon101.SLang.interpreter.{ Value, FunctionCall, Program }
import com.vogon101.SLang.parsers.SLangParser

/**
 * Testing SLang
 */
object Test extends App{

  println("Testing SLANG")

  val parser = new SLangParser()
  val program = new Program(parser, "" +
    "print(\"Hello World\")" +
    ";$myVar = 12;" +
    "print (\"The value of $myVar is \", $myVar);" +
    "$name = input(\"What is your name? \");" +
    "print(\"Hello \",$name);")
  println("Done")
  println("")
  println("====START====")
  println("")
  program.loadLib(new STDIOFunctions())
  program.interpret()

}
