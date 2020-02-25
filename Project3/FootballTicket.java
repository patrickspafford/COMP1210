import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
/**Accept coded football game info.
*
*Project 3
*@author Patrick Spafford COMP 1210 - 010
*@version 9-12-2018
*/
public class FootballTicket {
   static final double STUDENT_DISCOUNT = 0.67;
   static final double FACULTY_STAFF_DISCOUNT = 0.20;
/**.
*Decodes and prints result
*@param args not used
*/
   public static void main(String[] args) { // Decodes ticketCode. 
      String ticketCode;
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter your ticket code: ");
      ticketCode = userInput.nextLine();
      ticketCode = ticketCode.trim();
      if (ticketCode.length() < 25) {
         System.out.println("\nInvalid Ticket Code."
            + "\nTicket code must have at least 25 characters.");
      } else {
         String game, date, time, section, row, seat, price;
         String month, day, year;
         String hour, minute;
         char category;
         category = ticketCode.charAt(0);
         price = ticketCode.substring(1, 6);
         seat = ticketCode.substring(18, 20);
         row = ticketCode.substring(20, 22);
         section = ticketCode.substring(23, 24);
         game = ticketCode.substring(24);
      
         month = ticketCode.substring(10, 12);
         day = ticketCode.substring(12, 14);
         year = ticketCode.substring(14, 18);
         date = month + "/" + day + "/" + year;
      
         hour = ticketCode.substring(6, 8);
         minute = ticketCode.substring(8, 10);
         time = hour + ":" + minute;
      
         double cost = Double.parseDouble(price); //Handles cost
         if (category == 's') {
            cost = cost - (STUDENT_DISCOUNT * cost);    
         }
         else if (category == 'f') {
            cost = cost - (FACULTY_STAFF_DISCOUNT * cost);
         }
         else {
            cost = cost;
         }
         DecimalFormat df = new DecimalFormat("$##0.00");
         cost = cost * .01;
      
      
         Random generator = new Random();
         double prizeNumber = generator.nextDouble();
         prizeNumber = prizeNumber * 10000000;
         DecimalFormat dt = new DecimalFormat("##0");
      
         System.out.println();
         System.out.println("Game: " + game + "   Date: " + date
            + "   Time: " + time);
         System.out.println("Section: " + section   
            + "   Row: " + row + "   Seat: " + seat);
         System.out.println("Price: $125.00" + "   Category: " + category
            + "   Cost: " + df.format(cost));
         System.out.println("Prize Number: "
            + dt.format(prizeNumber)); 
      } 
   
   
   }

}