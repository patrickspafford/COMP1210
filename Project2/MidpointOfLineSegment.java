import java.util.Scanner;
/** Calculates the midpoint of two points on a line.
*
*Project 2
*@author Patrick Spafford
*@version 9/05/2018
*
*/
public class MidpointOfLineSegment { // Midpoint calculator
/** Calculates the midpoint of two points on a line.
*
*@param args not used
*/
   public static void main(String[] args) {
   /** Takes the inputs and prints the midpoint value.
   *
   */
      Scanner userInput = new Scanner(System.in);
      double x1 = 0;
      double y1 = 0;
      double x2 = 0;
      double y2 = 0;
   
      System.out.print("Enter the coordinates for endpoint 1:");
      System.out.print("\n\tx1 = ");
      x1 = userInput.nextDouble();
      System.out.print("\ty1 = ");
      y1 = userInput.nextDouble();
      
      System.out.print("Enter the coordinates for endpoint 2:");
      System.out.print("\n\tx2 = ");
      x2 = userInput.nextDouble();
      System.out.print("\ty2 = ");
      y2 = userInput.nextDouble();
   
   
      double xMid = (x1 + x2) / 2;
      double yMid = (y1 + y2) / 2;
      
      System.out.println("\nFor endpoints (" + x1 + ", " + y1
         + ") and " + "(" + x2 + ", " + y2 + "), the midpoint is ("
         + xMid + ", " + yMid + ").");
      
   
   }
}