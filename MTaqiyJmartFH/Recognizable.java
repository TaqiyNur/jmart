package MTaqiyJmartFH;


/**
 *
 * @author  Muhammad Taqiy Nur Furqon
 * @NPM     2006468900
 */
public abstract class Recognizable
{
    // instance variables - replace the example below with your own
    public int id;

    protected Recognizable(int id) {
        this.id = id;
    }
    
    public boolean equals(Object object) {
        return (object != null) && (object instanceof Recognizable) && (this.id == ((Recognizable) object).id);
    }
    
    public boolean equals(Recognizable recognizable) {
        if(id == recognizable.id) {
            return true;
        }
        else
            return false;
    }
}
