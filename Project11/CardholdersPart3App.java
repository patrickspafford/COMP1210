import java.io.FileNotFoundException;
/**Driver class for CardholderProcessor(edited).
*
*@author Patrick Spafford
*@version 11-25-2018
*/
public class CardholdersPart3App {
/**Catches exceptions with try-catch statements.
*@throws FileNotFoundException if file not found.
*@throws InvalidCategoryException if invalid.
*@param args - command line arguments are used.
*/
   public static void main(String[] args) throws FileNotFoundException,
       InvalidCategoryException {
      CardholderProcessor chp = new CardholderProcessor();
      String[] fileName = {"cardholder_data_3_exceptions.txt"};
      if (fileName.length == 0) {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      }
      else {
         for (String file: fileName) {
            try {
               chp.readCardholderFile(file);
               System.out.println(chp.generateReport());
               System.out.println(chp.generateReportByName());
               System.out.println(chp.generateReportByCurrentBalance());
               System.out.println(chp.generateInvalidRecordsReport()); 
            
            }
            catch (FileNotFoundException exception) {
               System.out.print("*** Attempted to read file: " 
                  + file + " (No such file or directory)");
            }
         }
      }
   }
}