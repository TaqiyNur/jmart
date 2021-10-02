package MTaqiyJmartFH;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Shipment implements FileParser
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt) {
        this.address= address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    
    public static class Duration {
        // instance variables - replace the example below with your own
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("dd-M-yyyy");
        public static final Duration INSTANT = new Duration((byte)(1 << 0));
        public static final Duration SAME_DAY = new Duration((byte)(1 << 1));
        public static final Duration NEXT_DAY = new Duration((byte)(1 << 2));
        public static final Duration REGULER = new Duration((byte)(1 << 3));
        public static final Duration KARGO = new Duration((byte)(1 << 4));
        private byte bit;

        /**
         * Constructor for objects of class Duration
         */
        private Duration(byte bit) {
            // initialise instance variables
            this.bit = bit;
        }

        public String getEstimatedArrival (Date reference) {
            Calendar cal = Calendar.getInstance();
            
            if(this.bit == 1 << 0 || this.bit == 1 << 1) {
                return ESTIMATION_FORMAT.format(reference.getTime());
            }
            else if (this.bit == 1 << 2) {
                cal.setTime(reference);
                cal.add(Calendar.DATE, 1);
                return ESTIMATION_FORMAT.format(cal);
            }
            else if(this.bit == 1 << 3) {
                cal.setTime(reference);
                cal.add(Calendar.DATE, 2);
                return ESTIMATION_FORMAT.format(cal);
            } 
            else {
                cal.setTime(reference);
                cal.add(Calendar.DATE, 5);
                return ESTIMATION_FORMAT.format(cal);
            }
        }
    }
    
    public static class MultiDuration {
        private byte bit;
        
        public MultiDuration(byte... args) {
            for (byte s: args) {
              this.bit = (byte)(this.bit|s);    
            }
            
        }
    
        public boolean isDuration(Duration reference) {
            int temp = this.bit;
            if((reference.bit & temp) == reference.bit) {
                return true;
            }
            return false;
        }
        
        
    }
    
     public boolean read(String string) {
        return false;
    }
}
