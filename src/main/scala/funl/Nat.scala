package funl

/*
  Exercise 1.1
  Encode Natural Integer with the Type System
  Since we are working on the type level, we don't need to instantiate, traits are enough
*/

sealed trait Nat

/*
  Exercice 1.2
  Implement a type class witnessing that A equal B
  def eq[A <: Nat, B <: Nat](implicit eq: Equal[A, B]): Unit = ()
  should only compile if A == B
*/

/*
  Exercice 1.3
  Implement a type class witnessing that C is the sum of A and B
  def sum[A <: Nat, B <: Nat, C <: Nat](implicit sum: Sum[A, B, C]): Unit = ()
  should only compile if A + B == C
*/

/*
  Exercice 1.4
  Implement a type class witnessing C is the product of A and B
  def prod[A <: Nat, B <: Nat, C <: Nat](implicit prod: Prod[A, B, C]): Unit = ()
  should only compile if A * B == C
*/
