package com.vogon101.SLang0.interpreter

/**
 * Contains a map of functions that can be added to a Program so they can be accessed
 */
abstract class Library {

  def getFunctions: Map[String,Function]

}
