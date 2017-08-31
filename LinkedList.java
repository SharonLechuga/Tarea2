package practice3;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
	private Node<E> header;
	private int size;
	
	public LinkedList() {
		header = new Node<E>();
		size = 0;
	}
	
	/**
	 * Gets the node at the specified index.
	 * @param index the index of the node to get
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    private Node<E> node(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        
        if (index < (size >> 1)){
            //siginifica que el elemento esta en la primera mitad de la lista
            //recrorrer la lista de inicio hacia delante
            Node<E> x = header.next;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        }else{
            //signiofica que el elemento esta en la segunda mitad
            //recrorrer la lista del final hacia atras
            Node<E> x = header.prev;
            for (int i = size; i > index; i--)
                x = x.prev;
            return x;
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
        Node<E> newElement = new Node<E> (e);
        Node<E> lastElement = header.prev;
        
        newElement.prev = lastElement;
        lastElement.next = newElement;
        
        newElement.next = header;
        header.prev = newElement;
        size--;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if ( index == size){
            addLast(element);
        }else{
            Node<E> newNode = new Node<E>(element);
            Node<E> x = header;
            if (index < (size >> 1)){
                for (int i = 0; i< index; i++){
                    x = x.next;    
                }
                x.next.prev = newNode;
                newNode.next = x.next;
                newNode.prev = x;
                x.next = newNode;  
                size++;
            }
            else{
                for (int i = size; i> index; i--){
                    x = x.prev;    
                }
                x.prev.next = newNode;
                newNode.prev = x.prev;
                newNode.next = x;
                x.prev = newNode;  
                size++;
            
            }
        }
                
        
    }

    @Override
    public E removeFirst() {
        if(header.next == header ){
            throw new NoSuchElementException();  
        }
        Node<E> nodeToRemove = header.next;
        nodeToRemove.next.prev = header;
        header.next = nodeToRemove.next;
        nodeToRemove.next = null;
        nodeToRemove.prev = null;
        size--;
        return nodeToRemove.value;
    }
       

    @Override
    public E removeLast() {
        if(header.prev == header ){
            throw new NoSuchElementException();  
        }
        Node<E> nodeToRemove = header.prev;
        nodeToRemove.prev.next = header;
        header.prev = nodeToRemove.prev;
        nodeToRemove.next = null;
        nodeToRemove.prev = null;
        size--;
        return nodeToRemove.value;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> nodeToRemove = header;
        Node<E> x = header;
        if ( index == size){
            removeLast();
        }else{
            
            if (index < (size >> 1)){
                for (int i = 0; i< index; i++){
                    x = x.next;    
                }
                nodeToRemove = x.next;
                x.next.next.prev = x;
                x.next = x.next.next;
                nodeToRemove.next = null;
                nodeToRemove.prev = null;
                size--;
                return nodeToRemove.value;
            }
            else{
                for (int i = size; i> index; i--){
                    x = x.prev;    
                }
                nodeToRemove = x.prev;
                x.prev.prev.next = x;
                x.prev = x.prev.prev;
                nodeToRemove.next = null;
                nodeToRemove.prev = null;
                size--;
            }  
        }
        return nodeToRemove.value;
    }

    @Override
    public boolean remove(Object o) {
            Node <E> x = header;
            Node <E> nodeToRemove = header;
            for (int i = 0; i<= size; i++){
                
                if (o.equals(x.next.value)){
                    nodeToRemove = x.next;
                    x.next.next.prev = x;
                    x.next = x.next.next;
                    nodeToRemove.next = null;
                    nodeToRemove.prev = null;
                    size--;
                    return true;
                } 
                x = x.next;
            }
            return false;
    }

    @Override
    public E getFirst() {
        if (header.next == header){
            throw new NoSuchElementException();
        }
        return header.next.value;
    }

    @Override
    public E getLast() {
        if (header.prev == header){
            throw new NoSuchElementException();
        }
        return header.prev.value;
    }

    @Override
    public E get(int index) {
        return node(index).value;
    }

    @Override
    public E set(int index, E element) {
        Node<E> nodeToReturn = node(index);
        node(index).value = element;
        
        return nodeToReturn.value;
        
    }

    @Override
    public boolean contains(E e) {
        if(header.next == header ){
            throw new NoSuchElementException();  
        }
            Node <E> x = header;
            for (int i = 0; i<= size; i++){
                if (e.equals(x.next.value)){
                    return true;
                } 
                x = x.next;
            }
            return false;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if(o == null){
            for (Node<E> x = header.next; x != null; x = x.next){
                if (x.value == null)
                    return index;
                index++;
            }
        }
        else {
            for (Node<E> x = header.next; x != null; x = x.next){
                if (o.equals(x.value))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        header.next = header;
        header.prev = header;
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
    public Object[] toArray() {
        
		// TODO Auto-generated method stub
                this.arregloDeLista = new Object [this.size];
                Node<E> x = header.next;
                for (int i = 0; i<= size; i++ , x=x.next ){
                    this.arregloDeLista[i] = x.value;
                }
		return arregloDeLista;
	}
            
}