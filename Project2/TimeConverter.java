import java.util.Scanner;
/** Calculates time in various units.
*
*Project 2.
*@author Patrick Spafford
*@version 8-05-2018
*
*/
public class TimeConverter { // Converts time into different units
/** Takes time input and generates time values.
*@param args not used
*/
   public static void main(String[] args) { // Converts values into units.
      Scanner userInput = new Scanner(System.in);
      int seconds = 0;
      System.out.print("Enter the raw time measurement in seconds: ");
      seconds = userInput.nextInt();
      if (seconds < 0) { 
         System.out.print("Measurement must be non-negative!");
      }
      else {
         int days = seconds / 86400;
         int hours = ((seconds % 86400) / 3600);
         int minutes = (((seconds % 86400) % 3600) / 60);
         int seconds2 = ((((seconds % 86400) % 3600) % 60));
         System.out.println("\nMeasurement by combined days, hours, minutes,"
            + " seconds: ");
         System.out.println("\tdays: " + days);
         System.out.println("\thours: " + hours);
         System.out.println("\tminutes: " + minutes);
         System.out.println("\tseconds: " + seconds2);
         System.out.println("\n" + seconds + " seconds = " + days + " days, "
            + hours + " hours, " + minutes + " minutes, " + seconds2
            + " seconds");
      }
   }
}