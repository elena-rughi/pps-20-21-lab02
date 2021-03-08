package exercises

/*
  Get familiar with first-class and higher order functions as well as with the
  different styles for expressing functions
 */
object Exercise03 extends App {
  /*
    a)  implement a function that takes an int and outputs "even" or "odd" as:
        (i) val assigned to function literal (lambda)
        (ii) method syntax
   */

  val parityI : Int => String =
    {
      case x if (x % 2 == 0) => "even"
      case _ => "odd"
    }
  println("a)")
  println("parityI(6) = " + parityI(6))
  println("parityI(7) = " + parityI(7))

  def parityII (x : Int) : String = x match {
    case x if (x % 2 == 0) => "even"
    case _ => "odd"
  }

  println("parityII(6) = " + parityI(6))
  println("parityII(7) = " + parityI(7))

  /*
    b)   Implement a neg function that accepts a predicate (i.e., a function
          mapping values to Booleans) on strings and returns another predicate,
          namely, its negated form; write the type first, and then define the
          function both as a val lambda and with method syntax
   */

  val empty: String => Boolean = _=="" // predicate on strings

  val negI : ((String) => Boolean) => ((String) => Boolean) =
    predicate => (in => !predicate(in))
  val notEmptyI = negI(empty) // predicate on strings

  def negII (predicate: (String) => Boolean) : (String) => Boolean = {
    (in : String) => !predicate(in)
  }
  val notEmptyII = negII(empty) // predicate on strings

  println("\nb)")
  println("empty(\"foo\") = " + empty("foo"))
  println("notEmptyI(\"foo\") = " + notEmptyI("foo"))
  println("notEmptyII(\"foo\") = " + notEmptyII("foo"))

  /*
    c)  Make neg work for generic predicates, and write tests to check it
   */

  def emptyAny[A]: A => Boolean = _==""

  def negAny[A] (predicate: (A) => Boolean) : (A) => Boolean = {
    (in : A) => !predicate(in)
  }
  def notEmptyAny[A] = negAny(emptyAny) // predicate on strings

  println("\nc)")
  println("empty(\"foo\") = " + emptyAny[String]("foo") + "; notEmpty(\"foo\") = " + notEmptyAny("foo"))
  println("empty(\"foo\") = " + emptyAny[Int](36) + "; notEmpty(\"foo\") = " + notEmptyAny[Int](36))

}
