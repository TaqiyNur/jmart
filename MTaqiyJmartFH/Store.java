package MTaqiyJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable implements FileParser
{
    public static final String REGEX_PHONE = "^([0-9]){9,12}$";
    public static final String REGEX_NAME = "^([A-Za-z]{4-20})$";
    public String name;
    public String address;
    public String phoneNumber;
    
    public Store(int accountId, String name, String address, String phoneNumber) {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Store (Account account, String name, String address, String phoneNumber) {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public boolean read(String string) {
        return false;
    }
    
    public String toString(){
        return "name: " + this.name + "\n" + "address: " + this.address + "\n" +
        "phoneNumber: " + "this.powerNumber";
    }
    
    public boolean validate() {
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(name);
        
        boolean matchFoundPhone = matcherPhone.find();
        boolean validasiPhone = matchFoundPhone ? true : false;
        boolean matchFoundName = matcherName.find();
        boolean validasiName = matchFoundPhone ? true : false;
        
        if(validasiPhone && validasiName){
            return true;
        }
        return false;
    }
}
