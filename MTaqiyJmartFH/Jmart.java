package MTaqiyJmartFH;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{
   public static int getPromo() {
       return 0;
   }
   
   public static String getCustomer() {
       return "oop";
   }
   
   public static float getDiscountPercentage(int before, int after) {
       float floatBefore = before;
       float floatAfter = after;
       
       if (before < after) {
           return 0.0f;
       }
       else {
           return ((floatBefore - floatAfter) / floatBefore) * 100.0f;
       }
   }
   
   public static int getDiscountedPrice(int price, float discountPercentage) {
       float floatPrice = price;
       
       if (discountPercentage > 100.0f) {
           return price = 0;
       }
       else {
           float discountedPrice = floatPrice - (floatPrice * discountPercentage / 100);
           return (int) discountedPrice;
       }
   }
   
   public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
       float originalPrice = (100.0f/(100.0f - discountPercentage)) * (float) discountedPrice;
       return (int) originalPrice;
       
   }
   
   public static float getCommissionMultiplier() {
       return 0.05f;
   }
   
   public static int getAdjustedPrice(int price) {
       float adjustedPrice = (float) price + ((float) price *getCommissionMultiplier());
       return (int) adjustedPrice;
       
   }
   
   public static int getAdminFee(int price) {
       float adminFee = (float) price * getCommissionMultiplier();
       return (int) adminFee;
   }
   
   public static Product create() {
       Shipment.MultiDuration multiDuration = new Shipment.MultiDuration();
       PriceTag price = new PriceTag(100000.0);
       Product product = new Product(01, 5, "Sepatu Aero", 1, true, price, ProductCategory.FASHION, multiDuration);
       return product;
   }
   
   public static Coupon createCoupun() {
       Coupon coupon = new Coupon(2, "Kupon", 559910, Coupon.Type.DISCOUNT, 10, 20000.0);
       return coupon;
   }
   
   /*public static Shipment createShipment() {
       Shipment.Duration duration = new Shipment.Duration(Shipment.);
       Shipment shipment = new Shipment("MyAddress", 90000, duration, "Your Receipt");
       return shipment;
   }*/

   public static void main(String[] args) {
       System.out.println(getPromo());
       System.out.println(getCustomer());
       System.out.println(getDiscountPercentage(1000,900));
       System.out.println(getDiscountedPrice(1000,90.0f));
       System.out.println(getOriginalPrice(1000,0));
       System.out.println(getCommissionMultiplier());
       System.out.println(getAdjustedPrice(0));
       System.out.println(getAdminFee(500));
       
       create();
   }
   
}
