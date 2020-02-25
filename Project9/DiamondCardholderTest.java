import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;
/**Diamond Cardholder.
*@author Patrick Spafford
*@version 11-05-2018
*/
public class DiamondCardholderTest {
/** Fixture initialization (common initialization
*  for all tests). **/
   @Before public void setUp() { }
/**
*
*/
   @Test public void getDiscountRateTest() {
      DiamondCardholder d = new DiamondCardholder("012345", "T, Pusha");
      d.setDiscountRate(.05);
      double actual = d.getDiscountRate();
      double expected = 0.05;
      Assert.assertEquals(actual, expected, 0.001);
   }
/**
*
*/

   @Test public void setDiscountRateTest() {
      DiamondCardholder d = new DiamondCardholder("012345", "T, Pusha");
      d.setDiscountRate(.10);
      double actual = d.getDiscountRate();
      double expected = 0.10;
      Assert.assertEquals(actual, expected, 0.001);
   }
/**
*
*/
   @Test public void purchasePointsTest() {
      DiamondCardholder c = new DiamondCardholder("012345",
          "Smallone, Posty");
      double[] p = {4000.0};
      c.setPurchases(p);
      int actual1 = c.purchasePoints();
      int expected1 = (int) (120 * .95 * 100);
      boolean result = (actual1 == expected1) ? true : false;
      Assert.assertTrue(result);
   }
/**
*
*/
   @Test public void totalPurchasesTest() {
      DiamondCardholder c = new DiamondCardholder("012345",
          "Smallone, Posty");
      double[] p = {4000.0};
      c.setPurchases(p);
      double actual = c.totalPurchases();
      double expected = (0.95 * 4000);
      Assert.assertEquals(expected, actual, 0.01);
   }
/**
*
*/   
   @Test public void toStringTest() {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#,##0");
      DecimalFormat df3 = new DecimalFormat("0.0%");
      DiamondCardholder a = new DiamondCardholder("01234", "Bigly, Jim");
      a.setPrevBalance(50.0);
      a.setPayment(1.00);
      double[] n = {20000.0, 1000.0};
      a.setPurchases(n);
      String output = "Diamond Cardholder" + "\n";
      output += "AcctNo/Name: " + "01234" + " Bigly, Jim" + "\n";
      output += "Previous Balance: " + df1.format(a.getPrevBalance()) + "\n";
      output += "Payment: (" + df1.format(a.getPayment()) + ")\n";
      output += "Interest: " + df1.format(a.interest()) + "\n";
      output += "New Purchases: " + df1.format(a.totalPurchases()) + "\n";
      output += "Current Balance: " + df1.format(a.currentBalance()) + "\n";
      output += "Minimum Payment: " + df1.format(a.minPayment()) + "\n";
      output += "Purchase Points: " + df2.format(a.purchasePoints()) + "\n";
      output += "(includes " + df3.format(a.getDiscountRate())
         + " discount rate applied to New Purchases)\n";
      String expected = output;
      String actual = a.toString();
      Assert.assertEquals(expected, actual);
   }


}

