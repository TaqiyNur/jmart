package MTaqiyJmartFH;


/**
 * 
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     2006468900
 */
public class ShipmentDuration
{
    // instance variables - replace the example below with your own
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1 << 0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1 << 1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1 << 2);
    public static final ShipmentDuration REGULER = new ShipmentDuration(1 << 3);
    public static final ShipmentDuration KARGO = new ShipmentDuration(1 << 4);
    private final int bit;

    /**
     * Constructor for objects of class ShipmentDuration
     */
    private ShipmentDuration(int bit) {
        // initialise instance variables
        this.bit = bit;
    }

    public ShipmentDuration(ShipmentDuration... args) {
        int temp = 0;
        for (ShipmentDuration s: args) {
            temp = temp | s.bit;
        }
        
        this.bit = temp;
    }
    
    public boolean isDuration(ShipmentDuration reference) {
        int temp = this.bit;
        if((reference.bit & temp) == reference.bit) {
            return true;
        }
        return false;
    }
}
