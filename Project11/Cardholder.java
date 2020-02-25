import java.util.Arrays;
import java.text.DecimalFormat;
/**Foundation for other cardholder classes.
*
*@version 11-05-2018
*@author Patrick Spafford
*
*/
public abstract class Cardholder implements Comparable<Cardholder> {
//fields
   protected String category, acctNumber, name;
   protected double prevBalance, payment;
   protected double[] purchases;
   /**
   *
   */
   public static final double INTEREST_RATE = 0.01;
   
//constructor
/**Creates the base constructor for the cardholder.
*@param acctNumberIn is acctNumber.
*@param nameIn is name.
*/
   public Cardholder(String acctNumberIn, String nameIn) {
      acctNumber = acctNumberIn;
      name = nameIn;
      purchases = new double[0];
   }
//methods
/**
*@return acctNumber.
*
*/
   public String getAcctNumber() {
      return acctNumber;
   }
/**
*@param acctNumberIn is the acctNumber.
*
*/   
   public void setAcctNumber(String acctNumberIn) {
      acctNumber = acctNumberIn;
      
   }
 /**
*@return name.
*
*/
  
   public String getName() {
      return name;
   }
 /**
*@param nameIn is name.
*
*/
   public void setName(String nameIn) {
      name = nameIn;
   }
 /**
*@return prevBalance.
*
*/  
   public double getPrevBalance() {
      return prevBalance;
   }
 /**
*
*@param prevBalanceIn is previous balance.
*/  
   public void setPrevBalance(double prevBalanceIn) {
      prevBalance = prevBalanceIn;
   }
 /**
*
*@return payment.
*/  
   public double getPayment() {
      return payment;
   }
/**
*
*@param paymentIn is the new payment.
*/
   
   public void setPayment(double paymentIn) {
      payment = paymentIn;
   }
/**
*
*@return purchases.
*/   
   public double[] getPurchases() {
      return purchases;
   }
/**
*
*@param purchasesIn is the set purchases.
*/   
   public void setPurchases(double[] purchasesIn) {
      purchases = purchasesIn;
   }
/**
*
*@param purchasesIn is the new purchases.
*/   
   public void addPurchases(double... purchasesIn) {
      double[] add = purchasesIn;
      double[] purchases1 = purchases;
      double[] purchases2 = Arrays.copyOf(purchases1, purchases1.length 
         + purchasesIn.length);
      for (int i = 0; i < add.length; i++) {
         purchases2[i + purchases1.length] = add[i];
      }
      purchases = purchases2;
   
   }
/**
*
*@param deletedPurchasesIn is the purchases to be deleted.
*/   
   public void deletePurchases(double... deletedPurchasesIn) {
      double[] delete = deletedPurchasesIn;
      double[] purchases1 = purchases;
      
      for (int n = 0; n < delete.length; n++) {
         for (int counter = 0; counter < purchases1.length; counter++) {
            if (purchases1[counter] == delete[n]) {
               if (counter != purchases1.length - 1) {
                  for (int p = counter; p < purchases1.length - 1; p++) {
                     purchases1[p] = purchases1[p + 1];
                  }
               }
               purchases1 = Arrays.copyOf(purchases1, purchases1.length - 1);
            }
         }
         
         purchases = purchases1;          
      }     
   }
/**
*
*@return interest.
*/   
   public double interest() {
      return (prevBalance - payment) * INTEREST_RATE;
   }
/**
*
*@return double output.
*/   
   public double totalPurchases() {
      double output = 0.0;
      for (double purchase: purchases) {
         output += purchase;
      }
      return output;
   }
/**
*
*@return double balance.
*/   
   public double balance() {
      double output = getPrevBalance() + interest() + totalPurchases();
      return output;
   }
/**
*
*@return currentBalance.
*/   
   public double currentBalance() {
      double output = prevBalance - payment + interest() + totalPurchases();
      return output;
   }
/**
*
*@return minimum payment.
*/   
   public double minPayment() {
      return (0.03) * currentBalance();
   }
 /**
*
*@return int.
*/  
   public abstract int purchasePoints();
/**
*
*@return String.
*/
   public String toString() {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#,##0");
   
      String output = category + "\n";
      output += "AcctNo/Name: " + acctNumber + " " + name + "\n";
      output += "Previous Balance: " + df1.format(prevBalance) + "\n";
      output += "Payment: (" + df1.format(payment) + ")\n";
      output += "Interest: " + df1.format(interest()) + "\n";
      output += "New Purchases: " + df1.format(totalPurchases()) + "\n";
      output += "Current Balance: " + df1.format(currentBalance()) + "\n";
      output += "Minimum Payment: " + df1.format(minPayment()) + "\n";
      output += "Purchase Points: " + df2.format(purchasePoints()) + "\n";
      return output;
   }
   /**
   *@param c2 is the cardholder for comparison.
   *@return integer value.
   */
   public int compareTo(Cardholder c2) {
      return (((Cardholder) this).getName().compareToIgnoreCase(((
         (Cardholder) c2).getName())));
          
   }
}