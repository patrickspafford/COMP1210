import java.text.DecimalFormat;
/**Blue Diamond class.
*
*@author Patrick Spafford
*@version 11-05-2018
*
*/
public class BlueDiamondCardholder extends DiamondCardholder {
// fields
   private int bonusPurchasePoints = 2500;
// constructor
/**
*@param acctNumberIn is the acct number.
*@param nameIn is the name input.
*/
   public BlueDiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Blue Diamond Cardholder";
      discountRate = 0.10;
   }
// methods
/**
*@return bonus points.
*/
   public int getBonusPurchasePoints() {
      return bonusPurchasePoints;
   }
/**
*@param bonusPurchasePointsIn is the bonus point set.
*/   
   public void setBonusPurchasePoints(int bonusPurchasePointsIn) {
      bonusPurchasePoints = bonusPurchasePointsIn;
   }
/**
*@return purchase points.
*/   
   public int purchasePoints() {
      int output1 = (int) totalPurchases();
      int output2 = (5 * output1);
      if (totalPurchases() > 2500) {
         output2 += bonusPurchasePoints;
      }
      return output2;
   }
   /**
   *@return String.
   */
   public String toString() {
      String output = super.toString();
      DecimalFormat df2 = new DecimalFormat("#,##0");
      if (totalPurchases() > 2500) {
         output += "(includes " + df2.format(bonusPurchasePoints) 
            + " bonus points added to Purchase Points)\n";
      }
      return output;
   }
   
}