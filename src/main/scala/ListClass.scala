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
  
  def reverse[T](xs : List[T]) : List[T] = (List[T]() /: xs) (( y, ys) => { ys :: y})
  
  def isPalindrome[T](xs : List[T]) : Boolean = xs match {
    case Nil => true
    case List(_)  => true
    case List(x , y) if (x == y) => true
    case ( x :: xs ) if (x == xs.last && isPalindrome(xs.init)) => true
    case _ => false
  }
  
}
