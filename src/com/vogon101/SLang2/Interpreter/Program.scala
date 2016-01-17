package com.vogon101.SLang2.Interpreter

import com.vogon101.SLang2.Interpreter.STDLIB.STDIO.STDIOFunctions
import com.vogon101.SLang2.Interpreter.STDLIB.{Library, StandardLib}
import com.vogon101.SLang2.Interpreter.Scoping.ScopeStack

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class Program (lines:List[Line]){

  Program.setProgram(this)

  val scope = new ScopeStack()

  def run(): Unit = {
    lines.foreach(_.run())
  }

  def loadFunction(name: String, f:Function): Unit = {
    scope.setGlobal(name,f)
  }

  def loadLib(lib:Library): Unit = {
    lib.getFunctions.foreach(t => loadFunction(t._1, t._2))
  }

  def debug(): Unit = {
    println(s"Program with ${lines.length} lines")
    lines.foreach(_.debug())
  }

  Program.addAvailableLibs(StandardLib.libs)
  this.loadLib(new STDIOFunctions())

}

object Program {

  private var _libs: Map[String,Library] = Map()

  def libs = _libs

  def addAvailableLib (name:String,library: Library): Unit = {
    _libs += (name -> library)
  }

  def addAvailableLibs (libs:Map[String, Library]): Unit = {
    _libs ++= libs
  }

  private var _program:Program = null

  def p = _program

  def setProgram (prog: Program) = _program = prog

  def apply () = _program

}
