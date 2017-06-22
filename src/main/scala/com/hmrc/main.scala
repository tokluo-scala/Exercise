package com.hmrc

/**
  * Created by lout on 22/06/2017.
  */
object main {

    def main(args: List[String]): Unit = {
      val totalPriceInShoppingCart = shoppingCart.checkout(args)
      println(s"The total price is : $totalPriceInShoppingCart")
    }
}
