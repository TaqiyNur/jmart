package com.MTaqiyJmartFH.controller;

import com.MTaqiyJmartFH.*;
import com.MTaqiyJmartFH.dbjson.JsonAutowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
	public static long DELIVERED_LIMIT_MS = 100;
	public static long ON_DELIVERY_LIMIT_MS = 200;
	public static long ON_PROGRESS_LIMIT_MS = 300;
	public static long WAITING_CONF_LIMIT_MS = 400;

	@JsonAutowired(filepath = ".scr/main/java/com/test2.json", value = Payment.class)
	public static JsonTable<Payment> paymentTable;
	public static ObjectPoolThread<Payment> poolThread;

	public JsonTable<Payment> getJsonTable() {
		return paymentTable;
	}

	private static boolean timekeeper(Payment payment) {
		new ObjectPoolThread<Payment>("Payment-Thread", PaymentController::timekeeper);
		poolThread.start();
		long startTime = System.currentTimeMillis();

		Payment.Record record = payment.history.get(payment.history.size() - 1);
		long time_elapsed = System.currentTimeMillis() - startTime;
		if (record.status == Invoice.Status.WAITING_CONFIRMATION && time_elapsed > WAITING_CONF_LIMIT_MS) {
			payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Gagal"));
		} else if (record.status == Invoice.Status.ON_PROGRESS && time_elapsed > ON_PROGRESS_LIMIT_MS) {
			payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Gagal"));
		} else if (record.status == Invoice.Status.ON_DELIVERY && time_elapsed > ON_DELIVERY_LIMIT_MS) {
			payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "Berhasil"));
		} else if (record.status == Invoice.Status.FINISHED && time_elapsed > DELIVERED_LIMIT_MS) {
			payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "Berhasil"));
		}

		if (record.status == Invoice.Status.FAILED && record.status == Invoice.Status.FINISHED) {
			return true;
		}

		return false;
	}

	@PostMapping("/{id}/accept")
	public boolean accept(@RequestParam int id) {

		for (Payment pay : getJsonTable()) {
			if (pay.id == id) {
				Payment.Record rec = pay.history.get(pay.history.size() - 1);
				if (rec.status.equals(Invoice.Status.WAITING_CONFIRMATION)) {
					pay.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "Sedang progress"));
					return true;
				}
			}
		}
		return false;
	}

	@PostMapping("/{id}/cancel")
	public boolean cancel(@RequestParam int id) {
		for (Payment pay : getJsonTable()) {
			if (pay.id == id) {
				Payment.Record rec = pay.history.get(pay.history.size() - 1);
				if (rec.status.equals(Invoice.Status.WAITING_CONFIRMATION)) {
					pay.history.add(new Payment.Record(Invoice.Status.CANCELLED, "di cancel"));
					return true;
				}
			}
		}
		return false;
	}

	@PostMapping("/create")
	public Payment create(@RequestParam int buyerId, @RequestParam int productId, @RequestParam int productCount,
			@RequestParam String shipmentAddress, @RequestParam byte shipmentPlan) {
		JsonTable<Account> account = AccountController.accountTable;
		JsonTable<Product> product = ProductController.productTable;
		for (Account acc : account) {
			if (acc.id == buyerId) {
				for (Product pro : product) {
					if (pro.id == productId) {
						for (Payment pay : getJsonTable()) {
							if (acc.balance >= pay.getTotalPay(pro)) {
								Shipment ship = new Shipment(shipmentAddress, 0, shipmentPlan, null);
								pay.shipment = ship;
								pay.productCount = productCount;
								acc.balance -= pay.getTotalPay(pro);
								pay.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "Menunggu"));
								paymentTable.add(pay);
								timekeeper(pay);
								return pay;
							}
						}
					}

				}
			}

		}
		return null;
	}

	@PostMapping("/{id}/submit")
	public boolean submit(@RequestParam int id, @RequestParam String receipt) {
		for (Payment pay : getJsonTable()) {
			if (pay.id == id && !receipt.isBlank()) {
				Payment.Record rec = pay.history.get(pay.history.size() - 1);
				if (rec.status.equals(Invoice.Status.ON_PROGRESS)) {
					pay.shipment.receipt = receipt;
					pay.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "dikirim"));
					return true;
				}
			}
		}
		return false;
	}
}
