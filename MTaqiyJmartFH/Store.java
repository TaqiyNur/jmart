package MTaqiyJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store
{
    public static final String REGEX_PHONE = "^([0-9]){9,12}$";
    public static final String REGEX_NAME = "^([A-Za-z]{4-20})$";
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;
    
    public Store(String name, String address, String phoneNumber, double balance) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    
    public String toString(){
        return "name: " + this.name + "\n" + "address: " + this.address + "\n" +
        "phoneNumber: " + "this.powerNumber";
    }
    
    public boolean validate() {
    	Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(name);
        boolean matchFoundName = matcherName.find();
        boolean nameResult = matchFoundName ? true : false;
        
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        boolean matchFoundPhone = matcherPhone.find();
        boolean phoneResult = matchFoundPhone ? true : false;
        
        if(nameResult && phoneResult){
            return true;
        }
        return false;
    }
}
