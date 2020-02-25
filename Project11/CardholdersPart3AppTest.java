import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
/**Test file for Part 3.
*
*@author Patrick Spafford
*@version 11-26-2018
*
*/
public class CardholdersPart3AppTest {
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**.
   *@throws InvalidCategoryException if invalid.
   *@throws FileNotFoundException if not found.
   *
   */
   @Test public void mainMethodTest1() throws FileNotFoundException, 
      InvalidCategoryException {
      String[] args1 = {};
      CardholdersPart3App app = new CardholdersPart3App();
      CardholdersPart3App.main(args1);
      Assert.assertEquals(Cardholder.INTEREST_RATE, 0.01, 0.001);
   }
   /**.
   *@throws InvalidCategoryException if invalid.
   *@throws FileNotFoundException if not found.
   */
   @Test public void mainMethodTest2() throws FileNotFoundException,
      InvalidCategoryException {
      String[] args2 = {"cardholder_data_1.txt"};
      CardholdersPart3App app = new CardholdersPart3App();
      CardholdersPart3App.main(args2);
      Assert.assertEquals(Cardholder.INTEREST_RATE, 0.01, 0.001);
   }
   /**.
   *@throws InvalidCategoryException if invalid.
   *@throws FileNotFoundException if not found.
   */
   @Test public void mainMethodTest3() throws FileNotFoundException,
      InvalidCategoryException {
      String[] args2 = {"cardholder_data_3_exceptions.txt"};
      CardholdersPart3App app = new CardholdersPart3App();
      CardholdersPart3App.main(args2);
      Assert.assertEquals(Cardholder.INTEREST_RATE, 0.01, 0.001);
   }
   /**.
   *@throws InvalidCategoryException if invalid.
   *@throws FileNotFoundException if not found.
   */
   @Test public void mainMethodTest4() throws FileNotFoundException,
      InvalidCategoryException {
      String[] args2 = {"nofile.txt"};
      CardholdersPart3App app = new CardholdersPart3App();
      CardholdersPart3App.main(args2);
      Assert.assertEquals(Cardholder.INTEREST_RATE, 0.01, 0.001);
   }

}
