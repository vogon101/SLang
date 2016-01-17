package com.vogon101.SLang.Interpreter.Scoping

import scala.reflect.ClassTag

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class Scope {

  private var _variables:Map[String,Any] = Map()

  def get[T](name:String) (implicit t: ClassTag[T]): T = {
    if (!variables.contains(name))
      null.asInstanceOf[T]
    else if (t.runtimeClass.isInstance(variables(name)))
      variables(name).asInstanceOf[T]
    else
      null.asInstanceOf[T]
  }

  def set(name:String, value:Any): Unit = {
    _variables += (name -> value)
  }

  def variables = _variables

}
