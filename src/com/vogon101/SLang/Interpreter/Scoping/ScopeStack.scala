package com.vogon101.SLang.Interpreter.Scoping

import scala.collection.immutable.Stack
import scala.reflect.ClassTag

/**
 * Created by Freddie Poser on 16/01/2016.
 */
class ScopeStack extends Scope{

  private var _scopes = Stack[Scope]()

  pushNewScope()

  override def get[T](name:String)(implicit t: ClassTag[T]): T = {

    val v = scopes.toList.map(U=>U.get[T](name)).filter(_ != null)
    if (v.length == 0)
      null.asInstanceOf[T]
    else
      v(v.length-1)

  }

  override def set(name:String, value:Any): Unit = {
    scopes.top.set(name, value)
  }

  def setGlobal(name:String, value:Any) = {
    scopes.head.set(name,value)
  }

  def pushNewScope (): Unit = {
    _scopes = _scopes push new Scope()
  }

  def popTopScope (): Unit = {
    _scopes = _scopes.pop
  }

  def runInScope (code:()=>Any) : Any = {
    pushNewScope()
    code()
    popTopScope()
  }

  def scopes = _scopes

}
