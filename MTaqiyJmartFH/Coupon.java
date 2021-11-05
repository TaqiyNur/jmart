package MTaqiyJmartFH;


/**
 * 
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     2006468900
 */
public class Coupon extends Recognizable
{
	public enum Type {
        DISCOUNT, REBATE
    }
	
    // instance variables - replace the example below with your own
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;

    /**
     * Constructor for objects of class Coupon
     */
    public Coupon(String name, int code, Type type, double cut, double minimum) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }

    public boolean isUsed() {
        return used;
    }
    
    public boolean canApply(double price, double discount) {
        if ((Treasury.getAdjustedPrice(price, discount) > minimum) && !used) {
            return true;
        }
            
        return false;
    }
    
    public double apply(double price, double discount) {
        used = true;
        if(type == Type.DISCOUNT) {
            return (Treasury.getAdjustedPrice(price, discount) - ((100 - cut) / 100));
        }
        
        return (Treasury.getAdjustedPrice(price, discount) - cut);
    }
}
