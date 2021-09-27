package MTaqiyJmartFH;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice implements Transactor
{
    public int productId;
    public int productCount;
    public Shipment shipment;
    
    /*public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration) {
        super(id, buyerId);
        this.buyerId = buyerId;
        product = product;
        this.shipmentDuration= shipmentDuration;
    }
    
    public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDuration) {
        this.id = id;
        this.buyerId = buyerId;
        this.storeId = storeId;
        this.productId = productId;
        this.shipmentDuration= shipmentDuration;
    }*/
    
    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment) {
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    public double getTotalPay() {
        return 0.0;
    }
    
    public Invoice perform () {
        return null;
    }
    
    public boolean validate() {
        return false;
    }
    
    /*public Transaction perform() {
        return null;
    }*/
    
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
