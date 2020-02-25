import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;
/**Test file for IcosahedronList2.
*@author Patrick Spafford - COMP 1210 - 010
*@version 10-24-2018
*/
public class IcosahedronList2Test {
   /** Fixture initialization (common initialization
    *  for all tests). **/
    
    /**Default setUp() test.
    *
    */
   @Before public void setUp() { }
/**
*Tests the getName() method.
*/
   @Test public void getNameTest() { 
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron[] icosList = {a};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 1);
      String actualOutput = i.getName();
      Assert.assertEquals("Name of List", actualOutput);
   }
/**
*Tests the numberOfIcosahedrons() method.
*/
   @Test public void numberOfIcosahedronsTest() {
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron[] icosList1 = {a};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList1, 1);
      int actualOutput1 = i.numberOfIcosahedrons();
      
      Icosahedron b = null;
      Icosahedron[] icosList2 = {b};
      IcosahedronList2 j = new IcosahedronList2("Null List", icosList2, 1);
      int actualOutput2 = j.numberOfIcosahedrons();
      boolean actualOutput = (actualOutput2 == 0 && actualOutput1 == 1)
         ? true : false;
      Assert.assertTrue(actualOutput);
   }
/**
*Tests the totalSurfaceArea() method.
*/
   @Test public void totalSurfaceAreaTest() { 
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron[] icosList = {a};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 1);
      double expectedOutput1 = (5 * Math.sqrt(3) * Math.pow(1, 2));
      double actualOutput1 = i.totalSurfaceArea();
      
      Icosahedron b = null;
      Icosahedron[] icosList2 = {b};
      IcosahedronList2 j = new IcosahedronList2("Null List", icosList2, 1);
      double actualOutput2 = j.totalSurfaceArea();
      boolean actualOutput = (actualOutput2 == 0 
         && actualOutput1 == expectedOutput1)
         ? true : false;
      Assert.assertTrue(actualOutput);
   }
/**
*Tests the totalVolume() method.
*/
   @Test public void totalVolumeTest() { 
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron[] icosList = {a};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 1);
      double expectedOutput1 = 5 * (3 + Math.sqrt(5)) / 12 * Math.pow(1, 3);
      double actualOutput1 = i.totalVolume();
      Icosahedron b = null;
      Icosahedron[] icosList2 = {b};
      IcosahedronList2 j = new IcosahedronList2("Null List", icosList2, 1);
      double actualOutput2 = j.totalVolume();
      boolean actualOutput = (actualOutput2 == 0 
         && actualOutput1 == expectedOutput1)
         ? true : false;
      Assert.assertTrue(actualOutput);
   }
/**
*Tests the averageVolume() method.
*/
   @Test public void averageVolumeTest() {
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron b = new Icosahedron("C", "D", 1.0);
      Icosahedron c = null;
      Icosahedron[] icosList = {a, b, c};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 3);
      double expectedOutput1 = 5 * (3 + Math.sqrt(5)) / 12 * Math.pow(1, 3);
      double actualOutput1 = i.averageVolume();
      
      Icosahedron f = null;
      Icosahedron[] icosList2 = {f};
      IcosahedronList2 j = new IcosahedronList2("Null List", icosList2, 1);
      double actualOutput2 = j.averageVolume();
      boolean actualOutput = (actualOutput2 == 0 
         && actualOutput1 == expectedOutput1)
         ? true : false;
      Assert.assertTrue(actualOutput);
   }
/**
*Tests the averageSurfaceArea() method.
*/
   @Test public void averageSurfaceAreaTest() {
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron b = new Icosahedron("C", "D", 1.0);
      Icosahedron c = null;
      Icosahedron[] icosList = {a, b, c};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 3);
      double expectedOutput1 = 5 * Math.sqrt(3) * Math.pow(1, 2);
      double actualOutput1 = i.averageSurfaceArea();
      Icosahedron f = null;
      Icosahedron[] icosList2 = {f};
      IcosahedronList2 j = new IcosahedronList2("Null List", icosList2, 1);
      double actualOutput2 = j.averageSurfaceArea();
      boolean actualOutput = (actualOutput2 == 0 
         && actualOutput1 == expectedOutput1)
         ? true : false;
      Assert.assertTrue(actualOutput);
   }
/**
*Tests the averageSurfaceToVolumeRatio() method.
*/
   @Test public void averageSurfaceToVolumeRatioTest() {
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron b = new Icosahedron("C", "D", 1.0);
      Icosahedron c = null;
      Icosahedron[] icosList = {a, b, c};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 3);
      double expectedOutput1 = (5 * Math.sqrt(3) * Math.pow(1, 2)) 
         / (5 * (3 + Math.sqrt(5)) / 12 * Math.pow(1, 3));
      double actualOutput1 = i.averageSurfaceToVolumeRatio();
      Icosahedron f = null;
      Icosahedron[] icosList2 = {f};
      IcosahedronList2 j = new IcosahedronList2("Null List", icosList2, 1);
      double actualOutput2 = j.averageSurfaceToVolumeRatio();
      boolean actualOutput = (actualOutput2 == 0 
         && actualOutput1 == expectedOutput1)
         ? true : false;
      Assert.assertTrue(actualOutput);
   }
/**
*Tests the toString() method.
*/
   @Test public void toStringTest() {
      java.text.DecimalFormat df1 = new DecimalFormat("#,##0.0#####"); 
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron b = new Icosahedron("C", "D", 1.0);
      Icosahedron[] icosList = {a, b};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 2);
      String expectedOutput = "Name of List\n\nIcosahedron \"" + "A" 
         + "\" is \"" + "B"
         + "\" with 30 edges of length " + "1.0" + " units.\n\t"
         + "surface area = " + df1.format(5 * Math.sqrt(3) * Math.pow(1, 2)) 
         + " square units\n\tvolume = " 
         + df1.format(5 * (3 + Math.sqrt(5)) / 12
         * Math.pow(1, 3)) + " cubic units\n\tsurface/volume ratio = " 
         + df1.format((5 * Math.sqrt(3) * Math.pow(1, 2)) 
         / (5 * (3 + Math.sqrt(5)) / 12 * Math.pow(1, 3)));
      expectedOutput += "\n\nIcosahedron \"" + "C" + "\" is \"" + "D"
         + "\" with 30 edges of length " + "1.0" + " units.\n\t"
         + "surface area = " + df1.format(5 * Math.sqrt(3) 
         * Math.pow(1, 2)) 
         + " square units\n\tvolume = " + df1.format(5 
         * (3 + Math.sqrt(5)) / 12
         * Math.pow(1, 3)) + " cubic units\n\tsurface/volume ratio = " 
         + df1.format((5 * Math.sqrt(3) * Math.pow(1, 2)) 
         / (5 * (3 + Math.sqrt(5)) / 12 * Math.pow(1, 3)));
      String actualOutput = i.toString();
      Assert.assertEquals(expectedOutput, actualOutput);
   }
/**
*Tests the summaryInfo() method.
*/
   @Test public void summaryInfoTest() { 
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron[] icosList = {a};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 1);
      java.text.DecimalFormat df = 
         new java.text.DecimalFormat("#,##0.0##");
      String expectedOutput = "----- Summary for Name of List"
            + " -----"; 
      expectedOutput += "\nNumber of Icosahedrons: " 
            + "1";
      expectedOutput += "\nTotal Surface Area: " 
            + df.format(5 * Math.sqrt(3) * Math.pow(1, 2));
      expectedOutput += "\nTotal Volume: "
            + df.format(5 * (3 + Math.sqrt(5)) / 12 * Math.pow(1, 3));
      expectedOutput += "\nAverage Surface Area: " 
            + df.format(5 * Math.sqrt(3) * Math.pow(1, 2));
      expectedOutput += "\nAverage Volume: " 
            + df.format(5 * (3 + Math.sqrt(5)) / 12 * Math.pow(1, 3));
      expectedOutput += "\nAverage Surface/Volume Ratio: " 
            + df.format((5 * Math.sqrt(3) * Math.pow(1, 2)) 
         / (5 * (3 + Math.sqrt(5)) / 12 * Math.pow(1, 3)));
      String actualOutput = i.summaryInfo();
      Assert.assertEquals(expectedOutput, actualOutput); 
   }
/**
*
*/
   @Test public void getListTest() { 
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron[] icosList = {a};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 1);
      Icosahedron[] actualOutput = i.getList();
      Icosahedron[] expectedOutput = {a};
      Assert.assertArrayEquals(expectedOutput, actualOutput);
   }
/**
*@throws FileNotFoundException for this test.
*/
   @Test public void readFileTest() throws FileNotFoundException {
      Icosahedron a = new Icosahedron("Small", "blue", 0.01);
      Icosahedron b = new Icosahedron("Medium", "orange", 12.3);
      Icosahedron c = new Icosahedron("Large", "white", 123.4);
      Icosahedron[] icosList = {a, b, c};
      IcosahedronList2 i = new IcosahedronList2("Icosahedron Test List",
          icosList, 3);
      String actualOutput = i.readFile("icosahedron_data_1.txt").toString();
      String expectedOutput = i.toString();
      Assert.assertEquals(expectedOutput, actualOutput);
   }
/**
*!
*/
   @Test public void addIcosahedronTest() {
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron[] icosList = {a};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 1);
      i.addIcosahedron("Tiny", "Pink", 2.0);
      String actualOutput = i.toString();
      
      Icosahedron c = new Icosahedron("Tiny", "Pink", 2.0);
      Icosahedron[] icosList2 = {c};
      IcosahedronList2 j = new IcosahedronList2("Name of List", icosList2, 1);
      String expectedOutput = j.toString();
      
      
      Assert.assertEquals(expectedOutput, actualOutput); 
   }
/**
*!
*/
   @Test public void editIcosahedronTest() { 
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron[] icosList = {a};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 1);
      i.editIcosahedron("A", null, 2.0);
      i.editIcosahedron(null, "B++", 2.0);
      i.editIcosahedron("A", "B++", 0.0);
      i.editIcosahedron("A", "B++", 2.0);
      String actualOutput = i.toString();
      
      Icosahedron d = new Icosahedron("A", "B++", 2.0);
      Icosahedron[] icosList2 = {d};
      IcosahedronList2 k = new IcosahedronList2("Name of List", icosList2, 1);
      String expectedOutput = k.toString();
      
      Assert.assertEquals(expectedOutput, actualOutput);
   }
/**
*
*/
   @Test public void findIcosahedronTest() {
      Icosahedron a = new Icosahedron("A", "B", 1.0);
      Icosahedron b = null;
      Icosahedron[] icosList = {a, b};
      IcosahedronList2 i = new IcosahedronList2("Name of List", icosList, 1);
      Icosahedron actualOutput = i.findIcosahedron(null);
      actualOutput = i.findIcosahedron("A");
      Icosahedron expectedOutput = a;
      Assert.assertEquals(expectedOutput, actualOutput);
   }
/**
*!
*/
   @Test public void deleteIcosahedronTest() { 
      Icosahedron a = new Icosahedron("Small", "blue", 0.01);
      Icosahedron b = new Icosahedron("Medium", "orange", 12.3);
      Icosahedron c = new Icosahedron("Large", "white", 123.4);
      Icosahedron[] icosList = {a, b, c};
      IcosahedronList2 i = new IcosahedronList2("Icosahedron Test List",
          icosList, 3);
      i.deleteIcosahedron("Medium");
      i.deleteIcosahedron("Large");
      String actualOutput = i.toString();
      
      Icosahedron[] icosList2 = {a};
      IcosahedronList2 m = new IcosahedronList2(
         "Icosahedron Test List", icosList2, 1);
      String expectedOutput = m.toString();
      Assert.assertEquals(expectedOutput, actualOutput);
   }
/**
*!
*/
   @Test public void findIcosahedronWithShortestEdgeTest() {
      Icosahedron a = new Icosahedron("Small", "blue", 0.01);
      Icosahedron b = new Icosahedron("Medium", "orange", 12.3);
      Icosahedron c = new Icosahedron("Large", "white", 123.4);
      Icosahedron[] icosList = {b, a, c};
      IcosahedronList2 i = new IcosahedronList2("Icosahedron Test List",
          icosList, 3);
      Icosahedron actualOutput1 = i.findIcosahedronWithShortestEdge();
      Icosahedron expectedOutput1 = a;
      Icosahedron[] icosList2 = {};
      IcosahedronList2 m = new IcosahedronList2("Icosahedron Test List",
          icosList2, 0);
      Icosahedron actualOutput2 = m.findIcosahedronWithShortestEdge();
      Icosahedron expectedOutput2 = null;
      
      Icosahedron d = null;
      Icosahedron[] icosList3 = {a, d, b, c};
      IcosahedronList2 p = new IcosahedronList2("Icosahedron Test List",
         icosList3, 4);
      Icosahedron expectedOutput3 = a;
      Icosahedron actualOutput3 = p.findIcosahedronWithShortestEdge();
      
      boolean expectedOutput = (actualOutput2 == expectedOutput2 
            && actualOutput1 == expectedOutput1 && actualOutput3 
            == expectedOutput3) ? true : false;
      
      Assert.assertTrue(expectedOutput);
   }
/**
*!
*/
   @Test public void findIcosahedronWithLongestEdgeTest() {
      Icosahedron a = new Icosahedron("Small", "blue", 0.01);
      Icosahedron b = new Icosahedron("Medium", "orange", 12.3);
      Icosahedron c = new Icosahedron("Large", "white", 123.4);
      Icosahedron[] icosList = {a, b, c};
      IcosahedronList2 i = new IcosahedronList2("Icosahedron Test List",
          icosList, 3);
      Icosahedron actualOutput1 = i.findIcosahedronWithLongestEdge();
      Icosahedron expectedOutput1 = c;
      Icosahedron[] icosList2 = {};
      IcosahedronList2 m = new IcosahedronList2("Icosahedron Test List",
          icosList2, 0);
      Icosahedron actualOutput2 = m.findIcosahedronWithLongestEdge();
      Icosahedron expectedOutput2 = null;
      
      Icosahedron d = null;
      Icosahedron[] icosList3 = {a, d, b, c};
      IcosahedronList2 p = new IcosahedronList2("Icosahedron Test List",
         icosList3, 4);
      Icosahedron expectedOutput3 = c;
      Icosahedron actualOutput3 = p.findIcosahedronWithLongestEdge();
      boolean expectedOutput = (actualOutput2 == expectedOutput2 
            && actualOutput1 == expectedOutput1 && actualOutput3 
            == expectedOutput3) ? true : false;
               
      Assert.assertTrue(expectedOutput);
   }
/**
*!
*/
   @Test public void findIcosahedronWithSmallestVolumeTest() { 
      Icosahedron a = new Icosahedron("Small", "blue", 0.01);
      Icosahedron b = new Icosahedron("Medium", "orange", 12.3);
      Icosahedron c = new Icosahedron("Large", "white", 123.4);
      Icosahedron[] icosList1 = {b, a, c};
      IcosahedronList2 i = new IcosahedronList2("Icosahedron Test List",
          icosList1, 3);
      Icosahedron actualOutput1 = i.findIcosahedronWithSmallestVolume();
      Icosahedron expectedOutput1 = a;
      Icosahedron[] icosList2 = {};
      IcosahedronList2 m = new IcosahedronList2("Icosahedron Test List",
          icosList2, 0);
      Icosahedron actualOutput2 = m.findIcosahedronWithSmallestVolume();
      Icosahedron expectedOutput2 = null;
      
      Icosahedron d = null;
      Icosahedron[] icosList3 = {a, d, b, c};
      IcosahedronList2 p = new IcosahedronList2("Icosahedron Test List",
         icosList3, 4);
      Icosahedron expectedOutput3 = a;
      Icosahedron actualOutput3 = p.findIcosahedronWithSmallestVolume();
      
      boolean expectedOutput = (actualOutput2 == expectedOutput2 
            && actualOutput1 == expectedOutput1 && actualOutput3 
            == expectedOutput3) ? true : false;
      Assert.assertTrue(expectedOutput);
   }
/**
*!
*/
   @Test public void findIcosahedronWithLargestVolumeTest() {
      Icosahedron a = new Icosahedron("Small", "blue", 0.01);
      Icosahedron b = new Icosahedron("Medium", "orange", 12.3);
      Icosahedron c = new Icosahedron("Large", "white", 123.4);
      Icosahedron[] icosList = {a, b, c};
      IcosahedronList2 i = new IcosahedronList2("Icosahedron Test List",
          icosList, 3);
      Icosahedron actualOutput1 = i.findIcosahedronWithLargestVolume();
      Icosahedron expectedOutput1 = c;
      Icosahedron[] icosList2 = {};
      IcosahedronList2 m = new IcosahedronList2("Icosahedron Test List",
          icosList2, 0);
      Icosahedron actualOutput2 = m.findIcosahedronWithLargestVolume();
      Icosahedron expectedOutput2 = null;
      
      Icosahedron d = null;
      Icosahedron[] icosList3 = {a, d, b, c};
      IcosahedronList2 p = new IcosahedronList2("Icosahedron Test List",
         icosList3, 4);
      Icosahedron expectedOutput3 = c;
      Icosahedron actualOutput3 = p.findIcosahedronWithLargestVolume();
      
      boolean expectedOutput = (actualOutput2 == expectedOutput2 
            && actualOutput1 == expectedOutput1 && actualOutput3 
            == expectedOutput3) ? true : false; 
      
      Assert.assertTrue(expectedOutput);
   } 
}

