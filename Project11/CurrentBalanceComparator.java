import java.util.Comparator;
/**Defines the ordering of the cardholder objects.
*
*@author Patrick Spafford
*@version 11-12-18
*/
public class CurrentBalanceComparator implements Comparator<Cardholder> {
   private static final double TOLERANCE = 0.01;
//methods
//
/**compares two cardholder objects.
*@param c1 is the first cardholder.
*@param c2 is the second cardholder.
*@return integer based on comparison.
*/
   public int compare(Cardholder c1, Cardholder c2) {
      if (c1.currentBalance() > c2.currentBalance()) {
         return -1; }
      else if (Math.abs(c1.currentBalance() 
         - c2.currentBalance()) < TOLERANCE) {
         return 0;
      }
      else {
         return 1;
      }
   }


}