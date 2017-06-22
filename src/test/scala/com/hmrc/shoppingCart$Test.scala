package com.hmrc

import org.scalatest.FunSuite

/**
  * Tests for shopping Cart
  */
class shoppingCart$Test extends FunSuite {

  test ("It should calculate total of 1 apple at price 60p and return 0.6") {

    assert(shoppingCart.calculateTotalPrice(0.6, 1) == 0.6)
  }

  test ("It should calculate total of 0 apple at price 60p and return 0.0") {

    assert(shoppingCart.calculateTotalPrice(0.6, 0) == 0.0)
  }

  test ("Checkout should return 0.6 when there is 1 apple with buy one get one free offer") {

    val items = List("apple")
    assert(shoppingCart.checkout(items) == 0.6)
  }

  test ("Checkout should return 0.6 when there are 2 apples with buy one get one free offer") {

    val items = List("apple", "apple")
    assert(shoppingCart.checkout(items) == 0.6)
  }

  test ("Checkout should return 1.2 when there are 3 apples with buy one get one free offer") {
    val items = List("apple", "apple", "apple")
    assert(shoppingCart.checkout(items) == 1.2)
  }

  test ("Checkout should return 1.2 when there are 4 apples with buy one get one free offer") {
    val items = List("apple", "apple", "apple",  "apple")
    assert(shoppingCart.checkout(items) == 1.2)
  }

  test ("Checkout should return 1.8 when there are 5 apples with buy one get one free offer") {
    val items = List("apple", "apple", "apple", "apple",  "apple")
    assert(shoppingCart.checkout(items) == 1.8)
  }

  test ("Checkout should return 1.8 when there are 6 apples with buy one get one free offer") {
    val items = List("apple", "apple", "apple", "apple",  "apple")
    assert(shoppingCart.checkout(items) == 1.8)
  }

  test ("Checkout should return 0.25 when there is 1 orange with three for price two offer") {
    val items = List("orange")
    assert(shoppingCart.checkout(items) == 0.25)
  }

  test ("Checkout should return 0.5 when there are 2 oranges with three for price two offer") {
    val items = List("orange", "orange")
    assert(shoppingCart.checkout(items) == 0.5)
  }

  test ("Checkout should return 0.5 when there are 3 oranges with three for price two offer") {
    val items = List("orange", "orange", "orange")
    assert(shoppingCart.checkout(items) == 0.5)
  }

  test ("Checkout should return 0.75 when there are 4 orange three for price two offer") {
    val items = List("orange", "orange", "orange", "orange")
    assert(shoppingCart.checkout(items) == 0.75)
  }

  test ("Checkout should return 1.0 when there are 5 oranges three for price two offer") {
    val items = List("orange", "orange", "orange", "orange", "orange")
    assert(shoppingCart.checkout(items) == 1.0)
  }

  test ("Checkout should return 1.0 when there are 6 oranges three for price two offer") {
    val items = List("orange", "orange", "orange", "orange", "orange", "orange")
    assert(shoppingCart.checkout(items) == 1.0)
  }


  test ("Checkout should return 0.85 when there are 1 apple and 1 orange with offer") {
    val items = List("apple", "orange")
    assert(shoppingCart.checkout(items) == 0.85)
  }

  test ("Checkout should return 0.85 when there are 2 apples and 1 oranges with offer") {
    val items = List("apple", "apple", "orange")
    assert(shoppingCart.checkout(items) == 0.85)
  }

  test ("Checkout should return 1.45 when there are 3 apples and 1 oranges with offer") {
    val items = List("apple", "apple", "apple", "orange")
    assert(shoppingCart.checkout(items) == 1.45)
  }

  test ("Checkout should return 1.7 when there are 3 apples and 2 oranges with offer") {
    val items = List("apple", "apple", "apple", "orange", "orange")
    assert(shoppingCart.checkout(items) == 1.7)
  }

  test ("Checkout should return 1.7 when there are 3 apples and 3 oranges") {
    val items = List("apple", "apple", "apple", "orange", "orange", "orange")
    assert(shoppingCart.checkout(items) == 1.7)
  }

  test ("Checkout should return 0.0 when no valid stock") {
    val items = List("grapes")
    assert(shoppingCart.checkout(items) == 0.0)
  }

  test("Out of total of  1 apples 1 is payable") {
    assert(shoppingCart.calculateNumberOfPayableItems(1,2,0) == 1)
  }

  test("Out of total of 2 apples 1 is payable") {
    assert(shoppingCart.calculateNumberOfPayableItems(2,2,0) == 1)
  }

  test("Out of total of 3 apples 2 is payable") {
    assert(shoppingCart.calculateNumberOfPayableItems(3,2,0) == 2)
  }

  test("Out of total of 4 apples 2 is payable") {
    assert(shoppingCart.calculateNumberOfPayableItems(4,2,0) == 2)
  }

  test("Out of total of  1 orange 1 is payable") {
    assert(shoppingCart.calculateNumberOfPayableItems(1,3,1) == 1)
  }

  test("Out of total of 2 orange 2 is payable") {
    assert(shoppingCart.calculateNumberOfPayableItems(2,3,1) == 2)
  }

  test("Out of total of 3 orange 2 is payable") {
    assert(shoppingCart.calculateNumberOfPayableItems(3,3,1) == 2)
  }

  test("Out of total of 4 orange 3 is payable") {
    assert(shoppingCart.calculateNumberOfPayableItems(4,3,1) == 3)
  }

  test("Out of total of 5 orange 4 is payable") {
    assert(shoppingCart.calculateNumberOfPayableItems(5,3,1) == 4)
  }

  test("Out of total of 6 orange 4 is payable") {
    assert(shoppingCart.calculateNumberOfPayableItems(6,3,1) == 4)
  }

}
