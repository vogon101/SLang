package com.vogon101.SLang.interpreter

import java.util.NoSuchElementException

import com.vogon101.SLang.STDLIB.STDLIB
import com.vogon101.SLang.parsers.SLangParser

/**
 * Created by Freddie on 21/12/2015.
 *
 */
class Program (val lines : List[Line]) {

  Program.addAvailableLibs(STDLIB.libs)

  def this (parser: SLangParser, programText: String) {
    this(parser.parseAll(parser.program, programText).get.lines)
  }

  private var _functions:Map[String, Function] = Map()

  private var _variables:Map[String, Any] = Map()

  Program.setProg(this)

  def interpret(): Unit = {
    lines.foreach(x => {
      x.run()
    })
  }

  def getFunction (name: String): Function = {
    try {
      functions.get( name ).get
    }
    catch {
      case e: NoSuchElementException =>  throw new Exception(s"Function $name not found")
    }
  }

  def functions = _functions

  def variables = _variables

  def addFunction(name:String, function: Function): Unit = {
    _functions += (name -> function)
  }

  def getVariable (name:String): Any = {
    try {
      variables.get( name ).get
    }
    catch {
      case e: NoSuchElementException => throw new Exception(s"Variable $name not found")
    }
  }

  def getVariableOfType [T](name: String) : T = {
    var v: Any = null
    try {
      v = variables.get( name ).get
    }
    catch {
      case e: NoSuchElementException => throw new Exception(s"Variable $name not found")
    }
    v match {
      case x: T => x
      case _ => throw new Exception(s"Variable $name not found of correct type")
    }
  }

  def setVariable (name: String, value: Any): Unit = {
    _variables += (name -> value)
  }

  def loadLib (library: Library): Unit = {
    _functions ++= library.getFunctions
  }

}

object Program {

  private var _program: Program = null

  def setProg (program: Program) = {_program = program}
  def p = _program

  private var _libs: Map[String,Library] = Map()

  def libs = _libs

  def addAvailableLib (name:String,library: Library): Unit = {
    _libs += (name -> library)
  }

  def addAvailableLibs (libs:Map[String, Library]): Unit = {
    _libs ++= libs
  }

}
