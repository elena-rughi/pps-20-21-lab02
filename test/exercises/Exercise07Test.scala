package exercises

import exercises.Exercise07.Shape
import exercises.Exercise07.Shape.{Circle, Rectangle, Square}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Exercise07Test {

  val rectangle = Rectangle(3,7)
  val circle = Circle(6)
  val square = Square(8)

  @Test def testPerimeter = {
    assertEquals(20, Shape.perimeter(rectangle))
    assertEquals(37.7, BigDecimal(Shape.perimeter(circle)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)
    assertEquals(32, Shape.perimeter(square))
  }

  @Test def testArea = {
    assertEquals(21, Shape.area(rectangle))
    assertEquals(113.1, BigDecimal(Shape.area(circle)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)
    assertEquals(64, Shape.area(square))
  }

}
