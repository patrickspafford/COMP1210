import java.text.DecimalFormat;
/**Foundation for other cardholder classes.
*
*@version 11-05-2018
*@author Patrick Spafford
*
*/
public class DiamondCardholder extends Cardholder {
//fields
   protected double discountRate = 0.05;
//constructor
/**
*@param acctNumberIn .
*@param nameIn .
*/
   public DiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Diamond Cardholder";
   }
   /**
   *@return discountRate .
   */
   public double getDiscountRate() {
      return discountRate;
   }
   /**
   *
   *@param discountRateIn is the % off.
   */
   public void setDiscountRate(double discountRateIn) {
      discountRate = discountRateIn;
   }
   /**
   *@return int of purchase points.
   */
   public int purchasePoints() {
      int output1 = (int) totalPurchases();
      int output2 = 3 * output1;
      return output2;
   }
   /**
   *@return double of output
   */
   public double totalPurchases() {
      double output = 0.0;
      for (double purchase: purchases) {
         output += purchase;
      }
      return output * (1 - discountRate);
   }
   /**
   *@return String
   */
   public String toString() {
      String output = super.toString();
      DecimalFormat df3 = new DecimalFormat("0.0%");
      output += "(includes " + df3.format(discountRate)
         + " discount rate applied to New Purchases)\n";
      return output;
   }
   


}