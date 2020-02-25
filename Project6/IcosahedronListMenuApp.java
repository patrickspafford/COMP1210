import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
/**Main method for list of icosahedrons menu.
*Project 6
*
*@author Patrick Spafford COMP 1210 - 010
*@version 10-8-2018
*
*/
public class IcosahedronListMenuApp {
/**Presents the user with a menu to do a number of things with
*the icosahedrons.
*@param args not used
*@throws FileNotFoundException because of readFile method.
*/
   public static void main(String[] args) throws FileNotFoundException {
      Scanner userInput = new Scanner(System.in);
      String listName = "*** no list name assigned ***";
      ArrayList<Icosahedron> arrayList = new 
         ArrayList<Icosahedron>();
      char switchToggle;
      IcosahedronList icosahedronList = new IcosahedronList(listName, 
         arrayList);
      System.out.println("Icosahedron List System Menu\nR - Read File "
         + "and Create Icosahedron List\nP - Print Icosahedron List\nS - Print" 
         + " Summary\nA - Add Icosahedron\nD - Delete Icosahedron\nF - Find"
         + " Icosahedron\nE - Edit Icosahedron\nQ - Quit");
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         switchToggle = userInput.next().toUpperCase().charAt(0);
         String abandonNextInput = userInput.nextLine();
         switch(switchToggle) {
         //Read File and Create Icos. List.
            case 'R':
               System.out.print("\tFile name: ");
               String inputFileName = userInput.nextLine();
               System.out.println("\tFile read in and Icosahedron List"
                  + " created\n");
               icosahedronList = icosahedronList.readFile(inputFileName);
               break;
         //Print Icos. List.
            case 'P':
               String printList = icosahedronList.toString();
               System.out.println(printList + "\n");
               break;
               //Summary Info
            case 'S':
               String printSummary = icosahedronList.summaryInfo();
               System.out.println(printSummary + "\n");
               break;
            //Add Icos.
            case 'A':
               String addLabel = "";
               String addColor = "";
               double addEdge = 0.0;
               System.out.print("\tLabel: ");
               addLabel = userInput.nextLine();
               System.out.print("\tColor: ");
               addColor = userInput.nextLine();
               System.out.print("\tEdge: ");
               addEdge = Double.parseDouble(userInput.nextLine());
               
               icosahedronList.addIcosahedron(addLabel, addColor, addEdge);
               System.out.println("\t*** Icosahedron added ***\n");
               break;
         //Delete icos.
            case 'D':
               System.out.print("\tLabel: ");
               String labelDelete = userInput.nextLine();
               if (icosahedronList.findIcosahedron(labelDelete) != null)
               {
                  String restOfWord = labelDelete.substring(1, labelDelete.
                     length()).toLowerCase();
                  icosahedronList.deleteIcosahedron(labelDelete);
                  System.out.println("\t\"" + labelDelete.toUpperCase()
                     .charAt(0) + restOfWord + "\"" + " deleted\n");
               }
               else {
                  System.out.println("\t\"" + labelDelete + "\"" 
                     + " not found\n"); }
               break;
         //Find icos.
            case 'F':
               String findLabel;
               System.out.print("\tLabel: ");
               findLabel = userInput.nextLine().trim();
               if (icosahedronList.findIcosahedron(findLabel) != null) {
                  String printItem = icosahedronList.findIcosahedron(findLabel)
                     .toString();
                  System.out.println(printItem + "\n");
               }
               else {
                  System.out.println("\t\"" + findLabel + "\"" 
                     + " not found\n"); }
               break;
         //Edit icos.
            case 'E':
               String findEditLabel, editColor;
               double editEdge;
               System.out.print("\tLabel: ");
               findEditLabel = userInput.nextLine().trim();
               System.out.print("\tColor: ");
               editColor = userInput.nextLine().trim();
               System.out.print("\tEdge: ");
               editEdge = Double.parseDouble(userInput.nextLine());
               if (icosahedronList.findIcosahedron(findEditLabel) 
                  != null)
               {
                  icosahedronList.editIcosahedron(findEditLabel, editColor, 
                     editEdge);
                  System.out.println("\t\"" + findEditLabel + "\"" 
                     + " successfully edited\n");
               }
               else {
                  System.out.println("\t\"" + findEditLabel + "\"" 
                     + " not found\n");
               }
               break;
         //Quit
            case 'Q':
               break;
         //Default
            default:
               System.out.println("\t*** invalid code ***\n");
               break;
         } }
      while (switchToggle != 'Q');
   
   
   } //main method bracket

} //class bracket
