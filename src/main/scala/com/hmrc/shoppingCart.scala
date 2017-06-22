package com.hmrc

/**
  * shopping cart with checkout method
  */
object shoppingCart {

  val shopItems = Stock.shopItems

  def checkout(items: List[String]) : BigDecimal= {
    val totalAmountOnEachItem = items.groupBy(identity).mapValues(_.size)
    val totalPriceForEachItem = shopItems.keys.map(item => {
      calculateTotalPrice(shopItems.getOrElse(item, 0), totalAmountOnEachItem.getOrElse(item, 0))
    })
    totalPriceForEachItem.sum
  }

  def calculateTotalPrice(price: BigDecimal, noOfItems: Int): BigDecimal = {
    price * noOfItems
  }

  def calculateNumberOfPayableItems(totalItems:Int, factor:Int, n:Int) : Int = {
    val payableFactor = totalItems / factor
    def addItemNTimes(noItems:Int, n:Int) : Int = {
      n match {
        case 0 => noItems
        case _ => addItemNTimes(noItems+noItems, n-1)
      }
    }
    addItemNTimes(payableFactor, n) + (totalItems % factor)
  }
}