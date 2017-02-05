import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterating over all the elements in the array without knowing the structure of
 * the array.
 * 
 * @author Kwankaew Uttama
 *
 * @param <T>
 *            is the type of element returned by this iterator.
 */
public class ArrayIterator<T> implements Iterator<T> {
	/** attribute for the array we want to iterate over */
	private T[] array;
	/** attribute for the index of element */
	private int cursor;
	/** attribute for check that can called the remove() method or not. */
	private boolean check;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.cursor = 0;
		this.check = false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (hasNext()) {
			this.cursor++;
			this.check = true;
			return this.array[this.cursor - 1];
		}
		throw new NoSuchElementException();
	}

	/**
	 * checking the iteration has more non-null elements.
	 * 
	 * @return true if the iteration has more non-null elements and false if the
	 *         iteration are no more non-null elements.
	 * 
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.cursor; i < this.array.length; i++) {
			if (this.array[i] != null) {
				this.cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * set the value of the most recent element to null if the iteration has
	 * more non-null elements.
	 * 
	 * @throws IllegalStateException
	 *             if the iteration are no more non-null elements
	 */
	public void remove() {
		if (this.check) {
			array[this.cursor - 1] = null;
			this.check = false;
		} else
			throw new IllegalStateException();
	}
}
