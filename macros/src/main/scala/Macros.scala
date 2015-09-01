package macros

import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

import com.typesafe.scalalogging._


object Macro extends LazyLogging {

  def impl(c: Context) = {
    import c.universe._
    logger.debug("I confess, I do not believe in time.")
    c.Expr[Unit](q"""println("hello world")""")
  }

  def hello: Unit = macro impl

  def goodbye = {
    logger.debug("My heart was a hysterical unreliable organ")
    println("goodbye cruel world")
  }
}
