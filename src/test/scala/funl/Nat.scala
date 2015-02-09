package funl

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class NatSpec extends FlatSpec with ShouldMatchers {

  /* should compile
  type z = 
  type one = 
  type two = 
  type three = 
  type four = 
  */

  "Nat" should "be equal" in {

    /* should compile
    def eq[A <: Nat, B <: Nat](implicit eq: Equal[A, B]): Unit = ()

    eq[z, z]
    eq[one, one]
    eq[two, two]
    eq[Succ[one], two]
    */

    /* should not compile
    eq[one, two]
    */

  }

  "Nat" should "sum" in {

    /* should compile
    def sum[A <: Nat, B <: Nat, C <: Nat](implicit sum: Sum[A, B, C]): Unit = ()

    sum[z, z, z]
    sum[z, one, one]
    sum[one, one, two]
    sum[one, two, Succ[two]]
    sum[two, two, four]
    */

    /* should not compile
    sum[one, two, two]
    */

  }

  "Nat" should "prod" in {

    /* should compile
    def prod[A <: Nat, B <: Nat, C <: Nat](implicit prod: Prod[A, B, C]): Unit = ()

    prod[z, z, z]
    prod[z, one, z]
    prod[one, one, one]
    prod[one, two, two]
    prod[two, one, two]
    */

    /* should not compile
    prod[two, two, two]
    */

  }
}
