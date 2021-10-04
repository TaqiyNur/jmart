package MTaqiyJmartFH;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Kelas ini mendeskripsikan Akun pengguna
 *
 */
public class Account extends Recognizable implements FileParser
{
    public static final String REGEX_EMAIL =  "^\\w+([\\&_*~.]?\\w+)*@\\w+([\\.-]?\\w+)*.?\\w+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public String name;
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password){
        super(id);
        this.name  = name;
        this.email = email;
        this.password = password;
    }
    
    public boolean read(String string) {
        return false;
    }

    public String toString() {
        return "name: " + this.name + "\n" + "email: " + this.email + "\n" +
        "password: " + this.password;
    }
    
    public boolean validate() {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        
        boolean matchFoundEmail = matcherEmail.find();
        boolean validasiEmail = matchFoundEmail ? true : false;
        boolean matchFoundPassword = matcherPassword.find();
        boolean validasiPassword = matchFoundPassword ? true : false;
        
        if(validasiEmail && validasiPassword){
            return true;
        }
        return false;
        
    }
}


