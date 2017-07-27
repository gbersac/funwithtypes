package fun

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class HListSpec extends FlatSpec with ShouldMatchers {

  type z = Zero
  type one = Succ[z]
  type two = Succ[one]
  type three = Succ[two]
  type four = Succ[three]

  type HL = String::Int::Long::HNil

  "HList" should "get head" in {
    def head[HL <: HList, H](implicit head: Head.Aux[HL, H]): Unit = ()

    head[HNil, HNil]
    head[HL, String]
  }

  "HList" should "get tail" in {
    def tail[HL <: HList, T <: HList](implicit tail: Tail.Aux[HL, T]): Unit = ()

    tail[HL, Int::Long::HNil]
  }

  "HList" should "get the type at" in {

    def typeAt[HL <: HList, I <: Nat, R](implicit typeAt: TypeAt.Aux[HL, I, R]): Unit = ()

    typeAt[HL, z, String]
    typeAt[HL, one, Int]
    typeAt[HL, two, Long]

  }

  "HList" should "check exists" in {

    def exists[HL <: HList, F](implicit exists: Exists[HL, F]): Unit = ()

    exists[HL, String]
    exists[HL, Int]
    exists[HL, Long]

  }

  "HList" should "map" in {

    def map[HL <: HList, F, MHL <: HList](implicit mapper: Mapper.Aux[HL, F, MHL]): Unit = ()

    trait F1

    implicit val caseString = new Case[F1, String, Long]
    implicit val caseInt = new Case[F1, Int, Int]
    implicit val caseLong = new Case[F1, Long, String]


    map[HL, F1, Long::Int::String::HNil]

  }

  "HList" should "prepend" in {
    def prepend[HLA <: HList, HLB <: HList, HLC <: HList](implicit prepend: Prepend.Aux[HLA, HLB, HLC]): Unit = ()

    prepend[HL, Int::Long::HNil, String::Int::Long::Int::Long::HNil]
  }

  "HList" should "flatMap" in {

    def flatMap[HL <: HList, F, MHL <: HList](implicit mapper: FlatMapper.Aux[HL, F, MHL]): Unit = ()

    trait F1

    implicit def caseDefault[A] = new Case[F1, A, A::A::HNil]

    flatMap[HL, F1, String::String::Int::Int::Long::Long::HNil]

  }

}
