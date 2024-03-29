package com.MTaqiyJmartFH;
import java.util.Date;

import com.MTaqiyJmartFH.dbjson.Serializable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Kelas untuk mendeskripsikan objek tagihan pengguna
 *
 * @author mtaqi
 */
public abstract class Invoice extends Serializable 
{
	/**
	 * enumeration Rating untuk mendeskripsikan penilaian
	 *
	 */
    public static enum Rating {
        NONE, BAD, NEUTRAL, GOOD
    }
    
    /**
     * enumeration Status untuk menggambarkan status pesanan pengguna
     *
     */
    public static enum Status
    {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }
    
    public class Record {
        public Status status;
        public Date date;
        public String message;
    }
    
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    
    /**
     * constructor untuk objek pada kelas Invoice
     * @param buyerId
     * @param productId
     */
    protected Invoice(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = -1;
        SimpleDateFormat sdf = new SimpleDateFormat("E, MM/dd/yyyy");
        this.date = sdf.format(new Date());
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }
    
    public abstract double getTotalPay(Product product);
}
