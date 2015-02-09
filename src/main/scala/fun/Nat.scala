package fun

sealed trait Nat

sealed trait Zero extends Nat

trait Succ[N <: Nat] extends Nat

trait Equal[A <: Nat, B <: Nat]

object Equal {

  implicit val equalZero = new Equal[Zero, Zero] {}

  implicit def equalSucc[A <: Nat, B <: Nat](implicit eq: Equal[A, B]) = new Equal[Succ[A], Succ[B]] {}

}

trait Sum[A <: Nat, B <: Nat] { type R <: Nat }

object Sum {

  type Aux[A <: Nat, B <: Nat, C <: Nat] = Sum[A, B] { type R = C }

  implicit def sum1[B <: Nat] = new Sum[Zero, B] { type R = B }

  implicit def sum2[A <: Nat, B <: Nat, C <: Nat](implicit sum: Sum[A, Succ[B]]) = new Sum[Succ[A], B] { type R = sum.R }

}

trait Prod[A <: Nat, B <: Nat] { type R <: Nat }

object Prod {

  type Aux[A <: Nat, B <: Nat, C <: Nat] = Prod[A, B] { type R = C }

  implicit def prod1[B <: Nat] = new Prod[Zero, B] { type R = Zero }

  implicit def prod2[A <: Nat, B <: Nat, C <: Nat](implicit prod: Prod.Aux[A, B, C], sum: Sum[B, C]) = new Prod[Succ[A], B] { type R = sum.R }

}