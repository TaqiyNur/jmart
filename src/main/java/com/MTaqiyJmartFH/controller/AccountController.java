package com.MTaqiyJmartFH.controller;

import com.MTaqiyJmartFH.Account;
import com.MTaqiyJmartFH.JsonTable;
import com.MTaqiyJmartFH.Store;
import com.MTaqiyJmartFH.dbjson.JsonAutowired;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>{
	public static final String REGEX_EMAIL =  "^\\w+([\\&_*~.]?\\w+)*@\\w+([\\.-]?\\w+)*.?\\w+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    
    @JsonAutowired(filepath = "C:\\Users\\mtaqi\\Documents\\Praktikum OOP\\jmart\\src", value = Account.class)
	public static JsonTable<Account> accountTable;
	
    @Override
	public JsonTable<Account> getJsonTable() {
		return null;
	}
    
	@PostMapping("/login")
	public 
	Account login(String email, String password) {
		for (Account account : getJsonTable()) {
			if (account.email.equals(email) && account.password.equals(password)) {
				return account;
			}
		}
		return null;
	}
	
	@PostMapping("/register")
	public 
	Account register(String name, String email, String password) {
		Account newAccount = new Account(name, email, password, 0.0);
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
	
	@PostMapping("/topup")
	public
	boolean topUp (int id, double balance) {
		return false;
	}
}
