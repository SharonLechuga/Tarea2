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
public class SBinaryNode {
    public String value;
    public SBinaryNode leftChild;
    public SBinaryNode rightChild;
    
    public SBinaryNode(String value){
        this.value = value;
        leftChild = null;
        rightChild = null;
        
        SBinaryNode root = new SBinaryNode("¿Es un mamifero?");
        SBinaryNode node = new SBinaryNode("Perro");
        SBinaryNode node2 = new SBinaryNode("Víbora");
        
        root.leftChild = node;
        root.rightChild = node2;
        
        SBinaryNode temp = root;
        
        while(temp.leftChild != null && temp.rightChild != null){
            System.out.print(root.value);
            if(user == 'S'){
                root = root.leftChild;
            }
            if(user == 'N'){
                root = root.rightChild;
            }
            System.out.print(root.value);
        }
    }
}
