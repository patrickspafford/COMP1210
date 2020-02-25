import java.text.DecimalFormat;
/**Blueprint for icosahedron object.
*Project 7
*
*@author Patrick Spafford COMP 1210 - 010
*@version 10-15-2018
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
//constructor
/**
*Sets up the icosahedron based on inputs.
*@param labelIn is the input label
*@param colorIn is the input color
*@param edgeIn is the input edge size
*/
   public Icosahedron(String labelIn, String colorIn, double edgeIn) {
      if (labelIn != null)
      {
         setLabel(labelIn);
      }
      if (colorIn != null)
      {
         setColor(colorIn);
      }
      if (edgeIn != 0)
      {
         setEdge(edgeIn);
      }
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
      if (null != colorIn) {
         isColorSet = true;
         color = colorIn; }
      return isColorSet;
   }
   /**
   *Determines if the label was initialized, returns boolean.
   *@param labelIn is the input label
   *@return isLabelSet
   */
   public boolean setLabel(String labelIn) {
      boolean isLabelSet = false;
      if (null != labelIn) {
         isLabelSet = true;
         label = labelIn;
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
      if (edgeIn > 0) {
         isEdgeSet = true;
         edge = edgeIn; }
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
      return surfaceToVolumeRatio;
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