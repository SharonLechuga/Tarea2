/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice3;

/**
 *
 * @author SharonLechuga
 */

public interface IQueue<E> {
 /**
 * Inserta el elemento especificado a esta fila
 * 
 * @param e el elemento a añadir
 */
    public void offer(E e);
/**
 *Regresar el valor y quita el primer elemento de la fila
     * @return 
 * @Regresa una excepción si la fila esta vacía regresa el primer elemento de la fila y arroja 
 * @throws NoSuchElementException
 */    
    public E remove();
 /**
 * Obtiene pero no remueve el primer elemnto formado en esta fila
 * @Regresa una excepción si la fila esta vacía regresa el primer elemento de la fila y arroja 
 * @throws NoSuchElementException
 */     
    public E element();
    
    public boolean isEmpty();
    
    public void clear();
    
    public int size();
    
    public Object[] toArrayy();
}
