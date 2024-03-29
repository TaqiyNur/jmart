package com.MTaqiyJmartFH;


/**
 * Deskripsi penilaian produk
 *
 * @author  mtaqi
 * 
 */
public class ProductRating
{
    // instance variables - replace the example below with your own
    private long total;
    private long count;
    
    public ProductRating() {
        this.total = 0;
        this.count = 0;
    }
    
    public void insert(int rating) {
        this.total = total + rating;
        this.count++;
    }
    
    public double getAverage() {
        if(count == 0) {
            return 0.0;
        }
        return (double) (total / count);
    }
    
    public long getCount() {
        return count;
    }
    
    public long getTotal() {
        return total;
    }
}
