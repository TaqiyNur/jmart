package MTaqiyJmartFH;


/**
 * Write a description of class Product here.
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     2006468900
 */
public class Product extends Recognizable implements FileParser
{
    private static int idCounter;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;
    public Shipment.MultiDuration multiDuration;

    /**
     * Constructor for objects of class ProductRating
     */
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration) {
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        rating = new ProductRating();
        this.id = ++idCounter;
        this.multiDuration = multiDuration;
    }
    
    public String toString() {
        return "name: " + this.name + "\n" + "weight: " + this.weight + "\n" + 
        "Condition:" + this.conditionUsed + "Price: " + this.priceTag + "\n" +
        "Category: " + this.category + "\n"+ "rating: " + this.rating + "\n" +
        "storeId: " + this.storeId;
    }
    
    public boolean read (String content) {
        return false;
    }
    
    
}
