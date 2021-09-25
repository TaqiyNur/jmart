package MTaqiyJmartFH;


/**
 * 
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     20064698900
 */
public class PriceTag
{
    // instance variables - replace the example below with your own
    public static final double COMMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public static double discount;
    public static double price;

    /**
     * Constructor for objects of class PriceTag
     */
    public PriceTag(double price) {
        // initialise instance variables
        this.price = price;
        this.discount = 0.0;
    }
    
    public PriceTag(double price, double discount) {
        //initialise instance variables
        this.price = price;
        this.discount = discount;
    }
    
    public double getAdjustedPrice() {
        return getDiscountedPrice() + getAdminFee();
    }
    
    public double getAdminFee() {
        if(getDiscountedPrice() < BOTTOM_PRICE)
        {
            return BOTTOM_FEE;
        } else {
            return getDiscountedPrice() - (getDiscountedPrice() * COMMMISSION_MULTIPLIER);
        }
    }
    
    private double getDiscountedPrice() {
        if(discount >= 100.0)
        {
            return 0.0;
        }
        else
        {
            return price - (price * discount);
        }
    }
}
