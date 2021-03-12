package exercises

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object Exercise05 {

  /*
    Create a function that implements functional compositions (f°g)(x) = f(g(x))
   */
  // (f: Int => Int, g: Int => Int) => (Int => Int)
  def compose(f: Int => Int, g: Int => Int) : Int => Int = x => f(g(x))

  @Test def testCompose(): Unit = {
    assertEquals(compose(_-1, _*2)(5), 9)
  }

  /*
    Create a generic version of compose
   */
  def composeGen[A , B <: A](f: B => B, g: A => B) : (A => B) = x => f(g(x))
  def add[A: Numeric](x: A) = implicitly[Numeric[A]].plus(_, x)
  def times[A: Numeric](x: A) = implicitly[Numeric[A]].times(_, x)
  @Test def testComposeGen(): Unit = {
    assertEquals(9 ,composeGen(add(-1), times(2))(5))
    assertEquals(9.4 , composeGen(add(-1.0), times(2.0))(5.2))
  }

}
