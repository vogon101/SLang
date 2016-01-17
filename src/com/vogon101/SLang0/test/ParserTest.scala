package com.vogon101.SLang0.test

import com.vogon101.SLang0.interpreter.math.{ Subtract, MathExpression, Add }
import com.vogon101.SLang0.interpreter._
import com.vogon101.SLang0.parsers.SLangParser
import org.scalatest._

/**
 * Created by Freddie Poser on 26/12/2015.
 */
class ParserTest extends FlatSpec with Matchers{

  val p = new SLangParser()
  "SLangParser" should "parse print(\"Hello World\") as a function call" in {
    val r = p.parseAll(p.program, "print(\"Hello World\")")
    r.isEmpty should not equal true
    val prog = r.get
    assert(prog.lines(0).asInstanceOf[FunctionCall].name == "print")
    assert(prog.lines(0).asInstanceOf[FunctionCall].args(0).run() == "Hello World")
  }

  it should "parse 2 + 2 as an addition of two values" in {
    val r = p.parseAll(p.program, "2+2")
    r.isEmpty should not equal true
    val prog = r.get
    assert(prog.lines(0).run() == 4)
    assert(prog.lines(0).isInstanceOf[Add])
  }

  it should "parse $myVar as a variable" in {
    val r = p.parseAll(p.line, "$myVar")
    r.isEmpty should not equal true
    val line = r.get
    assert(line.isInstanceOf[Variable])
    assert(line.asInstanceOf[Variable].name == "$myVar")
  }

  it should "parse //comment as an empty comment" in {
    val r = p.parseAll(p.line, "//comment")
    r.isEmpty should not equal true
    val line = r.get
    assert(line.isInstanceOf[Comment])
    line.run()
  }

  it should "parse (32+2)-34 as a subtract, which is a maths expression" in {
    val r = p.parseAll(p.line, "(32+2)-34")
    r.isEmpty should not equal true
    val line = r.get
    assert(line.isInstanceOf[MathExpression])
    assert(line.isInstanceOf[Subtract])
  }

}
