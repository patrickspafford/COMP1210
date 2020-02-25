import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
/**Main method for list of icosahedrons.
*Project 5
*
*@author Patrick Spafford COMP 1210 - 010
*@version 10-1-2018
*
*/
public class IcosahedronListApp {
/**Generates list of icos. and prints their info with loops.
*@param args not used
*@throws FileNotFoundException required for Scan on file.
*/
   public static void main(String[] args) throws FileNotFoundException {
      ArrayList<Icosahedron> arrayList = new ArrayList<Icosahedron>();
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      Scanner scanFile = new Scanner(new File(fileName));
      
      String titleOfTestList = scanFile.nextLine();
      
      
      while (scanFile.hasNext())
      { 
         String labelOfIcosahedron = scanFile.nextLine();
         String colorOfIcosahedron = scanFile.nextLine();
         double edgeOfIcosahedron = Double.parseDouble(scanFile.nextLine());
         
         Icosahedron icos = new Icosahedron(labelOfIcosahedron, 
               colorOfIcosahedron, edgeOfIcosahedron);
         arrayList.add(icos);
                
      }
      scanFile.close();
      
      IcosahedronList icosahedronList = new IcosahedronList(fileName,
         arrayList);
      
      System.out.print(icosahedronList.toString() 
            + icosahedronList.summaryInfo());
      
      
   
   
   
   
   
   
   }
}