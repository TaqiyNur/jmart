package com.MTaqiyJmartFH;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.MTaqiyJmartFH.dbjson.Serializable;

public class Complaint extends Serializable
{
   public Date date;
   public String desc;
   
   public Complaint(String desc) {
       this.desc = desc;
   }
   
   public String toString(){
        SimpleDateFormat SDformat = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = SDformat.format(this.date);
        return "{date = " + formatDate + "desc = '" + this.desc + "'}"; 
    }
}
