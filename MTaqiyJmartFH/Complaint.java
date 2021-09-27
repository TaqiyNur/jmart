package MTaqiyJmartFH;
import java.time.Duration;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
   public int productId;
   public Duration duration;
   public String desc;
   public String date;
   
   /*public Complaint(int id, int buyerId, int storeId, int paymentId, String desc) {
       super(id, payment.buyerId, payment.storeId);
       this.desc = desc;
   }*/
   
   /*public Complaint(int id, int buyerId, int storeId, int paymentId, String desc) {
       super(id, buyerId, storeId);
       this.paymentId = paymentId;
       this.desc = desc;
   }*/
   
   public Complaint(int id, String desc) {
       super(id);
       this.desc = desc;
   }
   
   public boolean validate() {
       return false;
   }
   
   /*public Transaction perform() {
       return null;
   }*/
   
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
