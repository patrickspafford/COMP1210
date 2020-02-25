import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;
/**Tests the cardholder parent class.
*@author Patrick Spafford
*@version 11-05-2018
*/
public class SapphireCardholderTest {
   private String acctNumber, name;
   private double prevBalance, payment;
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() { }
   
   /**
   *
   */
   @Test public void getAcctNumberTest() {
      String expected = "01234";
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim"); 
      String actual = a.getAcctNumber();
      Assert.assertEquals(expected, actual);
   }
   /**
   *
   */
   @Test public void setAcctNumberTest() {
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setAcctNumber("43210");
      String expected = "43210";  
      String actual = a.getAcctNumber();
      Assert.assertEquals(expected, actual);
   }
   /**
   *
   */
   @Test public void getNameTest() {
      String expected = "Bigly, Jim";
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim"); 
      String actual = a.getName();
      Assert.assertEquals(expected, actual);
   }
   /**
   *
   */
   @Test public void setNameTest() {
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setName("Smallone, Post");
      String expected = "Smallone, Post";  
      String actual = a.getName();
      Assert.assertEquals(expected, actual);
   }
   /**
   *
   */
   @Test public void getPrevBalanceTest() {
      double expected = 1.0;
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setPrevBalance(1.0); 
      double actual = a.getPrevBalance();
      Assert.assertEquals(expected, actual, 0.0001);
   }
   /**
   *
   */
   @Test public void setPrevBalanceTest() {
      double expected = 2.0;
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setPrevBalance(2.0); 
      double actual = a.getPrevBalance();
      Assert.assertEquals(expected, actual, 0.0001);
   }
   /**
   *
   */
   @Test public void getPaymentTest() {
      double expected = 3.0;
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setPayment(3.0); 
      double actual = a.getPayment();
      Assert.assertEquals(expected, actual, 0.001);
   }
   /**
   *
   */
   @Test public void setPaymentTest() {
      double expected = 4.0;
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setPayment(4.0); 
      double actual = a.getPayment();
      Assert.assertEquals(expected, actual, 0.001);
   }
   /**
   *
   */
   @Test public void getPurchasesTest() {
      double[] expected = {3.0, 1.0, 2.3};
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      double[] n = {3.0, 1.0, 2.3};
      a.setPurchases(n); 
      double[] actual = a.getPurchases();
      Assert.assertArrayEquals(expected, actual, 0.01);
   }
   /**
   *
   */
   @Test public void setPurchasesTest() {
      double[] expected = {2.0, 1.0, 2.3};
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      double[] n = {2.0, 1.0, 2.3};
      a.setPurchases(n); 
      double[] actual = a.getPurchases();
      Assert.assertArrayEquals(expected, actual, 0.01);
   }
   /**
   *
   */
   @Test public void addPurchasesTest() {
      double[] expected = {2.0, 1.0, 2.3};
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      double[] n = {2.0, 1.0};
      a.setPurchases(n);
      a.addPurchases(2.3); 
      double[] actual = a.getPurchases();
      Assert.assertArrayEquals(expected, actual, 0.01);
   }
   /**
   *
   */
   @Test public void deletePurchasesTest() {
      double[] expected = {2.0, 1.0, 2.3, 2.5};
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      double[] n = {2.0, 1.0, 2.3, 2.5, 3.4};
      a.setPurchases(n);
      a.deletePurchases(3.4); 
      double[] actual = a.getPurchases();
      Assert.assertArrayEquals(expected, actual, 0.01);
   }
   /**
   *
   */
   @Test public void deletePurchasesTest2() {
      double[] expected = {2.0, 2.3, 2.5, 3.4};
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      double[] n = {2.0, 1.0, 2.3, 2.5, 3.4};
      a.setPurchases(n);
      a.deletePurchases(1.0); 
      double[] actual = a.getPurchases();
      Assert.assertArrayEquals(expected, actual, 0.01);
   }
   /**
   *
   */
   @Test public void interestTest() {
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setPrevBalance(100.00);
      a.setPayment(50.00);
      double payment1 = 50.00;
      double prevBalance1 = 100.00;
      double expected = (prevBalance1 - payment1) * 0.01;
      double actual = a.interest();
      Assert.assertEquals(expected, actual, 0.01);
   }
   /**
   *
   */
   @Test public void totalPurchasesTest() {
      double expected = 3.0;
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      double[] n = {2.0, 1.0};
      a.setPurchases(n); 
      double actual = a.totalPurchases();
      Assert.assertEquals(expected, actual, 0.01);
   }
   /**
   *
   */
   @Test public void balanceTest() {
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setPrevBalance(50.0);
      a.setPayment(1.00);
      double[] n = {2.0, 1.0};
      a.setPurchases(n); 
      double actual = a.balance();
      double expected = 53.5;
      Assert.assertEquals(expected, actual, 0.1);
   }
   /**
   *
   */
   @Test public void currentBalanceTest() {
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setPrevBalance(50.0);
      a.setPayment(1.00);
      double[] n = {2.0, 1.0};
      a.setPurchases(n); 
      double actual = a.currentBalance();
      double expected = a.getPrevBalance() - a.getPayment() 
         + a.interest() + a.totalPurchases();
      Assert.assertEquals(expected, actual, 0.1);
   }
   /**
   *
   */
   @Test public void minPaymentTest() {
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setPrevBalance(144.0);
      a.setPayment(3.00);
      double[] n = {6.0, 3.0};
      a.setPurchases(n); 
      double expected = (0.03) * a.currentBalance();
      double actual = a.minPayment();
      Assert.assertEquals(expected, actual, 0.01);
   }
   /**
   *
   */
   @Test public void purchasePointsTest() {
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      double[] n = {100.0};
      a.setPurchases(n);
      a.totalPurchases();
      double expected = 1.0 * 100;
      double actual = a.purchasePoints();
      Assert.assertEquals(expected, actual, 0.01);
   }
   /**
   *
   */
   @Test public void toStringTest() {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#,##0");
      SapphireCardholder a = new SapphireCardholder("01234", "Bigly, Jim");
      a.setPrevBalance(50.0);
      a.setPayment(1.00);
      double[] n = {2.0, 1.0};
      a.setPurchases(n);
      String output = "Sapphire Cardholder" + "\n";
      output += "AcctNo/Name: " + "01234" + " Bigly, Jim" + "\n";
      output += "Previous Balance: " + df1.format(a.getPrevBalance()) + "\n";
      output += "Payment: (" + df1.format(a.getPayment()) + ")\n";
      output += "Interest: " + df1.format(a.interest()) + "\n";
      output += "New Purchases: " + df1.format(a.totalPurchases()) + "\n";
      output += "Current Balance: " + df1.format(a.currentBalance()) + "\n";
      output += "Minimum Payment: " + df1.format(a.minPayment()) + "\n";
      output += "Purchase Points: " + df2.format(a.purchasePoints()) + "\n";
      String expected = output;
      String actual = a.toString();
      Assert.assertEquals(expected, actual);
   }



}
