package MTaqiyJmartFH;


/**
 * Write a description of class Product here.
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     2006468900
 */
public class Product
{
    private static int idCounter;
    public int id;
    public String[] name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;

    /**
     * Constructor for objects of class ProductRating
     */
    public Product(String[] name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {
        name = name;
        weight = weight;
        conditionUsed = conditionUsed;
        priceTag = priceTag;
        category = category;
        rating = new ProductRating();
        id = idCounter;
    }
}
