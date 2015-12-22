package com.vogon101.SLang.STDLIB.STDIO

import com.vogon101.SLang.interpreter.{ Value, Library, Function, Element }

import scala.io.StdIn


/**
 * Library for input and output
 */
class STDIOFunctions extends Library {

  def getFunctions = {
    Map(
      "print" -> new PrintFunction(),
      "input" -> new ReadLineFunction()

    )
  }

}

class PrintFunction() extends Function("print"){

  def call (args: List[Element]): Any = {
    args.foreach(x=>{print(x.run())})
    println()
  }


}

class ReadLineFunction () extends Function ("input") {

  def call (args: List[Element]): Any = {
    if (args.length > 1) {
      throw new IllegalArgumentException ("Too many arguments for input function")
    }
    if (args.length == 0)
      return StdIn.readLine()
    StdIn.readLine(args(0).run().toString)
  }

}