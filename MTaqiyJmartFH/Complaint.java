package MTaqiyJmartFH;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint
{
   public int productId;
   public ShipmentDuration shipmentDuration;
   
   
   /*public Complaint(int id, int buyerId, int storeId, int paymentId, String desc) {
       super(id);
       this.buyerId = buyerId;
       this.storeId = storeId;
       this.paymentId = paymentId;
       this.desc = desc;
   }*/
   
   public boolean validate() {
       return false;
   }
   
   public Transaction perform() {
       return null;
   }
   
   public boolean read(String string) {
       return false;
   }
   
   public Object write() {
        return null;
    }
   
    public Object newInstance(String string) {
        return null;
    }
}
