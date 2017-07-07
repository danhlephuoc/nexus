package nexus

import nexus.exec._
import nexus.cpu._
import nexus.layer._
import nexus.op.activation._
import nexus.op.loss._
import nexus.optimizer._

/**
 * @author Tongfei Chen
 */
object XorTest extends App {

  class Batch; val Batch = new Batch
  class In; val In = new In
  class Hidden; val Hidden = new Hidden
  class Out; val Out = new Out

  val X = DenseTensor.fromNestedArray(Batch::In::$)(Array(
    Array(0f, 0f),
    Array(1f, 0f),
    Array(0f, 1f),
    Array(1f, 1f)
  ))

  val Y = DenseTensor.fromNestedArray(Batch::Out::$)(
    Array(0, 1, 1, 0).map(i => if (i == 0) Array(1f, 0f) else Array(0f, 1f))
  )

  val xs = X along Batch
  val ys = Y along Batch

  val x = Input[DenseTensor[Float, In::$]]()
  val y = Input[DenseTensor[Float, Out::$]]()

  val Layer1 = Affine(In -> 2, Hidden -> 2)
  val Layer2 = Affine(Hidden -> 2, Out -> 2)

  val output = x |> Layer1 |> Sigmoid |> Layer2 |> Softmax
  val loss = LogLoss(output, y)

  val sgd = StochasticGradientDescent(0.1f)

  for (i <- 0 until 100000) {
    for ((xv, yv) <- xs zip ys) {
      val (lossValue, values) = Forward.compute(loss)(x ->> xv, y ->> yv)
      val gradients = Backward.compute(loss, values)
      //println(Layer2.b.value)
      println(s"Epoch $i: loss = ${lossValue()}")
      sgd.update(gradients)
    }
  }
  val bp = 0
}