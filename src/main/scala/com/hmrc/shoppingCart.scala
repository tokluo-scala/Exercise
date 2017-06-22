package com.hmrc

/**
  * shopping cart with checkout method
  */
object shoppingCart {

  val shopItems = Stock.shopItems

  def checkout(items: List[String]) : BigDecimal= {
    0.0
  }

  def calculateTotalPrice(price: BigDecimal, noOfItems: Int): BigDecimal = {
    price * noOfItems
  }

}