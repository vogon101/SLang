package com.vogon101.SLang.application

import java.io.FileNotFoundException

import com.vogon101.SLang.SLangConfig
import com.vogon101.SLang.parsers.SLangParser
import com.vogon101.SLang.utils.ExceptionUtils

import scala.io.{ Source, StdIn }

/**
 * Created by Freddie Poser on 26/12/2015.
 */
object ConsoleFileRunner {

  def NAME_MODIFIER: String = ""

  def DIRECTORY: String = ""

  def ADD_EXT = false

  def main (args:Array[String]): Unit = {
    if (args.length < 1) {
      println("Please pass a file as an argument")
      return
    }
    while (true) {
      val parser = new SLangParser( )
      try {
        val path =  DIRECTORY + args(0) + (if (ADD_EXT) ".slang" else "")
        val text = Source.fromFile( path ).mkString
        run( parser, text )
      }
      catch {
        case e:FileNotFoundException => println("Could not find file"); println(ExceptionUtils.ExceptionToString(e))
        case e:MatchError => println("Type error encountered"); println(ExceptionUtils.ExceptionToString(e))
        case e:RuntimeException => println(ExceptionUtils.ExceptionToString(e))

      }
    }
  }

  def run (p: SLangParser, text: String): Unit = {
    val r = p.parseAll(p.program, text)
    r.get.interpret()
  }

}
