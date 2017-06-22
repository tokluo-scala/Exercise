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

  test ("Checkout should return 0.6 when there is 1 apple") {

    val items = List("apple")
    assert(shoppingCart.checkout(items) == 0.6)
  }

  test ("Checkout should return 1.2 when there is 2 apples") {

    val items = List("apple", "apple")
    assert(shoppingCart.checkout(items) == 1.2)
  }

  test ("Checkout should return 1.8 when there is 3 apples") {
    val items = List("apple", "apple", "apple")
    assert(shoppingCart.checkout(items) == 1.8)
  }

  test ("Checkout should return 1.25 when there is 1 orange") {
    val items = List("orange")
    assert(shoppingCart.checkout(items) == 1.25)
  }

  test ("Checkout should return 2.5 when there is 2 oranges") {
    val items = List("orange", "orange")
    assert(shoppingCart.checkout(items) == 2.5)
  }

  test ("Checkout should return 3.75 when there is 3 oranges") {
    val items = List("orange", "orange", "orange")
    assert(shoppingCart.checkout(items) == 3.75)
  }

  test ("Checkout should return 1.85 when there is 1 apple and 1 orange") {
    val items = List("apple", "orange")
    assert(shoppingCart.checkout(items) == 1.85)
  }

  test ("Checkout should return 2.45 when there is 2 apples and 1 oranges") {
    val items = List("apple", "apple", "orange")
    assert(shoppingCart.checkout(items) == 2.45)
  }

  test ("Checkout should return 3.05 when there is 3 apples and 1 oranges") {
    val items = List("apple", "apple", "apple", "orange")
    assert(shoppingCart.checkout(items) == 3.05)
  }

  test ("Checkout should return 4.3.75 when there is 3 apples and 2 oranges") {
    val items = List("apple", "apple", "apple", "orange", "orange")
    assert(shoppingCart.checkout(items) == 4.3)
  }

  test ("Checkout should return 5.55 when there is 3 apples and 3 oranges") {
    val items = List("apple", "apple", "apple", "orange", "orange", "orange")
    assert(shoppingCart.checkout(items) == 5.55)
  }

  test ("Checkout should return 0.0 when no valid stock") {
    val items = List("grapes")
    assert(shoppingCart.checkout(items) == 0.0)
  }

}
