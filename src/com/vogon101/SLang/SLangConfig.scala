package com.vogon101.SLang

/**
 * Created by Freddie Poser on 26/12/2015.
 */
object SLangConfig {

  val ver = "0.1"

  def CONSOLE_FILE_WELCOME_STRING(mod:String ="") = s"Welcome to SLang Version $ver ${mod}Console File Runner\nEnter a file name to have it interpreted"
  val CONSOLE_FILE_PROMPT_STRING  = "file >"

  def CONSOLE_WELCOME_STRING(mod:String ="") = s"Welcome to SLang Version $ver ${mod}Console Interpreter"
  val CONSOLE_PROMPT_STRING  = "slang >"

}
