import scala.language.experimental.macros
import scala.reflect.macros.Context

object MacrosMacros {
  def impl(c: Context) = {
    import c.universe._
    c.Expr[Unit](q"""println("Hello World")""")
  }

  def hello: Unit = macro impl
}
