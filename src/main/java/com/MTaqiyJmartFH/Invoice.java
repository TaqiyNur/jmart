package com.MTaqiyJmartFH;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Serializable 
{
    public static enum Rating {
        NONE, BAD, NEUTRAL, GOOD
    }
    
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
    public ArrayList<Record> history = new ArrayList<>();
    
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