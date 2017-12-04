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
public class IntegerNode {
	public int value;
	public IntegerNode next;
	
	public IntegerNode() {
		value = 0;
		next = null;
	}
	
	public IntegerNode(int value) {
		this.value = value;
		next = null;
	}
}
