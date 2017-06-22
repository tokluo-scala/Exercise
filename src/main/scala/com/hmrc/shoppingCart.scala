package com.hmrc


object  Offer {
  val BOGOOfferDenominator = 2
  val twoForThreeOfferDenominator = 3

  def calculateNumberOfPayableItems(totalItems:Int, denominator :Int, n:Int) : Int = {
    val payableFactor = totalItems / denominator
    def addItemNTimes(noItems:Int, n:Int) : Int = {
      n match {
        case 0 => noItems
        case _ => addItemNTimes(noItems+noItems, n-1)
      }
    }
    addItemNTimes(payableFactor, n) + (totalItems % denominator )
  }

  def calculateTotalPriceWithOffer(price: BigDecimal, noOfItems: Int, denominator:Int, n:Int)
                                  (TotalPayableItems: (Int, Int, Int) => Int): BigDecimal = {

    price * TotalPayableItems(noOfItems, denominator, n)
  }

  val getOneBuyOneFreeOffer = calculateTotalPriceWithOffer(_:BigDecimal, _:Int, BOGOOfferDenominator, 0)(calculateNumberOfPayableItems)
  val threeForPriceTwoOffer = calculateTotalPriceWithOffer(_:BigDecimal, _:Int, twoForThreeOfferDenominator, 1)(calculateNumberOfPayableItems)
}


/**
  * shopping cart with checkout method
  */
object shoppingCart {

  val shopItems = Stock.shopItems

  def checkout(items: List[String]) : BigDecimal= {
    val totalAmountOnEachItem = items.groupBy(identity).mapValues(_.size)
    val zeroPrice: BigDecimal = 0.0

    val totalPriceEachItem = shopItems.keys.map {
      case "apple" => Offer.getOneBuyOneFreeOffer(shopItems.getOrElse("apple", 0.0), totalAmountOnEachItem.getOrElse("apple", 0))
      case "orange" => Offer.threeForPriceTwoOffer(shopItems.getOrElse("orange", 0.0), totalAmountOnEachItem.getOrElse("orange", 0))
      case _ => zeroPrice
    }
    totalPriceEachItem.sum
  }
}