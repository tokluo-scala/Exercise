package com.hmrc

import org.scalatest.FunSuite

/**
  * Tests for shopping Cart
  */
class shoppingCart$Test extends FunSuite {

  test ("It should calculate total of 1 apple at price 60p and return 0.6") {

    assert(shoppingCart.calculateTotalPrice(0.6, 1) == 0.6)
  }
}
