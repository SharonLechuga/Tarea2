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
public class SNode<T> {
	public T value;
	public SNode<T> next;
	
	public SNode()
	{
		value = null;
		next = null;
	}
	
	public SNode(T value)
	{
		this.value = value;
		next = null;
	}
}