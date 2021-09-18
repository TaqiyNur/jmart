package MTaqiyJmartFH;


/**
 * Write a description of class ProductRating here.
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     2006468900
 */
public class ProductRating
{
    // instance variables - replace the example below with your own
    private long total;
    private long count;
    
    public ProductRating() {
        total = 0;
        count = 0;
    }
    
    public void insert(int rating) {
        total = total + rating;
        count++;
    }
    
    public double getAverage() {
        return (double) (total / count);
    }
    
    public long getCount() {
        return count;
    }
    
    public long getTotal() {
        return total;
    }
}
