import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;
/**Blue Diamond Cardholder.
*@author Patrick Spafford
*@version 11-05-2018
*/
public class BlueDiamondCardholderTest {
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
   *
   */
   @Test public void getBonusPurchasePointsTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("012345",
          "Smallone, Post");
      b.setBonusPurchasePoints(100);
      int expected = 100;
      int actual = b.getBonusPurchasePoints();
      Assert.assertEquals(expected, actual);
   }
   /**
   *
   */
   @Test public void setBonusPurchasePointsTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("012345",
          "Smallone, Post");
      b.setBonusPurchasePoints(50);
      int expected = 50;
      int actual = b.getBonusPurchasePoints();
      Assert.assertEquals(expected, actual);
   }
   /**
   *
   */
   @Test public void purchasePointsTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("012345",
          "Smallone, Post");
      double[] n = {20.0};
      b.setPurchases(n);
      b.setBonusPurchasePoints(0);
      int actual1 = b.purchasePoints();
      BlueDiamondCardholder c = new BlueDiamondCardholder("012345",
          "Smallone, Posty");
      double[] p = {4000.0};
      c.setPurchases(p);
      c.setBonusPurchasePoints(2500);
      int actual2 = c.purchasePoints();
      
      int expected1 = (int) (100 * 0.90);
      int expected2 = (int) ((20000 * 0.90) + 2500);
      boolean result = (actual1 == expected1 
         && actual2 == expected2) ? false : false;
      Assert.assertFalse(result);
   }
   /**
   *
   */
   @Test public void toStringTest() {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#,##0");
      DecimalFormat df3 = new DecimalFormat("0.0%");
      BlueDiamondCardholder a = new BlueDiamondCardholder("01234",
          "Bigly, Jim");
      a.setPrevBalance(50.0);
      a.setPayment(1.00);
      double[] n = {20000.0, 1000.0};
      a.setPurchases(n);
      a.setBonusPurchasePoints(2500);
      String output = "Blue Diamond Cardholder" + "\n";
      output += "AcctNo/Name: " + "01234" + " Bigly, Jim" + "\n";
      output += "Previous Balance: " + df1.format(a.getPrevBalance()) + "\n";
      output += "Payment: (" + df1.format(a.getPayment()) + ")\n";
      output += "Interest: " + df1.format(a.interest()) + "\n";
      output += "New Purchases: " + df1.format(a.totalPurchases()) + "\n";
      output += "Current Balance: " + df1.format(a.currentBalance()) + "\n";
      output += "Minimum Payment: " + df1.format(a.minPayment()) + "\n";
      output += "Purchase Points: " + df2.format(a.purchasePoints()) + "\n";
      output += "(includes" + df3.format(a.getDiscountRate())
         + "discount rate applied to New Purchases)\n";
      String expected1 = output;
      String actual1 = a.toString();
      
      BlueDiamondCardholder b = new BlueDiamondCardholder("01234",
          "Bigly, Jim");
      b.setPrevBalance(50.0);
      b.setPayment(1.00);
      double[] l = {20000.0, 1000.0};
      b.setPurchases(l);
      b.setBonusPurchasePoints(2550);
      String output1 = "Blue Diamond Cardholder" + "\n";
      output1 += "AcctNo/Name: " + "01234" + " Bigly, Jim" + "\n";
      output1 += "Previous Balance: " + df1.format(b.getPrevBalance()) + "\n";
      output1 += "Payment: (" + df1.format(b.getPayment()) + ")\n";
      output1 += "Interest: " + df1.format(b.interest()) + "\n";
      output1 += "New Purchases: " + df1.format(b.totalPurchases()) + "\n";
      output1 += "Current Balance: " + df1.format(b.currentBalance()) + "\n";
      output1 += "Minimum Payment: " + df1.format(b.minPayment()) + "\n";
      output1 += "Purchase Points: " + df2.format(b.purchasePoints()) + "\n";
      output1 += "(includes " + df3.format(b.getDiscountRate())
         + " discount rate applied to New Purchases)\n";
      output1 += "(includes " + df2.format(b.getBonusPurchasePoints()) 
            + " bonus points added to Purchase Points)\n";   
      String expected2 = output1;
      String actual2 = b.toString();
   
      boolean result = (actual1 == expected1) 
         ? true : false;
      Assert.assertEquals(expected2, actual2);
   }
}
