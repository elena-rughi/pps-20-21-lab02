package exercises

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

/*
  Get familiar with first-class and higher order functions as well as with the
  different styles for expressing functions
 */
object Exercise03 {
  /*
    a)  implement a function that takes an int and outputs "even" or "odd" as:
        (i) val assigned to function literal (lambda)
        (ii) method syntax
   */

  val parityI: Int => String = {
    case x if (x % 2 == 0) => "even"
    case _ => "odd"
  }

  @Test def testParityI(): Unit = {
    assertEquals("even", parityI(6))
    assertEquals("odd", parityI(7))
  }

  def parityII(x: Int): String = x match {
    case x if (x % 2 == 0) => "even"
    case _ => "odd"
  }

  @Test def testParityII(): Unit = {
    assertEquals("even", parityII(6))
    assertEquals("odd", parityII(7))
  }

  /*
    b)   Implement a neg function that accepts a predicate (i.e., a function
          mapping values to Booleans) on strings and returns another predicate,
          namely, its negated form; write the type first, and then define the
          function both as a val lambda and with method syntax
   */

  val empty: String => Boolean = _ == "" // predicate on strings

  val negI: ((String) => Boolean) => ((String) => Boolean) =
    predicate => (in => !predicate(in))
  val notEmptyI = negI(empty) // predicate on strings

  def negII(predicate: (String) => Boolean): (String) => Boolean =
    (in: String) => !predicate(in)

  val notEmptyII = negII(empty) // predicate on strings

  @Test def testNeg(): Unit = {
    assertFalse(empty("foo"))
    assertTrue(notEmptyI("foo"))
    assertTrue(notEmptyII("foo"))
  }

  /*
    c)  Make neg work for generic predicates, and write tests to check it
   */

  def emptyAny[A]: A => Boolean = _ == ""

  def negAny[A](predicate: (A) => Boolean): (A) => Boolean =
    (in: A) => !predicate(in)

  def notEmptyAny[A] = negAny(emptyAny) // predicate on strings

  @Test def testGenericNeg(): Unit = {
    assertFalse(emptyAny[String]("foo"))
    assertFalse(emptyAny[Int](36))
    assertTrue(notEmptyAny("foo"))
    assertTrue(notEmptyAny[Int](36))
  }

}
