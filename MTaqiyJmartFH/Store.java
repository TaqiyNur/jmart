package MTaqiyJmartFH;


/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Recognizable implements FileParser
{
    public String name;
    public String address;
    public String phoneNumber;
    
    public Store(int accountId, String name, String address, String phoneNumber) {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    /*public Store (Account account, String name, String address, String phoneNumber) {
        
        account = account;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }*/
    
    public boolean read(String string) {
        return false;
    }
    
    public Object write() {
        return null;
    }
    
    public Object newInstance(String string) {
        return null;
    }
}
