package MTaqiyJmartFH;

import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class Algorithm {
	private Algorithm() {
	}

	public static <T> List<T> collect(T[] array, T value) {
		final Iterator<T> it = Arrays.stream(array).iterator();
		return collect(it, value);
	}

	public static <T> List<T> collect(Iterable<T> iterable, T value) {
		final Iterable<T> e = (Iterable<T>) iterable.iterator();
		return collect(e, value);
	}

	public static <T> List<T> collect(Iterator<T> iterator, T value) {
		final Predicate<T> predicate = value::equals;
		return collect(iterator, value);
	}

	public static <T> List<T> collect(T[] array, Predicate<T> pred) {
		final Iterator<T> itArray = Arrays.stream(array).iterator();
		return collect(itArray, pred);
	}

	public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
		int count = 0;
		while (iterator.hasNext()) {
			count++;
		}
		final Predicate<T> predicate = pred::equals;
		return collect(iterator, pred);
	}

	public static <T> int count(T[] array, T value) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return count(counter, value);
	}

	public static <T> int count(Iterable<T> iterable, T value) {
		final Iterator<T> counter = iterable.iterator();
		return count(counter, value);
	}

	public static <T> int count(Iterator<T> iterator, T value) {
		final Predicate<T> pred = value::equals;
		return count(iterator, pred);
	}

	public static <T> int count(T[] array, Predicate<T> pred) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return count(counter, pred);
	}

	public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator<T> counter = iterable.iterator();
		return count(counter, pred);
	}

	public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
		return count(iterator, pred);
	}

	public static <T> boolean exists(T[] array, T value) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return exists(counter, value);
	}

	public static <T> boolean exists(Iterable<T> iterable, T value) {
		final Iterator<T> counter = iterable.iterator();
		return exists(counter, value);
	}

	public static <T> boolean exists(Iterator<T> iterator, T value) {
		final Predicate<T> pred = value::equals;
		return exists(iterator, pred);
	}

	public static <T> boolean exists(T[] array, Predicate<T> pred) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return exists(counter, pred);
	}

	public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator<T> counter = iterable.iterator();
		return exists(counter, pred);
	}

	public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
		return exists(iterator, pred);
	}

	public static <T> T find(T[] array, T value) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return find(counter, value);
	}

	public static <T> T find(Iterable<T> iterable, T value) {
		final Iterator<T> counter = iterable.iterator();
		return find(counter, value);
	}

	public static <T> T find(Iterator<T> iterator, T value) {
		final Predicate<T> pred = value::equals;
		return find(iterator, pred);
	}

	public static <T> T find(T[] array, Predicate<T> pred) {
		final Iterator<T> counter = Arrays.stream(array).iterator();
		return find(counter, pred);
	}

	public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
		final Iterator<T> counter = iterable.iterator();
		return find(counter, pred);
	}

	public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
		return find(iterator, pred);
	}

	public static <T> T max(T first, T second) {
		if (first.hashCode() > second.hashCode()) {
			return first;
		} else {
			return second;
		}
	}

	public static <T> T max(T[] array) {
		int max = 0;
		T maxT = null;
		for (T t : array) {
			if (t.hashCode() > max) {
				max = t.hashCode();
				maxT = t;
			}
		}
		return maxT;
	}

	public static <T> T max(Iterator<T> iterator, T value) {
		if (iterator.next().hashCode() > value.hashCode()) {
			return iterator.next();
		} else {
			return value;
		}
	}

	public static <T> T max(Iterable<T> iterable, T value) {
		if (iterable.hashCode() > value.hashCode()) {
			return (T) iterable;
		} else {
			return value;
		}
	}

	public static <T> T max(T first, T second, Comparator<? super T> comparator) {
		int res = ((Comparable<T>) first).compareTo(second);
		return res == -1 ? second : first;
	}

	public static <T> T max(T[] array, Comparator<? super T> comparator) {
		int max = 0;
		T maxT = null;
		for (T t : array) {
			if (t.hashCode() > max) {
				max = t.hashCode();
				maxT = t;
			}
		}
		int res = ((Comparable<T>) comparator).compareTo((T) array);
		return max(array, comparator);
	}

	public static <T> T max(Iterator<T> iterator, T value, Comparator<? super T> comparator) {
		int res = ((Comparable<T>) iterator).compareTo(value);
		if (iterator.next().hashCode() > value.hashCode()) {
			return iterator.next();
		} else {
			return value;
		}
	}
	
	
}