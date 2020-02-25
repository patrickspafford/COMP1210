import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**Blueprint for list of icosahedrons using arrays.
*Project 7
*
*@author Patrick Spafford COMP 1210 - 010
*@version 10-15-2018
*
*/
public class IcosahedronList2 {
/**Stores the name of the list and an array of Icos. objects.
*@param args not used
*
*/
// instance variables
   private String nameOfList;
   private int numberOfIcosahedrons;
   private Icosahedron[] icosahedronList;
// constructor
/**
*Sets up the icosahedron list on inputs.
*@param nameListIn is the name of the list.
*@param listIn is the input array.
*@param numberOfIcosahedronsIn is the number of icos. 
* objects in that array.
*/
   public IcosahedronList2(String nameListIn, Icosahedron[] listIn,
      int numberOfIcosahedronsIn) 
   {
      nameOfList = nameListIn;
      icosahedronList = listIn;
      numberOfIcosahedrons = numberOfIcosahedronsIn;
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
      numberOfIcosahedrons = 0;
      int output = 0;
      for (int i = 0; i < icosahedronList.length; i++)
      {
         if (icosahedronList[i] != null)
         {
            numberOfIcosahedrons++;
         }
      }
      output = numberOfIcosahedrons;
      return output;
      
   }
/**.
*Determines the SA of all Icosahedron objects in the list.
*@return double value of area of all objects.
*/
   public double totalSurfaceArea()
   {
      double output = 0;
      for (int counter = 0; counter < icosahedronList.length;
         counter++) 
      {
         if (icosahedronList[counter] != null) 
         {
            output += icosahedronList[counter].surfaceArea();
         }
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
      for (int counter = 0; counter < icosahedronList.length; 
         counter++)
      {
         if (icosahedronList[counter] != null)
         {
            output += icosahedronList[counter].volume();
         }
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
      if (numberOfIcosahedrons() == 0)
      { 
         return 0.0; }
      else {
         for (int counter = 0; counter < icosahedronList.length;
            counter++) 
         {
            if (icosahedronList[counter] != null)
            {
               output += icosahedronList[counter].surfaceArea();
            }
         }
         output = output / numberOfIcosahedrons(); 
         return output;
      }
   }
/**.
*Determines the avg volume of Icosahedron objects in array.
*@return double value of avg volume of all objects.
*/
   public double averageVolume()
   {
      double output = 0.0;
      if (numberOfIcosahedrons() == 0)
      {
         return 0.0;
      }
      else {
         for (int counter = 0; counter < icosahedronList.length;
            counter++)
         {
            if (icosahedronList[counter] != null)
            {
               output += icosahedronList[counter].volume();
            }
         }
         output = output / numberOfIcosahedrons();
         return output;
      }
   }
/**.
*Determines the avg SA:Volume ratio of objects in list.
*@return double value of avg ratio of all objects.
*/
   public double averageSurfaceToVolumeRatio()
   {
      double output = 0;
      if (numberOfIcosahedrons() == 0)
      {
         return 0.0;
      }
      else {
         for (int counter = 0; counter < icosahedronList.length;
            counter++) 
         {
            if (icosahedronList[counter] != null)
            {
               output += icosahedronList[counter].surfaceToVolumeRatio();
            }
         }
         output = output / numberOfIcosahedrons();
         return output;
      }
   }
/**.
*Converts output to String.
*@return String of list followed by each object
*/
   public String toString()
   {
      String output = nameOfList;
      for (int counter = 0; counter < icosahedronList.length;
         counter++)
      {
         if (icosahedronList[counter] != null)
         {
            output += "\n\n" + icosahedronList[counter].toString();
         } 
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
      numberOfIcosahedrons = 0;
      String output = "----- Summary for " + nameOfList
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
*@return array of Icosahedron objects.
*/
   public Icosahedron[] getList() 
   {
      return icosahedronList;
   }
/**.
*Reads in the input file.
*@param fileIn is this input file.
@throws FileNotFoundException if not found. 
*@return Icosahedron object.
*/
   public IcosahedronList2 readFile(String fileIn) throws
      FileNotFoundException
   {
      String fileName = fileIn;
      String readLabel = "";
      String readColor = "";
      double readEdge = 0.0;
      String titleOfList = "";
      IcosahedronList2 output;
      
      Scanner fileForReading = new Scanner(new File(fileName));
      titleOfList = fileForReading.nextLine();
      for (int counter = 0; fileForReading.hasNext(); counter++)
      {
         readLabel = fileForReading.nextLine().trim();
         readColor = fileForReading.nextLine().trim();
         readEdge = Double.parseDouble(fileForReading.nextLine().trim());
         Icosahedron icos = new Icosahedron(readLabel, readColor, readEdge);
         icosahedronList[counter] = icos;
         
      }
      fileForReading.close();
      IcosahedronList2 icosahedronListObject = new IcosahedronList2(titleOfList,
         icosahedronList, numberOfIcosahedrons);
      output = icosahedronListObject;
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
         
      int n = icosahedronList.length;
      Icosahedron icosahedron1 = new Icosahedron(labelIn, colorIn, edgeIn);
      Icosahedron[] icosahedronListWithAdd = 
                     new Icosahedron[n + 1];
      for (int i = 0; i < n; i++) 
      {
         if (icosahedronList[i] != null)
         {
            icosahedronListWithAdd[i] = icosahedronList[i];
         }
      }
      icosahedronListWithAdd[n - 1] = icosahedron1;  
         
      icosahedronList = icosahedronListWithAdd;
               
   
      
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
      for (int counter = 0; counter < icosahedronList.length; 
         counter++) 
      {
         if (icosahedronList[counter] != null)
         {
            compareLabel = icosahedronList[counter].getLabel();
            if (compareLabel.equalsIgnoreCase(findLabel))
            {
               foundIcosahedron = icosahedronList[counter];
            }
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
      int newLength = icosahedronList.length;
      if (findIcosahedron(findLabel) == null) 
      { 
         return null; 
      } 
      else 
      {
         Icosahedron icos1 = findIcosahedron(findLabel);
         int n = icosahedronList.length;
         for (int counter = 0; counter < n - 1; counter++)
         {
            if (icosahedronList[counter] != null) 
            {
               if (icosahedronList[counter].equals(icos1))
               {
                  output = icos1; //icosahedron is now found.
                  Icosahedron[] icosahedronListWithDelete = 
                        new Icosahedron[n - 1];
                  for (int i = 0; i < n - 1; i++) //makes new list w/ delete
                  {
                     if (icosahedronList[i] != icos1)
                     {
                        icosahedronListWithDelete[i] = icosahedronList[i];
                     }  
                  }
                  icosahedronList = icosahedronListWithDelete;
               }
            }
         } 
      } 
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