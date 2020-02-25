public class CardholderDriver {


   public static void main(String[] args) {
   
      SapphireCardholder sc = new SapphireCardholder("012", "Bob");
      DiamondCardholder dc = new DiamondCardholder("345", "Joe");
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("678", "Bill");
   
      sc.setPrevBalance(1200.00);
      double[] purchaseList = {548.00};
      sc.setPurchases(purchaseList);
      sc.setPayment(200.00);
      
      System.out.println(sc + "\n");
      System.out.println(dc + "\n");
      System.out.println(bdc + "\n");
   
   
   
   
   }


}