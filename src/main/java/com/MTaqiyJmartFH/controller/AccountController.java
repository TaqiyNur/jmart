package com.MTaqiyJmartFH.controller;

import com.MTaqiyJmartFH.Account;
import com.MTaqiyJmartFH.JsonTable;
import com.MTaqiyJmartFH.Store;
import com.MTaqiyJmartFH.dbjson.JsonAutowired;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>{
	public static final String REGEX_EMAIL =  "^\\w+([\\&_*~.]?\\w+)*@\\w+([\\.-]?\\w+)*.?\\w+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    
    @JsonAutowired(filepath = "jmart\\src\\main\\resources\\JsonFiles\\account.json", value = Account.class)
	public static JsonTable<Account> accountTable;
	
    @Override
	public JsonTable<Account> getJsonTable() {
		return null;
	}
    
	@PostMapping("/login")
	public 
	Account login(String email, String password) {
		String generatedPassword = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(password.getBytes());

			byte[] bytes = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			generatedPassword = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Account account : getJsonTable()) {
			if (account.email.equals(email) && account.password.equals(generatedPassword)) {
				return account;
			}
		}
		return null;
	}
	
	@PostMapping("/register")
	public Account register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {

		String generatedPassword = null;

		Account newAccount = new Account(name, email, generatedPassword, 0.0);
		if ((!name.isBlank())) {
			if (REGEX_PATTERN_EMAIL.matcher(email).matches() && REGEX_PATTERN_PASSWORD.matcher(password).matches()) {
				for (Account account : getJsonTable()) {
					if (account.email.equals(email)) {
						break;
					}
					accountTable.add(account);
					return newAccount;

				}
			}
		}
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(password.getBytes());

			byte[] bytes = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			generatedPassword = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@PostMapping("/store")
	public
	Store registerStore(int id, String name, String address, String phoneNumber) {
		
		for(Account acc : getJsonTable()) {
			if(acc.id == id && acc.store == null) {
				Store store = new Store(name, address, phoneNumber, 0.0);
				acc.store = store;
				return store;
			}
		}
		return null;
		
		
	}
	
	@PostMapping("/{id}/topUp")
	boolean topUp(@RequestParam int id, @RequestParam double balance) {
		for (Account each : accountTable) {
			if (each.id == id) {
				each.balance += balance;
				return true;
			}
		}
		return false;
	}
}
