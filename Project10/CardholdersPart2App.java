import java.io.FileNotFoundException;
/**Main method for cardholders.
*
*@version 11-12-18
*@author Patrick Spafford
*/
public class CardholdersPart2App {
/**
*@param args used!
*@throws FileNotFoundException if not found.
*/
   public static void main(String[] args) throws 
      FileNotFoundException {
      CardholderProcessor chp = new CardholderProcessor();
      String[] fileName = args;
      if (fileName.length == 0) {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      }
      else {
         for (String file: fileName) {
            chp.readCardholderFile(file);
         }
         System.out.println(chp.generateReport());
         System.out.println(chp.generateReportByName());
         System.out.println(chp.generateReportByCurrentBalance());
      }
   }
   
}