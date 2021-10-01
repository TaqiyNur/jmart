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
   public String desc;
   public String date;
   
   public Complaint(int id, String desc) {
       super(id);
       this.desc = desc;
       this.date = "10/11/02";
   }
   
   public boolean validate() {
       return false;
   }
   
   public Transactor perform() {
       return null;
   }
   
   public boolean read(String string) {
       return false;
   }
}
