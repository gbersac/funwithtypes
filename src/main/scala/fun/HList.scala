package fun

sealed trait HList

trait ::[H, T <: HList] extends HList

sealed trait HNil extends HList

trait Head[HL <: HList] { type R }

object Head {

  type Aux[HL <: HList, H] = Head[HL] { type R = H }

  implicit val nilHead = new Head[HNil] { type R = HNil }
  implicit def head[H, HL <: ::[H, _]] = new Head[HL] { type R = H }

}

trait Tail[HL <: HList] { type R <: HList }

object Tail {

  type Aux[HL <: HList, T <: HList] = Tail[HL] { type R = T }

  implicit def tail[T <: HList, HL <: ::[_, T]] = new Tail[HL] { type R = T }

}

trait TypeAt[HL <: HList, I <: Nat] { type R }

object TypeAt {

  type Aux[HL <: HList, I <: Nat, C] = TypeAt[HL, I] { type R = C }

  implicit def typeAt1[H, T <: HList]: Aux[H::T, Zero, H] = new TypeAt[H::T, Zero] { type R = H }

  implicit def typeAt2[H, T <: HList, I <: Nat](implicit typeAt: TypeAt[T, I]) = new TypeAt[H::T, Succ[I]] { type R = typeAt.R }

}

trait Exists[HL <: HList, F]

object Exists {

  implicit def exists1[F, T <: HList] = new Exists[F::T, F] {}

  implicit def exists2[F, H, T <: HList](implicit exists: Exists[T, F]) = new Exists[H::T, F] {}

}


class Case[F, I, O]

trait Mapper[HL <: HList, F] { type R <: HList }

object Mapper {

  type Aux[HL <: HList, F, MHL <: HList] = Mapper[HL, F] { type R = MHL }

  implicit def map1[F, H, RR](implicit caseM: Case[F, H, RR]) = new Mapper[H::HNil, F] { type R = RR::HNil }

  implicit def map2[H, T <: HList, F, RR](implicit caseM: Case[F, H, RR], mapper: Mapper[T, F]) = new Mapper[H::T, F] { type R = RR::mapper.R}

}

trait Prepend[HLA <: HList, HLB <: HList] { type R <: HList }

object Prepend {

  type Aux[HLA<: HList, HLB <: HList, C <: HList] = Prepend[HLA, HLB] { type R = C }

  implicit def prepend1[HA, HLA <: HList] = new Prepend[HA :: HNil, HLA] { type R = HA :: HLA }

  implicit def prepend2[HA, TA <: HList, HLA <: HList, C <: HList](implicit prepend: Prepend.Aux[TA, HLA, C]) = new Prepend[HA :: TA, HLA] { type R = HA :: C }

}

trait FlatMapper[HL <: HList, F] { type R <: HList }

object FlatMapper {

  type Aux[HL <: HList, F, MHL <: HList] = FlatMapper[HL, F] { type R = MHL }

  implicit def flatMap1[F, H, RR <: HList](implicit caseFM: Case[F, H, RR]) = new FlatMapper[H::HNil, F] { type R = RR }

  implicit def flatMap2[F, H, T <: HList, RR <: HList, RRR <: HList, RRRR <: HList](implicit caseFM: Case[F, H, RR], flatMapper: FlatMapper.Aux[T, F, RRR], prepend: Prepend.Aux[RR, RRR, RRRR]) = new FlatMapper[H::T, F] { type R = RRRR }

}
