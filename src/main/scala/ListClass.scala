package ninetyNine.list

/**
 * Created by IntelliJ IDEA.
 * User: carlos
 * Date: 2/29/12
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */

object ListUtil {
  def last[A](ls : List[A]) : A = ls.last

  def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil  => h
    case _ :: tail => lastRecursive(tail)
    case _         => throw new NoSuchElementException
  }

  def penultimate[A](ls: List[A]): A = ls match {
    case p :: _ :: Nil  => p
    case _ :: tail => penultimate(tail)
    case _         => throw new NoSuchElementException
  }
  
  def lastNthRecursive[A](n: Int, ls: List[A]): A =  {

    def lastNthR(i: Int, ls: List[A]) : A = ls match {
      case p if (i == 1) => p.last
      case ls  => lastNthR(i-1,ls.init)

    }
    
    if (n <= 0) throw new IllegalArgumentException
    lastNthR(n,ls)
  }
  
  def nth[A](n: Int, ls: List[A]): A =  (n , ls) match {
    case (0, h :: _ ) => h
    case (n, _ :: tail) => nth(n-1,tail)
    case (_, Nil) => throw new NoSuchElementException
  }
  
  def length[T](xs : List[T]) : Int = xs match {
    case Nil => 0
    case x :: xs1 => 1 + length(xs1)
  }
  
  def lengthFold[T](xs : List[T]): Int = (0 /: xs) ((c,_) => {  c + 1 })
  
  def reverse[T](xs : List[T]) : List[T] = (List[T]() /: xs) (( ys, y) => { y :: ys})
  
  def isPalindrome[T](xs : List[T]) : Boolean = xs match {
    case Nil => true
    case List(_)  => true
    case List(x , y) if (x == y) => true
    case ( x :: xs ) if (x == xs.last && isPalindrome(xs.init)) => true
    case _ => false
  }

 def flattenR(xs : List[Any]) : List[Any]= xs match {
    case List() => xs
    case (x:List[_]) :: xs1 => flattenR(x) ::: flattenR (xs1)
    case x :: xs1 => x :: flattenR(xs1)
 }


  def flatten(xs : List[Any]) : List[Any] = xs flatMap {
    case xss : List[_] => flatten (xss)
    case e => List(e)
  }
  
  def compress[T](xs : List[T]) : List[T] = xs match {
    case Nil => Nil    
    case x :: xs1   => x :: compress( xs1 dropWhile ( _ == x))
  }

  /* Programmer Note: FoldLeft won't work, as it builds a reversed list, extra operation would be necessary */
  def compressFunctional[T](xs : List[T]) : List[T] =  ( xs :\ List[T]() ) ( (x, xs) =>
        if (xs.isEmpty || xs.head != x) x :: xs
        else xs
  )

  def pack[T](xs : List[T]) : List[List[T]] = xs match {
    case Nil => Nil
    case xs1 => {
      val (packed, next) = xs1 span { _ == xs1.head }
      packed :: pack(next)}
  }
  
  def encode[T](xs : List[T]) : List[(Int,T)] = {
    pack(xs) map (x => (x.length, x.head))
  }


}
