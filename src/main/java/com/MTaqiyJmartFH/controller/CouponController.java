package com.MTaqiyJmartFH.controller;


import com.MTaqiyJmartFH.Algorithm;
import com.MTaqiyJmartFH.Coupon;
import com.MTaqiyJmartFH.dbjson.JsonAutowired;
import com.MTaqiyJmartFH.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon>{
    @JsonAutowired(filepath="jmart\\src\\main\\resources\\JsonFiles\\coupon.json", value= Coupon.class)
    public static JsonTable<Coupon> couponTable;

    public JsonTable<Coupon> getJsonTable(){
        return null;
    }

    @GetMapping("/{id}/isUsed")
    public boolean isUsed(int id){
        for(Coupon coupon: getJsonTable()){
            if(coupon.id == id){
                return coupon.isUsed();
            }
        }
        return false;
    }

    @GetMapping("/{id}/canApply")
    public boolean canApply(int id, double price, double discount){
        for(Coupon coupon: getJsonTable()){
            if(coupon.id == id){
                return coupon.canApply(price,discount);
            }
        }
        return  false;
    }

    public List<Coupon> getAvailable (int page, int pageSize ){
        return Algorithm.paginate(couponTable, page, pageSize,pred->pred.isUsed() == false);
    }


}
