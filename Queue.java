/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice3;

import java.util.NoSuchElementException;

public abstract class Queue<E> implements IQueue<E> {

    private LinkedList<E> queue;

    public Queue() {
        queue = new LinkedList<E>();
    }

    @Override
    public void offer(E e) {
        queue.addFirst(e);
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeLast();
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getLast();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public int size() {
        return queue.size();
    }

    public Object[] toArray() {
        return queue.toArray();
    }
}
