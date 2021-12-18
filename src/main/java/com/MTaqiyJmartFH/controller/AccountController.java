package com.MTaqiyJmartFH.controller;

import com.MTaqiyJmartFH.Account;
import com.MTaqiyJmartFH.Store;
import com.MTaqiyJmartFH.dbjson.JsonAutowired;
import com.MTaqiyJmartFH.dbjson.JsonTable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

/**
 * Data kontrol untuk Akun pengguna
 * 
 * @author mtaqi
 * @version 1.0
 * @since 17 Desember 2021
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>{
    public static final String REGEX_EMAIL = "^\\w+([\\.&`~-]?\\w+)*@\\w+([\\.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{7,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @JsonAutowired(value = Account.class,filepath = "accountList.json")
    public static JsonTable<Account> accountTable;
    
    /**
     * mengambil data akun
     * 
     * @return accounTable	data akun pengguna
     */
    @Override
    public JsonTable getJsonTable() {
        return accountTable;
    }
    
    
    /**
     * mengambil data pengguna melalui id
     * 
     * @return data pengguna sesuai id
     */
    @Override
    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        return BasicGetController.super.getById(id);
    }
    
    
    /**
     * menampilkan halaman
     * 
     * @return halaman
     */
    @Override
    public List getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }
    
    /**
     * controller untuk login
     * 
     * @param email			nama email ppengguna
     * @param password		password pengguna
     * @return	data pengguna jika login berhail, null jika tidak
     */
    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }
            password = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        for (Account data : accountTable){

            if(data.email.equals(email) && data.password.equals(password)){
                return data;
            }
        }
        return null;
    }
    
    /**
     * controller untuk pendaftaran akun 
     * 
     * @param name			nama pengguna
     * @param email			nama email pengguna
     * @param password		password akun pengguna
     * @return				objek account
     */
    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {

        boolean hasilEmail = REGEX_PATTERN_EMAIL.matcher(email).find();
        boolean hasilPassword = REGEX_PATTERN_PASSWORD.matcher(password).find();
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }
            password = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        if(!name.isBlank() && hasilEmail && hasilPassword && !accountTable.stream().anyMatch(account -> account.email.equals(email))){
            Account account =  new Account(name, email, password, 0);
            accountTable.add(account);
            return account;
        }
        return null;
    }
    
    /**
     * controller untuk pendaftaran store pengguna
     * 
     * @param id			id pengguna
     * @param name			nama pengguna
     * @param address		alamat store pengguna
     * @param phoneNumber	nomor telepon pengguna
     * @return				data store
     */
    @PostMapping("/{id}/registerStore")
    Store register
            (
                    @RequestParam int id,
                    @RequestParam String name,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            )
    {
        for(Account data : accountTable){
            if (data.store == null && data.id == id){
                data.store = new Store(name,address,phoneNumber,0);
                return data.store;
            }
        }
        return null;
    }
    
    /**
     *  controller untuk top up pengisian saldo pengguna
     * 
     * @param id		id pengguna
     * @param balance	saldo pengguna
     * @return			kondisi true jika top up berhasil
     */
    @PostMapping("/{id}/topUp")
    Boolean topUp
            (
                    @RequestParam int id,
                    @RequestParam double balance
            )
    {
        for(Account data : accountTable){
            if(data.id == id) {
                data.balance += balance;
                return true;
            }
        }
        return false;
    }
}