package exercises

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object Exercise04 {
  /*
    Currying
      - Implement a predicate that checks whether its arguments x, y, z respect
        the relation x ≤ y ≤ z, in 4 variants (curried/non-curried × val/def)
          val p1: <CurriedFunType> = ...
          val p2: <NonCurriedFunType> = ...
          def p3(...)(...)(...): ... = ...
          def p4(...): ... = ...
          Notice: function types and function literals are syntactically similar
   */

  val p1 : Int => Int => Int => Boolean = x => y => z => x <= y && y <= z
  val p2 : (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y <= z

  def p3(x: Int)(y: Int)(z: Int) : Boolean = x <= y && y <= z
  def p4(x: Int, y: Int, z: Int) : Boolean = x <= y && y <= z

  @Test def testCurrying(): Unit = {
    assertTrue(p1(3)(4)(8))
    assertFalse(p1(3)(1)(8))

    assertTrue(p2(3,4,8))
    assertFalse(p2(3,1,8))

    assertTrue(p3(3)(4)(8))
    assertFalse(p3(3)(1)(8))

    assertTrue(p4(3,4,8))
    assertFalse(p4(3,1,8))
  }

}
