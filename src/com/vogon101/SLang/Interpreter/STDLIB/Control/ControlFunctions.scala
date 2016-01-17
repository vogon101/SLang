package com.vogon101.SLang.Interpreter.STDLIB.Control

import com.vogon101.SLang.Interpreter.{Element,Function}
import com.vogon101.SLang.Interpreter.STDLIB.Library


/**
 * Created by Freddie Poser on 31/12/2015.
 *
 */
class ControlFunctions extends Library{

  def getFunctions = {
    Map(
      "if" -> new IFFunction,
      "while" -> new WhileFunction,
      "else" -> new ElseFunction,
      "elseif" -> new IFFunction
    )
  }

}


class IFFunction extends Function{

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


class WhileFunction extends Function{

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

/*
class ForEachFunction extends Function{

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
*/

class ReturnFunction {

  def call (args: List[Element]): Any = {
    if (args.length == 1) {
      args(0).run()
    }
    else {
      throw new IllegalArgumentException ("Wrong number of arguments for if function")
    }
  }

}


class ElseFunction extends Function {

  def call (args: List[Element]): Any = {
    if (args.length == 1) {
      args(0).run()
    }
    else {
      throw new IllegalArgumentException ("Wrong number of arguments for if function")
    }
  }

}