package MTaqiyJmartFH;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable implements FileParser
{
    public static final String REGEX_PHONE = "0";
    public static final String REGEX_NAME = "A";
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
        if(String.valueOf(REGEX_NAME).length() >= 9 && 
        String.valueOf(REGEX_NAME).length() <= 12 && 
        String.valueOf(REGEX_PHONE).length() >= 4 &&
        String.valueOf(REGEX_PHONE).length() <= 20) {
            return true;
        }
        return false;
    }
}
