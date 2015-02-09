package funl

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class HListSpec extends FlatSpec with ShouldMatchers {

  /* should compile
  type z = 
  type one = 
  type two = 

  type HL = String::Int::Long::HNil
  */

  "HList" should "get head" in {
    /* should compile
    def head[HL <: HList, H](implicit head: Head[HL, H]): Unit = ()

    head[HL, String]
    */

    /* should not compile
    head[HL, Int]
    */
  }

  "HList" should "get tail" in {
    /* should compile
    def tail[HL <: HList, T <: HList](implicit tail: Tail[HL, T]): Unit = ()

    tail[HL, Int::Long::HNil]
    */

    /* should not compile
    tail[HL, Int::HNil]
    */
  }

  "HList" should "get the type at" in {

    /* should compile
    def typeAt[HL <: HList, I <: Nat, R](implicit typeAt: TypeAt[HL, I, R]): Unit = ()

    typeAt[HL, z, String]
    typeAt[HL, one, Int]
    typeAt[HL, two, Long]
    */

    /* should not compile
    typeAt[HL, two, String]
    */

  }

  "HList" should "check exists" in {

    /* should compile
    def exists[HL <: HList, F](implicit exists: Exists[HL, F]): Unit = ()

    exists[HL, String]
    exists[HL, Int]
    exists[HL, Long]
    */

    /* should not compile
    exists[HL, Double]
    */

  }

  "HList" should "map" in {

    /* should compile
    def map[HL <: HList, F, MHL <: HList](implicit mapper: Mapper[HL, F, MHL]): Unit = ()

    trait F1

    map[HL, F1, Long::Int::String::HNil]
    */

  }

  "HList" should "flatMap" in {

    /* should compile
    def flatMap[HL <: HList, F, MHL <: HList](implicit mapper: FlatMapper[HL, F, MHL]): Unit = ()

    trait F1

    flatMap[HL, F1, String::String::Int::Int::Long::Long::HNil]
    */

  }

}
