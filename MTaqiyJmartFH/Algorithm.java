package MTaqiyJmartFH;
import java.util.Iterator;
import java.util.ArrayList;

public class Algorithm {
	private Algorithm() {};
	
	public static <T> int count(T[] array, T value) {
		return 0;
	}
	
	public static <T> int count(Iterable<T> iterable, T value) {
		final Iterator<T> it = iterable.iterator();
		return count(it, value);
	}
	
	public static <T> int count(Iterator<T> iterator, T value) {
		return 0;
	}
	
	public static <T> int count(T[] array, Predicate<T> pred) {
		return array.length;
	}
	
	public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
		return 0;
	}
	
	public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
		return 0;
	}
	
	public static <T> boolean exists(T[] array, T obj) {
		return false;
	}
	
	public static <T> boolean exists(Iterable<T> iterable, T obj) {
		return false;
	}
	
	public static <T> boolean exists(Iterator<T> iterator, T obj) {
		return false;
	}
	
	public static <T> boolean exists(T[] array, Predicate<T> pred) {
		return false;
	}
	
	public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
		return false;
	}
	
	public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
		return false;
	}
	
	public static <T> void max(T first, T second) {
	}
	
	public static <T> void min(T first, T second) {
	}
}
