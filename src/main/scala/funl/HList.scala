package funl

/*
  Exercise 2.1
  Encode Heterogeneous List with the Type System
  Since we are working on the type level, we don't need to instantiate, traits are enough
*/

sealed trait HList

/*
  Exercice 1.2
  Implement a type class witnessing that H is the head of HL
  def head[HL <: HList, H](implicit head: Head[HL, H]): Unit = ()
  should only compile if H is the head of HL
*/

/*
  Exercice 1.3
  Implement a type class witnessing that T is the tail of HL
  def tail[HL <: HList, T <: HList](implicit tail: Tail[HL, T]): Unit = ()
  should only compile if T is the tail of HL
*/

/*
  Exercice 1.4
  Implement a type class witnessing that R is the type at the index N of HL
  def typeAt[HL <: HList, I <: Nat, R](implicit typeAt: TypeAt[HL, I, R]): Unit = ()
  should only compile if R is the type at index I of HL
*/

/*
  Exercice 1.5
  Implement a type class witnessing that F exists within HL
  def exists[HL <: HList, F](implicit exists: Exists[HL, F]): Unit = ()
  should only compile if F exists within HL
*/

/*
  Exercice 1.5
  Implement a type class witnessing that MHL is the result of HL mapped by F
  def map[HL <: HList, F, MHL <: HList](implicit mapper: Mapper[HL, F, MHL]): Unit = ()
  should only compile if MHL is the result of HL mapped by F
*/

/*
  Exercice 1.5
  Implement a type class witnessing that MHL is the result of HL flat mapped by F
  def flatMap[HL <: HList, F, MHL <: HList](implicit mapper: FlatMapper[HL, F, MHL]): Unit = ()
  should only compile if MHL is the result of HL flat mapped by F
*/