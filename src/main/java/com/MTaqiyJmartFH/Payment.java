package com.MTaqiyJmartFH;

import java.util.ArrayList;
import java.util.Date;

/**
 * Menggambarkan pembayaran yang dilakukan pengguna
 * 
 * @author mtaqi
 *
 */
public class Payment extends Invoice
{
    public ArrayList<Record> history = new ArrayList<Record>();
    public int productCount;
    public Shipment shipment;
    
    /**
     * Constructor objek dari kelas Payment
     * @param buyerId
     * @param productId
     * @param productCount
     * @param shipment
     */
    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.productId = productId;
        this.shipment = shipment;
    }
    
    /**
     * Method untuk menentukan jumlah harga yang harus dibayar pengguna
     * 
     * @return jumlah harga yang harus dibayarkan pengguna
     */
    public double getTotalPay(Product product){
        return product.price * (product.discount/100) + shipment.cost;
    }

    public static class Record{
        public Status status;
        public Date date;
        public String message;

        public Record(Status status, String message){
            this.status = status;
            this.message = message;
            this.date = java.util.Calendar.getInstance().getTime();
        }
    }
}
