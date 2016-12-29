
val xs = Stream.cons(2, Stream.empty)

Stream(1,2,3)

(1 to 1000).toStream

def streamRange(lo: Int, hi: Int): Stream[Int] = {
  println(lo + " ")
  if(lo > hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))
}

def listRange(lo: Int, hi: Int): List[Int] = {
  println(lo + " ")
  if(lo > hi) Nil
  else  lo :: listRange(lo + 1, hi)
}

def isPrime(i: Int): Boolean =
  (2 to i) forall (i % _ != 0)

val list = listRange(1,100)

val stream = streamRange(1,100).toList

((1000 to 10000).toStream filter isPrime)(1)

streamRange(1,10).take(3).toList