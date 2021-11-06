package MTaqiyJmartFH;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Shipment
{
	public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMMM dd yyyy");
    public static final Plan INSTANT = new Plan((byte)(1 << 0));
    public static final Plan SAME_DAY = new Plan((byte)(1 << 1));
    public static final Plan NEXT_DAY = new Plan((byte)(1 << 2));
    public static final Plan REGULER = new Plan((byte)(1 << 3));
    public static final Plan KARGO = new Plan((byte)(1 << 4));
    public byte plan;
    public String address;
    public int Cost;
    public String receipt;
    
    public static class Plan{

        public final byte bit;

        private Plan(byte bit){
            this.bit = bit;
        }
    }
    
    public Shipment(String address, int Cost, byte plan, String receipt) {
        this.address= address;
        this.Cost = Cost;
        this.plan = plan;
        this.receipt = receipt;
    }

    public String getEstimatedArrival (Date reference) {
        Calendar cal = Calendar.getInstance();
        
        if(this.plan == 1 << 0 || this.plan == 1 << 1) {
            return ESTIMATION_FORMAT.format(reference.getTime());
        }
        else if (this.plan == 1 << 2) {
            cal.setTime(reference);
            cal.add(Calendar.DATE, 1);
            return ESTIMATION_FORMAT.format(reference.getTime());
        }
        else if(this.plan == 1 << 3) {
            cal.setTime(reference);
            cal.add(Calendar.DATE, 2);
            return ESTIMATION_FORMAT.format(reference.getTime());
        } 
        else {
            cal.setTime(reference);
            cal.add(Calendar.DATE, 5);
            return ESTIMATION_FORMAT.format(reference.getTime());
        }
    }   
    
    public boolean isDuration(Plan reference){
        if((reference.bit & this.plan) != 0){
            return true;
        }
        return false;
    }

    public boolean isDuration(byte object,Plan reference){
        if((reference.bit & object) != 0){
            return true;
        }
        return false;
    }
}
