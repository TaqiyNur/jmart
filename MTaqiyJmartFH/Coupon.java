package MTaqiyJmartFH;


/**
 * 
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     2006468900
 */
public class Coupon
{
    // instance variables - replace the example below with your own
    public String name;
    public int code;
    public double cut;
    public Type type;
    public double minimum;
    private boolean used;

    /**
     * Constructor for objects of class Coupon
     */
    public Coupon(String name, int code, Type type, double cut, double minimum)
    {
        // initialise instance variables
        this.name = name;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }

    public boolean isUsed() {
        return used;
    }
    
    public boolean canApply(PriceTag priceTag) {
        /*if (PriceTag.getAjustedPrice() >= minimum && used == false) {
            return true;
        }
        else
            return false;
        */
        return true;
    }
    
    public double apply(PriceTag priceTag) {
        return 0.0;
    }
}
