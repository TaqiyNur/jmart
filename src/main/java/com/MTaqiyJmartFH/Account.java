package com.MTaqiyJmartFH;
import java.util.regex.Pattern;

import com.MTaqiyJmartFH.dbjson.Serializable;

import java.util.regex.Matcher;

/**
 * Kelas untuk mendeskripsikan Akun pengguna
 * @author mtaqi
 *
 */
public class Account extends Serializable
{
    public static final String REGEX_EMAIL =  "^\\w+([\\&_*~.]?\\w+)*@\\w+([\\.-]?\\w+)*.?\\w+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public String name;
    public String email;
    public String password;
    public Store store;
    public double balance;
    
    /**
     * Constructor untuk objek class Account
     * @param name
     * @param email
     * @param password
     * @param balance
     */
    public Account(String name, String email, String password, double balance){
        this.name  = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    
    /**
     * Method untuk memastikan email dan password sesuai ketentuan
     * @return kesesuaian email dan password dengan ketentuan
     */
    public boolean validate() {
    	Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matchFoundEmail = matcherEmail.find();
        boolean emailResult = matchFoundEmail ? true : false;
        
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();
        boolean passwordResult = matchFoundPassword ? true : false;
        
        if(emailResult && passwordResult){
            return true;
        }
        return false;
    }
}


