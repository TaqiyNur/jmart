package com.MTaqiyJmartFH.controller;

import com.MTaqiyJmartFH.Algorithm;
import com.MTaqiyJmartFH.Product;
import com.MTaqiyJmartFH.ProductCategory;
import com.MTaqiyJmartFH.dbjson.JsonAutowired;
import com.MTaqiyJmartFH.dbjson.JsonTable;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{
	@JsonAutowired(filepath = "productList.json", value = Product.class)
	public static JsonTable<Product> productTable;
	
	@Override
	public JsonTable<Product> getJsonTable() {
		return productTable;
	}
	
	@PostMapping("/create")
	public
	Product create(
			@RequestParam int accountId, 
			@RequestParam String name, 
			@RequestParam int weight, 
			@RequestParam boolean conditionUsed, 
			@RequestParam double price, 
			@RequestParam double discount, 
			@RequestParam ProductCategory category, 
			@RequestParam byte shipmentPlans
			) 
	{
		return null;
	}
	
	@GetMapping("/{id}/store")
    public List<Product> getProductByStore ( 
            @RequestParam int id,
            @RequestParam int page,
            @RequestParam int pageSize){
        return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
    }
	
	@GetMapping("/getFiltered")
	Product getProductByFiltered(
			@RequestParam int page, 
			@RequestParam int pageSize, 
			@RequestParam int accountId, 
			@RequestParam String search, 
			@RequestParam int minPrice, 
			@RequestParam int maxPrice, 
			@RequestParam ProductCategory category
			) 
	{
		return null;
	}
}