import java.util.Scanner;
/**Object for icosahedron.
*
*Project 4
*
*@author Patrick Spafford COMP 1210 - 010
*@version 9-18-2018
*/
public class IcosahedronApp {
/**.
*Creates icosahedron and proceeds to reports its attributes.
*@param args not used
*/
   public static void main(String[] args) {
      String label = "";
      String color = "";
      double edge;
      String output;
      System.out.print("Enter label, color, and edge length"
         + " for an icosahedron.\n\tlabel: ");
      Scanner userInput = new Scanner(System.in);
      label = userInput.nextLine();
      System.out.print("\tcolor: ");
      color = userInput.nextLine();
      System.out.print("\tedge: ");
      edge = userInput.nextDouble();
      if (edge <= 0) {
         System.out.print("Error: edge must be greater than 0.");
      } else {
         Icosahedron icosahedron1 = new Icosahedron(label, color, edge);
         java.text.DecimalFormat fmt = new java.text.DecimalFormat("#,##0.0"
            + "#####");
         icosahedron1.surfaceArea();
         icosahedron1.volume();
         icosahedron1.surfaceToVolumeRatio();
         icosahedron1.setEdge(edge);
         icosahedron1.setColor(color);
         icosahedron1.setLabel(label);
         output = icosahedron1.toString();
         System.out.printf("\n " + icosahedron1);
      }
         
   
   
   }

}