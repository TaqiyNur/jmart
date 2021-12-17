package com.MTaqiyJmartFH.controller;


import com.MTaqiyJmartFH.Algorithm;
import com.MTaqiyJmartFH.Coupon;
import com.MTaqiyJmartFH.dbjson.JsonAutowired;
import com.MTaqiyJmartFH.dbjson.JsonTable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Database kontrol untuk coupon
 * 
 * @author mtaqi
 *
 */
@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    @JsonAutowired(value = Coupon.class, filepath = "couponList.json")
    public static JsonTable<Coupon> couponTable;

    @Override
    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }

    @GetMapping("/{id}/isUsed")
    @ResponseBody
    boolean isUsed
            (
                    @RequestParam int id
            )
    {
        for (Coupon data : couponTable) {
            if (data.id == id) {
                return data.isUsed();
            }
        }
        return false;
    }

    @GetMapping("/{id}/canApply")
    @ResponseBody
    boolean canApply
            (
                    @RequestParam int id,
                    @RequestParam double price,
                    @RequestParam double discount
            )
    {
        for (Coupon data : couponTable) {
            if (data.id == id) {
                return data.canApply(price, discount);
            }
        }
        return false;
    }

    @GetMapping("/getAvailable")
    @ResponseBody
    List<Coupon> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(couponTable, page, pageSize, pred-> !pred.isUsed());
    }

    @Override
    public Coupon getById(int id) {
        return BasicGetController.super.getById(id);
    }

    @Override
    public List getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }
}
