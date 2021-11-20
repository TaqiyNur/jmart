package com.MTaqiyJmartFH.controller;

import com.MTaqiyJmartFH.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
	
	@Override
	public JsonTable<Payment> getJsonTable() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostMapping("/create")
	public
	Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan) {
		return null;
	}
	
	@PostMapping("{id}/accept")
	public
	boolean accept (int id) {
		return false;
	}
	
	@PostMapping("{id}/cancel")
	public
	boolean cancel(int id) {
		return false;
	}
	
	@PostMapping("{id}/submit")
	public
	boolean submit(int id) {
		return false;
	}
	
}
