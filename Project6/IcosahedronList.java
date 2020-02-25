import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**Blueprint for list of icosahedrons.
*Project 6
*
*@author Patrick Spafford COMP 1210 - 010
*@version 10-1-2018
*
*/
public class IcosahedronList {
/**Stores the name of the list and an ArrayList of Icos. objects.
*@param args not used
*
*/
// instance variables
   private String nameOfList;
   private ArrayList<Icosahedron> arrayList;
// constructor
/**
*Sets up the icosahedron list on inputs.
*@param nameListIn is the name of the list.
*@param arrayListIn is the input array.
*/
   public IcosahedronList(String nameListIn, ArrayList<Icosahedron>
      arrayListIn) 
   {
      nameOfList = nameListIn;
      arrayList = arrayListIn;
   }
//methods
/**.
*Fetches the name of list
*@return nameOfList
*/
   public String getName() 
   {
      return nameOfList;
   }
/**.
*Determines the number of Icosahedron objects in the list.
*@return integer value of # of objects
*/

   public int numberOfIcosahedrons()
   {
      if (arrayList.size() == 0) {
         return 0;
      } else {
         return arrayList.size();
      }
   }
/**.
*Determines the SA of all Icosahedron objects in the list.
*@return double value of area of all objects
*/
   public double totalSurfaceArea()
   {
      double output = 0;
      int counter = 0;
      double surfaceAreaObject;
      while (counter < arrayList.size())
      {
         surfaceAreaObject = arrayList.get(counter).surfaceArea();
         output += surfaceAreaObject;
         ++counter;
      } 
      return output;
   }
   /**.
   *Determines the total volume of all Icosahedron objects in list.
   *@return double value of total volume of all objects.
   */

   public double totalVolume()
   {
      double output = 0;
      int counter = 0;
      double volumeObject;
      while (counter < arrayList.size())
      {
         volumeObject = arrayList.get(counter).volume();
         output += volumeObject;
         ++counter;
      }
      return output;
   }
/**.
*Determines the avg SA of all Icosahedron objects in list.
*@return double value of avg area of all objects.
*/
   public double averageSurfaceArea()
   {
      double output = 0;
      int counter = 0;
      double surfaceAreaObject;
      double sum = 0;
      if (arrayList.size() == 0)
      {
         output = 0;
      }
      else {
         while (counter < arrayList.size())
         {
            surfaceAreaObject = arrayList.get(counter).surfaceArea();
            sum += surfaceAreaObject;
            ++counter;
         }
         output = sum / arrayList.size();
      }   
      return output;
      
   }
/**.
*Determines the avg volume of Icosahedron objects in list.
*@return double value of avg volume of all objects.
*/
   public double averageVolume()
   {
      int counter = 0;
      double output = 0;
      double volumeObject;
      double sum = 0;
      if (arrayList.size() == 0)
      {
         output = 0;
      }
      else {
      
         while (counter < arrayList.size())
         {
            volumeObject = arrayList.get(counter).volume();
            sum += volumeObject;
            ++counter;
         } 
         output = sum / arrayList.size();
      }
      return output;
   }
/**.
*Determines the avg SA:Volume ratio of objects in list.
*@return double value of avg ratio of all objects.
*/
   public double averageSurfaceToVolumeRatio()
   {
      int counter =  0;
      double output = 0;
      double surfaceObject;
      double volumeObject;
      double surfaceToVolumeSum = 0;
      if (arrayList.size() == 0)
      {
         output = 0;
      }
      else {
         while (counter < arrayList.size())
         {
            surfaceObject = arrayList.get(counter).surfaceArea();
            volumeObject = arrayList.get(counter).volume();
            surfaceToVolumeSum += (surfaceObject / volumeObject);
            ++counter;
         }
         
         output = surfaceToVolumeSum / arrayList.size();
      }
      return output;
   }
/**.
*Converts output to String.
*@return String of list followed by each object
*/
   public String toString()
   {
      int counter = 0;
      String output = nameOfList;
      while (counter < arrayList.size())
      {
         output += "\n\n" + arrayList.get(counter).toString();
         ++counter;
      } 
      return output;
   
   }
/**.
*Converts summary info to String.
*@return String of summaries.
*/
   public String summaryInfo()
   {
      java.text.DecimalFormat df = 
         new java.text.DecimalFormat("#,##0.0##");
      String output = "\n----- Summary for " + nameOfList
            + " -----"; 
      output += "\nNumber of Icosahedrons: " 
            + numberOfIcosahedrons();
      output += "\nTotal Surface Area: " 
            + df.format(totalSurfaceArea());
      output += "\nTotal Volume: "
            + df.format(totalVolume());
      output += "\nAverage Surface Area: " 
            + df.format(averageSurfaceArea());
      output += "\nAverage Volume: " 
            + df.format(averageVolume());
      output += "\nAverage Surface/Volume Ratio: " 
            + df.format(averageSurfaceToVolumeRatio());
       
      return output;
      
   }
/**.
*Retrives the list.
*@return arrayList of Icosahedron objects.
*/
   public ArrayList<Icosahedron> getList() 
   {
      return arrayList;
   }
/**.
*Reads in the input file.
*@param fileIn is this input file.
@throws FileNotFoundException if not found. 
*@return Icosahedron object.
*/
   public IcosahedronList readFile(String fileIn) throws
      FileNotFoundException
   {
      String fileName = fileIn;
      String readLabel = "";
      String readColor = "";
      double readEdge = 0.0;
      String titleOfList = "";
      IcosahedronList output;
      
      Scanner fileForReading = new Scanner(new File(fileName));
      titleOfList = fileForReading.nextLine();
      while (fileForReading.hasNext())
      {
         readLabel = fileForReading.nextLine().trim();
         readColor = fileForReading.nextLine().trim();
         readEdge = Double.parseDouble(fileForReading.nextLine().trim());
         Icosahedron icos = new Icosahedron(readLabel, readColor, readEdge);
         arrayList.add(icos);
      }
      fileForReading.close();
      IcosahedronList icosahedronList = new IcosahedronList(titleOfList,
         arrayList);
      output = icosahedronList;
      return output;
      
   }
/**.
*Adds an icosahedron to the list.
*@param labelIn is the label of the icos.
*@param colorIn is the color of the icos.
*@param edgeIn is the edge length of the icos.
*/
   public void addIcosahedron(String labelIn, String colorIn, double edgeIn)
   {
      Icosahedron icosahedron1 = new Icosahedron(labelIn, colorIn, edgeIn);
      arrayList.add(icosahedron1);
   }
/**.
*Searches for the icosahedron
*@param findLabel is the label searched for.
*@return Icosahedron object.
*/
   public Icosahedron findIcosahedron(String findLabel)
   {
      String compareLabel = "";
      Icosahedron foundIcosahedron = null;
      Icosahedron output = null;
      for (int counter = 0; counter < arrayList.size(); counter++) 
      {
         compareLabel = arrayList.get(counter).getLabel();
         if (compareLabel.equalsIgnoreCase(findLabel))
         {
            foundIcosahedron = arrayList.get(counter);
         }
      }
      output = foundIcosahedron;
      return output;
   }
/**.
*Deletes a labeled Icosahedron from the list.
*@param findLabel is the searched for label.
*@return Icosahedron object, or null if it doesn't exist.
*/
   public Icosahedron deleteIcosahedron(String findLabel)
   {
      Icosahedron output = null;
      if (findLabel != null)
      {
         if (findIcosahedron(findLabel).equals(null)) 
         { 
            return null; 
         } 
         else 
         {
            Icosahedron icos1 = findIcosahedron(findLabel);
            if (icos1 != null) {
               arrayList.remove(icos1);
               output = icos1; }
         } }
      return output;
         
      
   }
/**.
*
*@param editColor is the new color.
*@param findLabel is the new label.
*@param editEdge is the new edge length.
*@return boolean
*/
   public boolean editIcosahedron(String findLabel, String editColor, 
      double editEdge)
   {
      if (findLabel != null && editColor != null && editEdge != 0) {
         if (findIcosahedron(findLabel).equals(null))
         {
            return false;
         }
         else {
            Icosahedron icos1 = findIcosahedron(findLabel);
            if (icos1 != null) {
               icos1.setColor(editColor);
               icos1.setEdge(editEdge);
            }
         }
      }
      return true;
        
   }




}