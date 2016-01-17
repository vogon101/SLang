package com.vogon101.SLang0.test

import com.vogon101.SLang0.interpreter.{ FunctionCall, Assignment, Program, Value }
import com.vogon101.SLang0.interpreter.math.Add
import org.scalatest.exceptions.TestFailedException
import org.scalatest.{ Matchers, FlatSpec }

/**
 * Created by Freddie Poser on 26/12/2015.
 */
class ProgramTest extends FlatSpec with Matchers{

  val program = new Program(List())

  "Add(2,2)" should "resolve to 4" in {
    assert(new Add(new Value(2),new Value(2)).run() == 4)
  }

  "Assigning $myVar to 2" should "leave the variable as two" in {
    new Assignment("$myVar", new Value(2)).run() == null
    assert(Program.p.getVariable("$myVar") == 2)
  }

  "Loading math then calling sqrt(16)" should "return 4" in {
    Program.p.loadLib(Program.libs("MATH"))
    assert(new FunctionCall("sqrt", List(new Value(16))).run() == 4)
  }

  "A function call's toString" should "return the correct info" in {
    assert(new FunctionCall("test", List()).toString() == "Function : test with 0 args")
  }

  "A function call" should "throw an error if the function is not found" in {
    try {
      new FunctionCall( "notAFunction", List( ) ).run()
      fail()
    }
    catch {
      case e: TestFailedException => fail()
      case e: Exception =>
    }
  }


}
