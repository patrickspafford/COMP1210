import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
/**Test for main method with command line args.
*
*@author Patrick Spafford
*@version 11-13-18
*/
public class CardholdersPart2AppTest {
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
   *@throws FileNotFoundException if not found.
   */
   @Test public void mainTest() throws FileNotFoundException {
      String[] args1 = {};
      CardholdersPart2App app = new CardholdersPart2App();
      CardholdersPart2App.main(args1);
      Assert.assertEquals(Cardholder.INTEREST_RATE, 0.01, 0.001);
   }
   /**
   *@throws FileNotFoundException if not found.
   */
   @Test public void mainTest2() throws FileNotFoundException {
      String[] args2 = {"cardholder_data_1.txt"};
      CardholdersPart2App app = new CardholdersPart2App();
      CardholdersPart2App.main(args2);
      Assert.assertEquals(Cardholder.INTEREST_RATE, 0.01, 0.001);
   }
}
