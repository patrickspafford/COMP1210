import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
/**Provides methods for reading in data file.
*Also generates monthly reports.
*
*@author Patrick Spafford
*@version 11-26-18
*/
public class CardholderProcessor {
//fields
   private Cardholder[] array;
   private String[] invalidRecords;
//constructor
/**Constructor for cardholder processor.
*
*/
   public CardholderProcessor() {
      array = new Cardholder[0];
      invalidRecords = new String[0];
   }
//methods
//
/**Gets the array.
*@return array.
*/
   public Cardholder[] getCardholdersArray() {
      return array;
   }
/**Returns the invalid records.
*@return invalidRecords.
*/
   public String[] getInvalidRecordsArray() {
      return invalidRecords;
   }
   /**Adds an invalid record to the record array.
   *@param recordIn is the record to add.
   */
   public void addInvalidRecord(String recordIn) {
      String[] temp = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
      temp[invalidRecords.length] = recordIn;
      invalidRecords = temp;
   }
   /**
   *@param objIn is the cardholder child object.
   */
   public void addCardholder(Cardholder objIn) {
      Cardholder[] temp = Arrays.copyOf(array, array.length + 1);
      temp[array.length] = objIn;
      array = temp;
   }
   /**Reads in cardholder file.
   *@param dataFileIn is the name of the file.
   *@throws FileNotFoundException if not found.
   *@throws InvalidCategoryException if not one of three carholder categories.
   */
   public void readCardholderFile(String dataFileIn) 
      throws FileNotFoundException {
      File myFile = new File(dataFileIn);
      Scanner fileForReading = new Scanner(myFile);
      String line = "";
      while (fileForReading.hasNext()) { 
         try {   
            line = fileForReading.nextLine();     
            Scanner lineForReading = new Scanner(line);
            lineForReading.useDelimiter(";");
            while (lineForReading.hasNext()) { 
               String readCategory = lineForReading.next();
               if (readCategory.equals("1")) { 
                  SapphireCardholder sh = new SapphireCardholder("", "");
                  String readAcctNumber = lineForReading.next();
                  sh.setAcctNumber(readAcctNumber);
                  String readName = lineForReading.next();
                  sh.setName(readName);
                  double readPrevBalance = Double.parseDouble(
                           lineForReading.next());
                  sh.setPrevBalance(readPrevBalance);
                  double readPayment = 
                           Double.parseDouble(lineForReading.next());
                  sh.setPayment(readPayment);
                  while (lineForReading.hasNext()) {
                     double readPurchases1 = Double.parseDouble(
                              lineForReading.next());
                     sh.addPurchases(readPurchases1); }          
                  this.addCardholder(sh); 
               }
               else if (readCategory.equals("2")) { 
                  
                  DiamondCardholder dh = new DiamondCardholder("", "");
                  String readAcctNumber = lineForReading.next();
                  dh.setAcctNumber(readAcctNumber);
                  String readName = lineForReading.next();
                  dh.setName(readName);
                  double readPrevBalance = Double.parseDouble(
                           lineForReading.next());
                  dh.setPrevBalance(readPrevBalance);
                  double readPayment = 
                           Double.parseDouble(lineForReading.next());
                  dh.setPayment(readPayment);
                  while (lineForReading.hasNext()) {
                     double readPurchases1 = Double.parseDouble(
                              lineForReading.next());
                     dh.addPurchases(readPurchases1); }          
                  this.addCardholder(dh); 
               }
               else if (readCategory.equals("3")) {
                  BlueDiamondCardholder ch = 
                           new BlueDiamondCardholder("", "");
                  String readAcctNumber = lineForReading.next();
                  ch.setAcctNumber(readAcctNumber);
                  String readName = lineForReading.next();
                  ch.setName(readName);
                  double readPrevBalance = Double.parseDouble(
                           lineForReading.next());
                  ch.setPrevBalance(readPrevBalance);
                  double readPayment = 
                           Double.parseDouble(lineForReading.next());
                  ch.setPayment(readPayment);
                  while (lineForReading.hasNext()) {
                     double readPurchases1 = Double.parseDouble(
                              lineForReading.next());
                     ch.addPurchases(readPurchases1); }           
                  this.addCardholder(ch);      
                 
               }     
               else { throw new InvalidCategoryException(); }                 
            } lineForReading.close(); }
         catch (InvalidCategoryException exception) {
            this.addInvalidRecord(line + " *** invalid category ***");  
         }
         catch (NumberFormatException exception) {
            this.addInvalidRecord(line + " *** invalid numeric value ***");
         }    
      } 
      fileForReading.close();
   } 
   /**Generates report.
   *@return String is the report itself.
   */

   public String generateReport() {
      String output = "----------------------------"
         + "\nMonthly Cardholder Report\n"
         + "----------------------------\n";
      for (Cardholder c: array) {
         output += c.toString();
         output += "\n";
      }
      return output;
   }
   /**Generates sorted report.
   *@return String - reports by name order.
   */
   public String generateReportByName() {
      String output = "--------------------------------------";
      output += "\nMonthly Cardholder Report (by Name)\n";
      output += "--------------------------------------\n";
      
      Arrays.sort(array);
      for (Cardholder c: array) {
         output += c.toString();
         output += "\n";
      } 
      return output;
   }
   /**Generates another type of sorted report.
   *@return String  - reports by balance order.
   */
   public String generateReportByCurrentBalance() {
      String output = "---------------------------------------";
      output += "\nMonthly Cardholder Report (by Current Balance)\n";
      output += "---------------------------------------";
      
      Arrays.sort(array, new CurrentBalanceComparator());
      for (Cardholder c: array) {
         output += "\n";
         output += c.toString();
      } 
      output += "\n";
      return output;
   }
   /**
   *@return report of invalid records.
   */
   public String generateInvalidRecordsReport() {
      String output = "-----------------------\n"
         + "Invalid Records Report\n"
         + "-----------------------";
      for (String invalidRecord: invalidRecords) {
         output += "\n";
         output += invalidRecord;
         output += "\n";
      }
      return output;
   }
}