package MTaqiyJmartFH;


/**
 * Write a description of class Product here.
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     2006468900
 */
public class Product extends Seriazable
{
    public String name;
    public int weight;
    public boolean conditionUsed;
    public ProductCategory category;
    public int accountId;
    public double discount;
    public double price;
    public byte shipmentPlans;

    /**
     * Constructor for objects of class ProductRating
     */
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans) {
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }
    
    public String toString() {
        return "name: " + this.name + "\n" + "weight: " + this.weight + "\n" + 
        "Condition:" + this.conditionUsed + "Price: " + this.price + "\n" + "Discount: " + this.discount + "\n" +
        "Category: " + this.category + "\n" + "Shipment Plan: " + this.shipmentPlans + "\n";
    }
    
}
