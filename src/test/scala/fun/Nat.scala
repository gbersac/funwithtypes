package fun

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class NatSpec extends FlatSpec with ShouldMatchers {

  type z = Zero
  type one = Succ[z]
  type two = Succ[one]
  type three = Succ[two]
  type four = Succ[three]

  "Nat" should "be equal" in {

    def eq[A <: Nat, B <: Nat](implicit eq: Equal[A, B]): Unit = ()

    eq[z, z]
    eq[one, one]
    eq[two, two]
    eq[Succ[one], two]
    //eq[one, two]

  }

  "Nat" should "sum" in {

    def sum[A <: Nat, B <: Nat, C <: Nat](implicit sum: Sum.Aux[A, B, C]): Unit = ()

    sum[z, z, z]
    sum[z, one, one]
    sum[one, one, two]
    sum[one, two, Succ[two]]
    sum[two, two, four](Sum.sum2[one, two, four](Sum.sum2[z, three, four](Sum.sum1[four])))
    //sum[one, two, two]

  }

  "Nat" should "prod" in {

    def prod[A <: Nat, B <: Nat, C <: Nat](implicit prod: Prod.Aux[A, B, C]): Unit = ()

    prod[z, z, z]
    prod[z, one, z]
    prod[one, one, one]
    prod[one, two, two]
    prod[two, one, two]
    //prod[two, two, two]

  }
}
