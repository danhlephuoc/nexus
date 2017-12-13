package nexus.impl

import nexus.algebra._
import shapeless._

/**
 * @author Tongfei Chen
 */
package object jvm {

  implicit val cpuFloat32: IsRealTensor[DenseTensor, Float] = CPUFloat32$

  type DenseVector[A] = DenseTensor[A :: HNil]
  type DenseMatrix[A, B] = DenseTensor[A :: B :: HNil]

}