package main.scala.com.Project.services

import main.scala.com.Project.entities.{CoreChecking, CreditCard, Dollars, RewardsSavings, StudentCheckings}

import java.util.UUID

trait ProductService extends ProductsDb {
  /**
   * // todo: (challenge?) how to disallow products of same name?
   *
   * @param name                            : name of product
   * @param minBalance                      : the minimum balance required for the product
   * @param ratePerYear                     : the rate of interest earned by the end of the year
   * @Param transactionAllowedPerMonth      : number of free transaction allowed for the product (optional)
   * @ return the product id for the new product
   */
  def addNewDepositProduct(name: String, minBalance: Int, ratePerYear: Double,
                           transactionAllowedPerMonth: Int = 2): UUID = {
    val product = name match {
      case "CoreChecking" => new CoreChecking(Dollars(minBalance), ratePerYear)
      case "StudentCheckings" => new StudentCheckings(Dollars(minBalance), ratePerYear)
      case "RewardsSavings" => new RewardsSavings(Dollars(minBalance), ratePerYear, transactionAllowedPerMonth)
    }
    saveDepositProduct(product)
    product.id
  }

  def addNewLendingProduct(annualFee: Double, apr: Double, rewardsPercents: Double): UUID = {
    val product = new CreditCard(annualFee, apr, rewardsPercents)
    saveLendingProduct(product)
    product.id
  }

}
