package nexus.instances

import nexus._

object FloatIsReal extends IsReal[Float] {
  type R = Float
  def B = BoolIsBool
  
  val one = 1f
  val zero = 0f
  def add(x: R, y: R) = x + y
  def sub(x: R, y: R) = x - y
  def neg(x: R) = -x
  def mul(x: R, y: R) = x * y
  def div(x: R, y: R) = x / y
  def inv(x: R) = 1f / x

  override def addScalar(x1: R, x2: Double) = x1 + x2.toFloat

  def abs(x: R) = Math.abs(x)
  def sgn(x: R) = Math.signum(x)
  def sqr(x: R) = x * x
  def sqrt(x: R) = Math.sqrt(x).toFloat
  def exp(x: R) = Math.exp(x).toFloat
  def log(x: R) = Math.log(x).toFloat
  def expm1(x: R) = Math.expm1(x).toFloat
  def log1p(x: R) = Math.log1p(x).toFloat
  def sin(x: R) = Math.sin(x).toFloat
  def cos(x: R) = Math.cos(x).toFloat
  def tan(x: R) = Math.tan(x).toFloat
  def arcsin(x: R) = Math.asin(x).toFloat
  def arccos(x: R) = Math.acos(x).toFloat
  def arctan(x: R) = Math.atan(x).toFloat
  override def fromDouble(a: Double) = a.toFloat
  override def fromInt(n: Int) = n.toFloat

  def toFloat(x: R) = x

  override def addInplace(x1: R, x2: R) = x1 + x2

  override def toString = "Float"
}

object DoubleIsReal extends IsReal[Double] {
  type R = Double

  def one = 1d
  def zero = 0d
  def add(x: R, y: R) = x + y
  def sub(x: R, y: R) = x - y
  def neg(x: R) = -x
  def mul(x: R, y: R) = x * y
  def div(x: R, y: R) = x / y
  def inv(x: R) = 1d / x

  override def addScalar(x1: R, x2: R) = x1 + x2

  def abs(x: R) = Math.abs(x)
  def sgn(x: R) = Math.signum(x)
  def sqr(x: R) = x * x
  def sqrt(x: R) = Math.sqrt(x)
  def exp(x: R) = Math.exp(x)
  def log(x: R) = Math.log(x)
  def expm1(x: R) = Math.expm1(x)
  def log1p(x: R) = Math.log1p(x)
  def sin(x: R) = Math.sin(x)
  def cos(x: R) = Math.cos(x)
  def tan(x: R) = Math.tan(x)
  def arcsin(x: R) = Math.asin(x)
  def arccos(x: R) = Math.acos(x)
  def arctan(x: R) = Math.atan(x)

  override def fromDouble(a: R) = a
  override def fromInt(n: Int) = n

  def toFloat(x: R) = x.toFloat

  override def addInplace(x1: R, x2: R) = x1 + x2

  override def toString = "Double"
}
