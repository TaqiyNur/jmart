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
 * @version 1.0
 * @since  17 Desember 2021
 */
@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    @JsonAutowired(value = Coupon.class, filepath = "couponList.json")
    public static JsonTable<Coupon> couponTable;
    
    /**
     * mendapatkan data kupon
     * 
     * @return data kupon
     */
    @Override
    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }
    
    
    /**
     * mengecek kondisi penggunaan kupon
     * 
     * @param id	id pengguna
     * @return		true jika kupon sudah digunakan, false jika belum
     */
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
    
    /**
     * mengecek apakah kupon apakah bisa digunakan atau tidak
     * 
     * @param id		id pengguna
     * @param price		harga produk
     * @param discount	diskon produk
     * @return			true jika kupon bisa digunakan, false jika tidak
     */
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
    
    /**
     * mengembalikan data kupon pengguna
     * 
     * @param page		nomor urut halaman
     * @param pageSize	ukuran halaman yang bisa ditampilkan
     * @return			tampilan halaman yang berisi data kupon melalui method paginate yang ada di kelas algorithm
     */
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
    
    /**
     * mengembalikan data kupon sesuai id
     * 
     * @return data kupon
     */
    @Override
    public Coupon getById(int id) {
        return BasicGetController.super.getById(id);
    }
    
    /**
     * menampilkan halaman
     */
    @Override
    public List getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }
}
