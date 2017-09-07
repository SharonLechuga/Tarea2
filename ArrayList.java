package practice3;

import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	private Object[] top;
	private int size;
	private int initialCapacity = 5;
	private int extraCapacity = 5;
        private Node<E> header;
        
	
	/**
	 * Creates a new ArrayList instance with the default initial capacity.
	 */
	public ArrayList() {
		top = new Object[initialCapacity];
		size = 0;
	}
	
	/**
	 * Increases the capacity of this ArrayList instance so that it 
	 * can hold at least extraCapacity elements more.
	 * This method allocates a new array with greater capacity than the
	 * current one (top.length + extraCapacity) and copies all elements
	 * from top to the newly allocated array. The reference top is then
	 * updated to point to the new array. 
	 * @param extraCapacity increase the capacity of this ArrayList by this amount
	 */
	private void reserveExtraCapacity(int extraCapacity, int initialCapacity) {
             Node<E> current = header;
            for(int i =1 ; i <= extraCapacity; i++){
                current = current.next;
                initialCapacity += i;
                this.initialCapacity = initialCapacity;
            }
            top = new Object[initialCapacity];
            top.next = current.prev;
            current.prev = top;

               
	}
        
	
	/**
	 * Increases the capacity of this list if its size equals the length of the array
	 * where the data is stored. This method calls reserveExtraCapacity when (size() >= top.length).
	 * reserveExtraCapacity is called using the instance variable extraCapacity.
	 */
	private void ensureCapacity() {
            if(size() >= top.length){
                top.reserveExtraCapacity();
            }
	}
	
	/**
	 * Shifts elements in the array (top) to the right, starting at the given position.
	 * @param index the position in which the shift will begin
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	private void shiftContentsRight (int index) {
            if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index < (size >> 1)) {
			Node<E> x = header.next;
			for(int i=0; i<index; i++)
				x = x.next;
		}
	}
	
	@Override
	public void addFirst(E e) {
            Node<E> newElement = new Node<E>(e);
		
		Node<E> firstElement = header.next;
		newElement.next = firstElement;
		firstElement.prev = newElement;
		
		newElement.prev = header;
		header.next = newElement;
		
		size++;
	}

	@Override
	public void addLast(E e) {
            Node<E> newElement = new Node<E>(e);
		
		Node<E> lastElement = header.prev;
		newElement.prev = lastElement;
		lastElement.next = newElement;
		
		newElement.next = header;
		header.prev = newElement;
		
		size++;
	}

	@Override
	public void add(int index, E element) {
            if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index == size()) {
			addLast(element);
		} else {
			Node<E> newNode = new Node<E>(element);
			
			Node<E> current = node(index);
			Node<E> previousNode = current.prev;
			newNode.prev = previousNode;
			previousNode.next = newNode;
			
			newNode.next = current;
			current.prev = newNode;
			
			size++;
		}
	}

	@Override
	public E getFirst() {
		if(header.next == header) {
			throw new NoSuchElementException();
		}
		
		return header.next.value;
	}

	
	@Override
	public E getLast() {
		if(header.next == header) {
			throw new NoSuchElementException();
		}
		
		return header.prev.value;
	}

	
	@Override
	public E get(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> nodeToReturn = node(index);
                return nodeToReturn.value;
	}

	@Override
	public E set(int index, E element) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> nodeToSet = node(index);
		E currentValue = nodeToSet.value;
		nodeToSet.value = element;
		
		return currentValue;
	}

	@Override
	public void clear() {
            header.next = header;
		header.prev = header;
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

	@Override
	public String toString() {
		if(header.next == header) {
			return "[]";
		}
		
		Node<E> current = header.next;
		String str = "[" + current.value;
		while(current.next != header) {
			current = current.next;
			str += ", " + current.value;
		}
		str += "]";
		
		return str;
	}
        private Node<E> node(int index){
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
}
}
