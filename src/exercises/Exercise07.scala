package exercises

object Exercise07 {
  /*
    Define a set of geometric shapes and methods for calculating their
    perimeter and area
    - Define an abstract type Shape
    - Define concrete types Rectangle, Circle, and Square as
      case classes; these product types should exhibit the typical geometric
      properties you would expect to characterise the corresponding shapes
    - Define a module with two methods perimeter(shape: Shape): Double
      and area(shape: Shape): Double for computing perimeter and area
    - You may want to address this exercise through a TDD process
   */

  sealed trait Shape
  object Shape {

    case class Rectangle(sideA: Double, sideB: Double) extends Shape
    case class Circle(radius: Double) extends Shape
    case class Square(side: Double) extends Shape

    def perimeter(shape: Shape) : Double = shape match {
      case Rectangle(sideA, sideB) => 2*sideA + 2*sideB
      case Circle(radius) => 2*Math.PI*radius
      case Square(side) => side*4
    }

    def area(shape: Shape) : Double = shape match {
      case Rectangle(sideA, sideB) => sideA * sideB
      case Circle(radius) => Math.PI*radius*radius
      case Square(side) => side*side
    }

  }
}
