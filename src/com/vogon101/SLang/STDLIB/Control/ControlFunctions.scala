package com.vogon101.SLang.STDLIB.Control

import com.vogon101.SLang.interpreter.{ Variable, Element, Function, Library }

/**
 * Created by Freddie Poser on 31/12/2015.
 */
class ControlFunctions extends Library{

  //TODO: Add returns

  def getFunctions = {
    Map(
      "if" -> new IFFunction,
      "while" -> new WhileFunction,
      "foreach" -> new ForEachFunction,
      "return" -> new ReturnFunction
    )
  }

}

class IFFunction extends Function ("if"){

  def call (args: List[Element]): Any = {
    if (args.length == 2) {
      val cond = args(0).run()
      if (cond == true)
        return args(1).run()
    }
    else if (args.length == 3) {
      val cond = args(0).run()
      if (cond == true)
        args(1).run()
      else
        args(2).run()
    }
    else {
      throw new IllegalArgumentException ("Wrong number of arguments for if function")
    }
  }

}

class WhileFunction extends Function ("while"){

  def call (args: List[Element]): Any = {
    if (args.length == 2) {
      val cond = args(0)
      while (cond.run() == true)
        args(1).run()
    }
    else {
      throw new IllegalArgumentException ("Wrong number of arguments for if function")
    }
  }

}

class ForEachFunction extends Function ("foreach"){

  def call (args: List[Element]): Any = {
    if (args.length == 3) {
      val variable = args(0).asInstanceOf[Variable]
      val iter = args(1).run().asInstanceOf[Iterable[Any]]
      val code = args(2)
      iter.foreach(x=>{variable.set(x);code.run()})
    }
    else {
      throw new IllegalArgumentException ("Wrong number of arguments for if function")
    }
  }

}

class ReturnFunction extends Function("return") {

  def call (args: List[Element]): Any = {
    if (args.length == 1) {
      args(0).run()
    }
    else {
      throw new IllegalArgumentException ("Wrong number of arguments for if function")
    }
  }

}