package com.MTaqiyJmartFH;


/**
 * 
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     20064698900
 */
public class Treasury
{
    // instance variables - replace the example below with your own
    public static final double COMMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    
    static double getAdjustedPrice(double price, double discount) {
        return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
    }
    
    static double getAdminFee(double price, double discount) {
        if(getDiscountedPrice(price, discount) < BOTTOM_PRICE)
        {
            return BOTTOM_FEE;
        } else {
            return getDiscountedPrice(price, discount) - (getDiscountedPrice(price, discount) * COMMMISSION_MULTIPLIER);
        }
    }
    
    static double getDiscountedPrice(double price, double discount) {
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
