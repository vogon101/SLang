package com.vogon101.SLang0.interpreter

import com.vogon101.SLang0.STDLIB.Control.ReturnFunction

/**
 * Created by Freddie Poser on 23/12/2015.
 *
 */
class CodeBlock (var _lines : List[Line]) extends Element{

  def lines = _lines

  def run() :Any = {

    _lines = lines.filter(x =>x!=null)
    lines.foreach({
      case x:FunctionCall => if (x.name == "return") return x.run() else x.run()
      case x => x.run()
    })

  }

}
