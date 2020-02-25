import java.text.DecimalFormat;
/**Blueprint for icosahedron object.
*Project 8A
*
*@author Patrick Spafford COMP 1210 - 010
*@version 10-22-2018
*
*/
public class Icosahedron {
   /**.
*@param args not used
*
*/
//instance variables
   private String label = "";
   private String color = "";
   private double edge = 0.0;
   //static variables
   private static int count = 0;
//constructor
/**
*Sets up the icosahedron based on inputs.
*@param labelIn is the input label
*@param colorIn is the input color
*@param edgeIn is the input edge size
*/
   public Icosahedron(String labelIn, String colorIn, double edgeIn) {
      setLabel(labelIn);
      setColor(colorIn);
      if (edgeIn >= 0)
      {
         setEdge(edgeIn);
      }
      count++;
   }
//methods
/**.
*Fetches the label
*@return label
*/
   public String getLabel() {
      return label; 
   }
/**
*Fetches the color.
*@return color
*/
   public String getColor() {
      return color;
   }
   /**
   *Determines if color was defined.
   *@param colorIn is input color
   *@return isColorSet
   */
   /**
   *Fetches the length of a side.
   *@return edge
   */
   public double getEdge() {
      return edge;
   }
/**
   *Determines if color was defined.
   *@param colorIn is input color
   *@return isColorSet
   */

   public boolean setColor(String colorIn) {
      boolean isColorSet = false;
      if (colorIn != null) {
         color = colorIn; 
         isColorSet = true;
      } 
      return isColorSet;
   }
   /**
   *Determines if the label was initialized, returns boolean.
   *@param labelIn is the input label
   *@return isLabelSet
   */
   public boolean setLabel(String labelIn) {
      boolean isLabelSet = false;
      if (labelIn != null) {
         label = labelIn;
         isLabelSet = true;
      }
      return isLabelSet;
   }

   /**
   *Determines if edge was set.
   *@param edgeIn is input edge length.
   *@return isEdgeSet
   */
   public boolean setEdge(double edgeIn) {
      boolean isEdgeSet = false;
      if (edgeIn >= 0) {
         edge = edgeIn; 
         isEdgeSet = true; }
      return isEdgeSet; 
   }
   /**
   *Calculates surface area of icosahedron.
   *@return surfaceArea
   */
   public double surfaceArea() {
      double surfaceArea = 5 * Math.sqrt(3) * Math.pow(edge, 2);
      return surfaceArea;
   
   }
   /**
   *Calculates volume of icosahedron.
   @return surfaceArea
   */
   public double volume() {
      double volume = 5 * (3 + Math.sqrt(5)) / 12 * Math.pow(edge, 3);
      return volume;
   }
   /**
   *Calculates ratio of SA to volume.
   *@return surfacetoVolumeRatio.
   */
   public double surfaceToVolumeRatio() {
      double surfaceArea = 5 * Math.sqrt(3) * Math.pow(edge, 2);
      double volume = 5 * (3 + Math.sqrt(5)) / 12 * Math.pow(edge, 3);
      double surfaceToVolumeRatio = surfaceArea / volume;
      if (volume == 0) {
         surfaceToVolumeRatio = 0.0;
      }
      return surfaceToVolumeRatio;
   }
   /**Returns the value of the count field.
   *@return integer, count.
   *
   */
   public static int getCount() {
      return count;
   }
/**Resets the value of count to zero.
*/
   public static void resetCount() {
      count = 0;
   }
   /**Compares an object to an icosahedron.
   *@param obj is the object for comparing.
   *@return boolean value.
   */
   public boolean equals(Object obj) {
      if (!(obj instanceof Icosahedron)) {
         return false;
      }
      else {
         Icosahedron d = (Icosahedron) obj;
         return (label.equalsIgnoreCase(d.getLabel())
            && color.equalsIgnoreCase(d.getColor())
            && Math.abs(edge - d.getEdge()) < .01); }
   }
   /**Required method if equals method is called...
   *@return integer of value zero.
   *
   */
   public int hashCode() {
      return 0;
   }
   /**
   *Converts all values into a readable String for the user.
   *@return output
   */
   public String toString() { 
      java.text.DecimalFormat df1 = new DecimalFormat("#,##0.0#####");
      String output = "Icosahedron \"" + getLabel() + "\" is \"" + getColor()
         + "\" with 30 edges of length " + getEdge() + " units.\n\t"
         + "surface area = " + df1.format(surfaceArea()) + " square units\n\t"
         + "volume = " + df1.format(volume()) + " cubic units\n\t"
         + "surface/volume ratio = " + df1.format(surfaceToVolumeRatio());
         
      return output;
   }
}