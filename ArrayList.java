package practice3;
/**
 *
 * @author SharonLechuga
 */
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	public Object[] top;
	private int size;
	private int initialCapacity = 5;
	private int extraCapacity = 5;
	
	public ArrayList() {
		top = new Object[initialCapacity];
		size = 0;
	}
	
	private void reserveExtraCapacity(int extraCapacity) {
		int targetCapacity = top.length + extraCapacity;
		Object[] newList = new Object[targetCapacity];
		
		for(int i = 0; i< size; i++) {
			newList[i] = top[i];
		}
		
		top = newList;
	}
	
	private void ensureCapacity() {
		if(size >= top.length) {
			reserveExtraCapacity(extraCapacity);
		}
	}
	
	private void shiftContentsRight(int index) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		ensureCapacity();
		
		for(int i=size; i > index; i--)
			top[i] = top[i - 1];
		
		top[index] = null;
	}
	
	public void addFirst(E e) {
		shiftContentsRight(0);
		
		top[0] = e;
		size++;
	}

	
	public void addLast(E e) {
		ensureCapacity();
		
		top[size] = e;
		size++;
	}

	public void add(int index, E element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		shiftContentsRight(index);
		
		top[index] = element;
		size++;
	}


	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}


	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}


	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public E getFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		@SuppressWarnings("unchecked")
		E firstElement = (E)top[0];
		
		return firstElement;
	}

	@Override
	public E getLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		@SuppressWarnings("unchecked")
		E lastElement = (E)top[size - 1];
		
		return lastElement;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		@SuppressWarnings("unchecked")
		E elementAtIndex = (E)top[index];
		
		return elementAtIndex;
	}

	@Override
	public E set(int index, E element) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		@SuppressWarnings("unchecked")
		E previousElement = (E)top[index];
		top[index] = element;
		
		return previousElement;
	}

	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		size = 0;
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		if(size <= 0) {
			return "[]";
		}
		
		String str = "[" + top[0];
		for(int i=1; i<size; i++) {
			str += ", " + top[i];
		}
		str += "]";
		
		return str;
	}

}