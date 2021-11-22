package com.MTaqiyJmartFH.controller;

import com.MTaqiyJmartFH.JsonTable;
import com.MTaqiyJmartFH.Product;
import com.MTaqiyJmartFH.ProductCategory;
import com.MTaqiyJmartFH.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{
	@JsonAutowired(filepath = "jmart\\src\\main\\resources\\JsonFiles\\randomProductList.json", value = Product.class)
	public static JsonTable<Product> productTable;
	
	@Override
	public JsonTable<Product> getJsonTable() {
		return null;
	}
	
	@PostMapping("/create")
	public
	Product create(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans) {
		return null;
	}
	
	@GetMapping("/{id}/store")
	public
	Product getProductByStore(int id, int page, int pageSize) {
		return null;
	}
	
	@GetMapping("{id}/store")
	public
	Product getProductByFiltered(int page, int pageSize, int accountId, String search, int minPrice, int maxPrice, ProductCategory category) {
		return null;
	}
}
