package MTaqiyJmartFH;


/**
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     2006468900
 */
public class Recognizable implements Comparable<Recognizable>
{
    // instance variables - replace the example below with your own
    public final int id;

    protected Recognizable() {
        this.id = 1;
    }
    
    public boolean equals(Object object) {
        return (object != null) && (object instanceof Recognizable) && (this.id == ((Recognizable) object).id);
    }
    
    public boolean equals(Recognizable recognizable){
        if(this.id == recognizable.id) {
            return true;
        }
        
        return false;
    }
    
    public static int setClosingId(Class<Recognizable> clazz, int id) {
    	if (Class.class.isAssignableFrom(Recognizable.class)) {
    		return 0;
    	}
    	return 1;
    }
    
    public static int getClosingId (Class<Recognizable> clazz) {
    	if (Class.class.isAssignableFrom(Recognizable.class)) {
    		 return 0;
    	}
    	return 1;
    }
    
    public int compareTo(Recognizable recognizable) {
    	return Integer.compare(this.id, recognizable.id);
    }
}
