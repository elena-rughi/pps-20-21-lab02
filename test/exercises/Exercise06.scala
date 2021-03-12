package exercises

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

object Exercise06 {

  /*
    Create a function to get the n-th Fibonacci number
    - The first two Fibonacci numbers are 0 and 1. The following Fibonacci
      numbers are given by the sum of their previous two.
    - Signature: fib(n: Int): Int
    - Example: (fib(0),fib(1),fib(2),fib(3),fib(4)) // (0,1,1,2,3)
    - Hint: look at factorial in lecture 02
    - Question: is your recursion a tail one? How could you be sure?
   */

  //@annotation.tailrec //this is NOT a tail recursion
  def fib(n: Int) : Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => fib(n-1) + fib(n-2)
  }

  @Test def testFibonacci = {
    assertEquals(0, fib(0))
    assertEquals(1, fib(1))
    assertEquals(1, fib(2))
    assertEquals(2, fib(3))
    assertEquals(3, fib(4))
    assertEquals(5, fib(5))
    assertEquals(8, fib(6))
  }

}
