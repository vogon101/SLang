package com.vogon101.SLang2.Interpreter.STDLIB.STDIO

import com.vogon101.SLang2.Interpreter.STDLIB.Library
import com.vogon101.SLang2.Interpreter._

import scala.io.StdIn


/**
 * Library for input and output
 */
class STDIOFunctions extends Library {

  def getFunctions = {
    Map(
      "print" -> new PrintFunction( ),
      "input" -> new ReadLineFunction( ),
      "require" -> new RequireLibFunction( )
    )
  }

}


class PrintFunction() extends Function{

  def call (args: List[Element]): Any = {
    args.foreach(x=>{print(x.run())})
    //println(args.tail.run())
    if(args.length > 0 && args(args.length-1).run() != "")
      println()
  }


}


class ReadLineFunction () extends Function {

  def call (args: List[Element]): Any = {
    if (args.length > 1) {
      throw new IllegalArgumentException ("Too many arguments for input function")
    }
    if (args.length == 0)
      return StdIn.readLine()
    StdIn.readLine(args(0).run().toString)
  }

}


class RequireLibFunction () extends Function {

  def call (args: List[Element]): Any = {
    if (args.length != 1) {
     throw new IllegalArgumentException ("Wrong number of arguments for require function")
    }

    val name = args(0).run().toString
    val lib = Program.libs.get(name)
    if (lib.isEmpty) {
      throw new Exception (s"Library $name is not available")
    }
    Program.p.loadLib(lib.get)


  }

}