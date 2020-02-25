import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.io.FileNotFoundException;
/**Test for cardholder processor test.
*@author Patrick Spafford
*@version 11-13-2018
*/
public class CardholderProcessorTest {
/** Fixture initialization (common initialization
*  for all tests). **/
   @Before public void setUp() {
   }
   /**
   *
   */
   @Test public void getCardholdersArrayTest() {
      Cardholder[] expected = new Cardholder[0];
      CardholderProcessor chp = new CardholderProcessor();
      Cardholder[] actual = chp.getCardholdersArray();
      Assert.assertArrayEquals(expected, actual);
   }
   /**
   *
   */
   @Test public void getInvalidRecordsArrayTest() {
      String[] expected = new String[0];
      CardholderProcessor chp = new CardholderProcessor();
      String[] actual = chp.getInvalidRecordsArray();
      Assert.assertArrayEquals(expected, actual);
   }
   /**
   *
   */
   @Test public void addInvalidRecordTest() {
      CardholderProcessor chp = new CardholderProcessor();
      chp.addInvalidRecord("Test");
      String[] expected = {"Test"};
      String[] actual = chp.getInvalidRecordsArray();
      Assert.assertArrayEquals(expected, actual);
   }
   /**
   *
   */
   @Test public void addCardholderTest() {
      CardholderProcessor chp = new CardholderProcessor();
      Cardholder shc = new SapphireCardholder("012", "Bob");
      chp.addCardholder(shc);
      Cardholder[] expected = {shc};
      Cardholder[] actual = chp.getCardholdersArray();
      Assert.assertArrayEquals(expected, actual);
   }
   /**
   *@throws FileNotFoundException if not found.
   */
   @Test public void readCardholderFileTest() throws FileNotFoundException {
      CardholderProcessor chp = new CardholderProcessor();
      chp.readCardholderFile("cardholder_data_1.txt");
      int actual = chp.getCardholdersArray().length;
      int expected = 4;
      Assert.assertEquals(expected, actual);
   }
   /**
   *@throws FileNotFoundException if not found.
   */
   @Test public void generateReportTest() throws FileNotFoundException {
      CardholderProcessor chp = new CardholderProcessor();
      chp.readCardholderFile("cardholder_data_1.txt");
      String actual = chp.generateReport();
      String expected = "";
      for (Cardholder c: chp.getCardholdersArray()) {
         expected += c.toString();
         expected += "\n";
      }
      Assert.assertTrue(actual.contains(expected));
   }
   /**
   *@throws FileNotFoundException if not found.
   */
   @Test public void generateReportByNameTest() throws FileNotFoundException {
      CardholderProcessor chp = new CardholderProcessor();
      chp.readCardholderFile("cardholder_data_1.txt");
      String actual = chp.generateReportByName();
      String expected = "";
      Arrays.sort(chp.getCardholdersArray());
      for (Cardholder c: chp.getCardholdersArray()) {
         expected += c.toString();
         expected += "\n"; 
      }
      Assert.assertTrue(actual.contains(expected));  
   }
   /**
   *@throws FileNotFoundException if not found.
   */
   @Test public void generateReportByCurrentBalanceTest()
      throws FileNotFoundException {
      CardholderProcessor chp = new CardholderProcessor();
      chp.readCardholderFile("cardholder_data_1.txt");
      String actual = chp.generateReportByCurrentBalance();
      String expected = "";
      Arrays.sort(chp.getCardholdersArray(), new CurrentBalanceComparator());
      for (Cardholder c: chp.getCardholdersArray()) {
         expected += c.toString();
         expected += "\n"; 
      }
      Assert.assertTrue(actual.contains(expected));
   }







}
