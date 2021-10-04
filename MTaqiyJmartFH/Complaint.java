package MTaqiyJmartFH;
import java.time.Duration;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Complaint extends Recognizable implements FileParser
{
   SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
   public String desc;
   public String date;
   
   public Complaint(int id, String desc) {
       super(id);
       this.desc = desc;
       this.date = sdf.format(new Date());
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
   
   public String toString(){
        SimpleDateFormat SDformat = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = SDformat.format(this.date);
        return "{date = " + formatDate + "desc = '" + this.desc + "'}"; 
    }
}
