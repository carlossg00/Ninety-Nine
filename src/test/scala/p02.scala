package ninetyNine.list

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ListSuite extends FunSuite with ShouldMatchers {

  test("P01. Find the last element of a list")     {
    ListUtil.last(List(1,2,3,4,5)) should equal (5)
  }

  test("P01. Find the last element of a list recursively")     {
    ListUtil.lastRecursive(List("apple","orange","pear","banana","watermelon")) should equal ("watermelon")
  }

  test("P02. Find the last but one element of a list") {
    ListUtil.penultimate(List("apple","orange","pear","banana","watermelon")) should equal ("banana")
  }

  test("P02.1 LastNth of an element of a list") {
    ListUtil.lastNthRecursive(3,List("apple","orange","pineapple","grapes")) should equal ("orange")
  }

  test("P03. Find the Kth element of a list") {
    ListUtil.nth(1,List("apple","orange","pineapple","grapes")) should equal ("orange")
    intercept [NoSuchElementException] {
      ListUtil.nth(0,Nil)
    }
    intercept [NoSuchElementException]  {
      ListUtil.nth(9,List(1,2,3,4))
    }
  }

  test("P04. Find the number of elements of a list") {
    ListUtil.length(List.range(0,16)) should equal (16)
    ListUtil.lengthFold(List.range(0,99)) should equal (99)
  }

  test("P05. Reverse a list") {
    ListUtil.reverse(List(1,2,3,5,8)) should equal (List(8,5,3,2,1))
  }

  test("P06. Find out whether a list is palindrome") {
    ListUtil.isPalindrome(List(1,2,8,3,8,2,1)) should equal (true)
    ListUtil.isPalindrome(List(1,3,3,2,6,4,21)) should equal (false)
  }

  test("P07. Flatten anested list structure") {
    (pending)
  }

  test("P08. Eliminate consecurive duplicates of list elements into sublists") {
    (pending)
  }

  test("P09. Pack consecutive duplicates of list elements into sublists") {
    (pending)
  }

  test("P10. Run-length encoding of a list") {
    (pending)

  }



}