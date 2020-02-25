/**Sapphire Cardholder class.
*
*Child of Cardholder class.
*@author Patrick Spafford
*@version 11-05-2018
*/
public class SapphireCardholder extends Cardholder {
//fields

//constructor
/**
*@param acctNumberIn is the account number.
*@param nameIn is the input name.
*/
   public SapphireCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Sapphire Cardholder";
   }
//methods
/**
*@return int for purchase points.
*/
   public int purchasePoints() {
      int output1 = (int) totalPurchases();
   
      int output2 = output1;
      return output2; 
   }

}