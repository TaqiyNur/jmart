package MTaqiyJmartFH;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Complaint extends Recognizable implements FileParser
{
   public Date date;
   public String desc;
   
   public Complaint(int id, String desc) {
       super(id);
       this.desc = desc;
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
