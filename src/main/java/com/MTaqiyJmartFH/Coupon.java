package com.MTaqiyJmartFH;

import com.MTaqiyJmartFH.dbjson.Serializable;

/**
 * Kelas untuk mendeskripsikan objek kupon
 * @author mtaqi
 *
 */
public class Coupon extends Serializable
{
	/**
	 * enumeration Type sebagai tipe dari potongan harga
	 * @author mtaqi
	 *
	 */
	public enum Type {
        DISCOUNT, REBATE
    }
	
    
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;

    /**
     * Constructor untuk objek class Coupon
     * @param name
     * @param code
     * @param type
     * @param cut
     * @param minimum
     */
    public Coupon(String name, int code, Type type, double cut, double minimum) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }
    
    /**
     * Method untuk mengetahui kupon telah digunakan
     * @return Kondisi kupon telah digunakan
     */
    public boolean isUsed() {
        return used;
    }
    
    /**
     * Method untuk mengetahui kondisi penggunaan kupon
     * @param price
     * @param discount
     * @return Kondisi kupon bisa digunakan atau tidak
     */
    public boolean canApply(double price, double discount) {
        if ((Treasury.getAdjustedPrice(price, discount) > minimum) && !used) {
            return true;
        }
            
        return false;
    }
    
    /**
     * Method untuk menggunakan kupon terhadap harga
     * @param price
     * @param discount
     * @return Harga yang telah diterapkan kupon
     */
    public double apply(double price, double discount) {
        used = true;
        if(type == Type.DISCOUNT) {
            return (Treasury.getAdjustedPrice(price, discount) - ((100 - cut) / 100));
        }
        
        return (Treasury.getAdjustedPrice(price, discount) - cut);
    }
}
