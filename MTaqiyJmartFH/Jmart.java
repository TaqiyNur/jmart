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
       if (before < after) {
           return 0;
       }
       else {
           return (float) (before-after/before) * 100;
       }
   }
   public static int getDiscountedPrice(int price, float discountPercentage) {
       discountPercentage = getDiscountPercentage(  000, 900);
       if (discountPercentage > 100.0) {
           return price = 0;
       }
       else {
           return price = price - (price * (int) discountPercentage);
       }
   }
   public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
       return 0;
   }
   public static float getCommissionMultiplier() {
       return (float) 0.05;
   }
   public static int getAdjustedPrice(int price) {
       return 0;
   }
   public static int getAdminFee(int price) {
       return 0;
   }
   public static void main(String[] args) {
       
   }
}
