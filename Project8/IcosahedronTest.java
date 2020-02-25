import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;
/**Project 8A Test File.
*
*@author Patrick Spafford - COMP 1210 - 010
*
*@version 10-23-2018
*
*/
public class IcosahedronTest {
   /** Fixture initialization (common initialization
    *  for all tests). **/
   private static int count = 0;
   /**
   *The set up to the tests.
   */
   @Before public void setUp() {
   }
   /** A test that always fails. 
   *@Test public void defaultTest() {
   *  Assert.assertEquals("Default test added by jGRASP. Delete "
   *        + "this test once you have added your own.", 0, 1);
   * } */
   
   /**
   * Tests the getLabel() method and ensures it is working properly.
   */
   @Test public void getLabelTest() {
      Icosahedron icos = new Icosahedron("Sample", "Color", 1.0);
      String expectedOutput = "Sample";
      Assert.assertEquals(icos.getLabel(), expectedOutput);
   }
/**.
*Tests that the getColor() method is working.
*/
   @Test public void getColorTest() {
      Icosahedron icos = new Icosahedron("Sample", "Color", 1.0);
      String expectedOutput = "Color";
      Assert.assertEquals(icos.getColor(), expectedOutput);
   }
/**.
*Tests the getEdge() method.
*/
   @Test public void getEdgeTest() {
      Icosahedron icos = new Icosahedron("Sample", "Color", 1.0);
      double expectedOutput = 1.0;
      Assert.assertEquals("", expectedOutput, icos.getEdge(), 0.000001);
   }
/**.
*Tests the setLabel() method.
*/
   @Test public void setLabelTest() {
      Icosahedron icos1 = new Icosahedron("", "Color", 1.0);
      boolean actualOutput1 = icos1.setLabel("Sample");
      
      Icosahedron icos2 = new Icosahedron("", "Color", 1.0);
      boolean actualOutput2 = icos2.setLabel(null);
      
      boolean actualOutput = actualOutput1 && !actualOutput2 ? true
         : false;
      Assert.assertEquals(true, actualOutput);
   }
/**.
*Tests the setColor() method.
*/
   @Test public void setColorTest() {
      Icosahedron icos1 = new Icosahedron("Sample", "", 1.0);
      boolean actualOutput1 = icos1.setColor("Color");
      
      Icosahedron icos2 = new Icosahedron("Sample", "", 1.0);
      boolean actualOutput2 = icos2.setColor(null);
      
      boolean actualOutput = actualOutput1 && !actualOutput2 ? true
         : false;
      Assert.assertEquals(true, actualOutput);
   }
/**.
*Tests the setEdge() method.
*/
   @Test public void setEdgeTest() {
      Icosahedron icos1 = new Icosahedron("Sample", "Color", 0.1);
      boolean actualOutput1 = icos1.setEdge(1.0);
      
      Icosahedron icos2 = new Icosahedron("Sample", "Color", -1.0);
      boolean actualOutput2 = icos2.setEdge(-1.0);
      
      boolean actualOutput = actualOutput1 && !actualOutput2 ? true
         : false;
      Assert.assertEquals(true, actualOutput);
   }
/**.
*Tests the surfaceArea() method, and ensures it is in working order.
*/
   @Test public void surfaceAreaTest() {
      Icosahedron i = new Icosahedron("Small", "Blue", 1.2);
      i.surfaceArea();
      double expectedOutput = 5 * Math.sqrt(3) * Math.pow(1.2, 2);
      Assert.assertEquals("", expectedOutput, i.surfaceArea(), .000001);
   }
   /**Tests that the volume method works properly.
   *
   */
   @Test public void volumeTest() {
      Icosahedron a = new Icosahedron("Medium", "Red", 1.0);
      a.volume();
      double expectedOutput = (5 * (3 + Math.sqrt(5)) / 12);
      Assert.assertEquals("", expectedOutput, a.volume(), .01);
   }
   /**Tests that the surfaceToVolumeRatio() method works properly.
   *
   */
   @Test public void surfaceToVolumeRatioTest() {
      Icosahedron b = new Icosahedron("Large", "Orange", 1.0);
      b.surfaceToVolumeRatio();
      double expectedOutput = (5 * Math.sqrt(3) * Math.pow(1, 2)) 
         / (5 * (3 + Math.sqrt(5)) / 12);
      Assert.assertEquals("", expectedOutput, b.surfaceToVolumeRatio(), .01);
   }
   /**Tests that the toString() method works properly.
   *
   */
   @Test public void toStringTest() {
      Icosahedron c = new Icosahedron("Small", "Blue", 0.0);
      java.text.DecimalFormat df1 = new DecimalFormat("#,##0.0#####");
      String output = "Icosahedron \"" + "Small" + "\" is \"" + "Blue"
         + "\" with 30 edges of length " + 0.0 + " units.\n\t"
         + "surface area = 0.0"
         + " square units\n\t"
         + "volume = 0.0" 
         + " cubic units\n\t"
         + "surface/volume ratio = 0.0"; 
      Assert.assertEquals(output, c.toString());
   }
   /**
   *Tests the resetCount() class method.
   */
   @Test public void resetCountTest() {
      count = 0;
      Icosahedron.resetCount();
      Assert.assertEquals(0, count);
   }
   /**
   *Tests the hashCode() method's correctness.
   */
   @Test public void hashCodeTest() {
      Icosahedron icos = new Icosahedron("A", "B", 1.0);
      int actualOutput = icos.hashCode();
      Assert.assertEquals(0, actualOutput);
   }
   /**
   *Tests the static method getCount().
   */
   @Test public void getCountTest() {
      Icosahedron.resetCount();
      int actualOutput = Icosahedron.getCount();
      Assert.assertEquals(0, actualOutput);
   }
   /**
   *Tests the method equalsTest().
   *
   */
   @Test public void equalsTest() {
      boolean actualOutput = true;
      Icosahedron icos1 = new Icosahedron("A", "B", 1.0);
      Object obj2 = new Object();
      boolean actualOutput1 = icos1.equals(obj2);
      
      Icosahedron icos2 = new Icosahedron("a", "b", 1.0);
      boolean actualOutput2 = icos1.equals(icos2);
      
      Icosahedron icos3 = new Icosahedron("A", "B", 1.0);
      boolean actualOutput3 = icos1.equals(icos3);
      
      Icosahedron icos4 = new Icosahedron("X", "Y", 2.0);
      boolean actualOutput4 = icos1.equals(icos4);
      
      Icosahedron icos5 = new Icosahedron("A", "n", 1.0);
      boolean actualOutput5 = icos1.equals(icos5);
      
      Icosahedron icos6 = new Icosahedron("A", "B", 1.234);
      boolean actualOutput6 = icos1.equals(icos6);
      
      actualOutput = actualOutput1 ? false : true;
      actualOutput = actualOutput2 ? true : false;
      actualOutput = actualOutput3 ? true : false;
      actualOutput = actualOutput4 ? false : true;
      actualOutput = actualOutput5 ? false : true;
      actualOutput = actualOutput6 ? false : true;
      
      Assert.assertEquals(true, actualOutput);
   }
}
