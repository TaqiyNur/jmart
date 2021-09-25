package MTaqiyJmartFH;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment
{
    public int productId;
    public ShipmentDuration shipmentDuration;
    
    /*public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration) {
        id = id;
        this.buyerId = buyerId;
        product = product;
        this.shipmentDuration= shipmentDuration;
    }
    
    /*public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDuration) {
        this.id = id;
        this.buyerId = buyerId;
        this.storeId = storeId;
        this.productId = productId;
        this.shipmentDuration= shipmentDuration;
    }*/
    
    public boolean validate() {
        return false;
    }
    
    public Transaction perform() {
        return null;
    }
    
    public boolean read(String string) {
        return false;
    }
    
    public Object write() {
        return null;
    }
    
    public Object newInstance(String string) {
        return null;
    }
}
