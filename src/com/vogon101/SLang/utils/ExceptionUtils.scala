package com.vogon101.SLang.utils

import java.io.{ PrintWriter, StringWriter }

/**
 * Created by Freddie Poser on 26/12/2015.
 */
object ExceptionUtils {

  def ExceptionToString(e: Throwable): String = {
    val sw = new StringWriter()
    val pw = new PrintWriter(sw, true)
    e.printStackTrace(pw)
    sw.getBuffer.toString
  }

}
