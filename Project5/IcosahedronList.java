import java.util.ArrayList;
/**Blueprint for list of icosahedrons.
*Project 5
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
   private java.text.DecimalFormat df = 
      new java.text.DecimalFormat("#,##0.0##");
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
      while (counter <= arrayList.size())
      {
         surfaceAreaObject = arrayList.get(counter).surfaceArea();
         output += surfaceAreaObject;
         counter++;
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
      while (counter <= arrayList.size())
      {
         volumeObject = arrayList.get(counter).volume();
         output += volumeObject;
         counter++;
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
      while (counter <= arrayList.size())
      {
         surfaceAreaObject = arrayList.get(counter).surfaceArea();
         sum += surfaceAreaObject;
         counter++;
      }
      output = sum / arrayList.size();    
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
   
      while (counter <= arrayList.size())
      {
         volumeObject = arrayList.get(counter).volume();
         sum += volumeObject;
         counter++;
      } 
      output = sum / arrayList.size();
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
      double volumeObject;
      double sum = 0;
      while (counter <= arrayList.size())
      {
         volumeObject = arrayList.get(counter).volume();
         sum += volumeObject;
         counter++;
      }
      output = sum / arrayList.size();
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
      while (counter <= arrayList.size())
      {
         output += arrayList.get(counter).toString();
         counter++;
      } 
      return output;
   
   }
/**.
*Converts summary info to String.
*@return String of summaries.
*/
   public String summaryInfo()
   {
      String output = "";
      if (arrayList.size() != 0) { 
         output += "----- Summary for Icosahedron Test List"
            + " -----\n"; }
      else 
      {
         output += "----- Summary for Icosahedron Empty Test List";
      }
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






}