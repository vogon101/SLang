package com.vogon101.SLang.interpreter.control

import com.vogon101.SLang.interpreter.Line

/**
 * Created by Freddie Poser on 23/12/2015.
 *
 */
//TODO: Make bs a BooleanExpression
class IfStatement (bs: Any, cb: CodeBlock, elseCB: CodeBlock = null) extends Line{

  def run():Any = {

    //TODO: Make this bs.run()
    if (bs== true) {
      cb.run()
    }
    else {
      if (elseCB != null)
        elseCB.run()
    }

  }

}
