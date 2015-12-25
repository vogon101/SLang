package com.vogon101.SLang.interpreter

/**
 * Created by Freddie Poser on 23/12/2015.
 *
 */
class CodeBlock (var _lines : List[Line]) extends Element{

  def lines = _lines

  def run() :Any = {

    _lines = lines.filter(x =>x!=null)
    lines.foreach(x=> {
      x.run()
    })

  }

}
