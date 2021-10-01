package MTaqiyJmartFH;


/**
 * Write a description of interface FileParser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface FileParser
{
    boolean read(String string);
    default Object  write(){return null;};
    default Object newInstance(String string){return null;};
}
