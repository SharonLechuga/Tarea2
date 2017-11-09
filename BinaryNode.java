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
public class BinaryNode {
    public int value;
    public BinaryNode leftChild;
    public BinaryNode rightChild;
    
    public BinaryNode(int value){
        this.value = value;
        leftChild = null;
        rightChild = null;
        
        BinaryNode root = new BinaryNode(4);
        BinaryNode node1 = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);
        BinaryNode node7 = new BinaryNode(7);
        BinaryNode node8 = new BinaryNode(8);
        
        root.leftChild = node2;
        root.rightChild = node5;
        root.leftChild = node1;
        root.rightChild = node3;
        root.rightChild = node7;
        root.leftChild = node6;
        root.rightChild = node8;        
    }
    
    private void preorder(BinaryNode node){
        if(node == null){
            return;
        }
        System.out.print(node.value);
        if(leftChild != null){
            
        }
        if(rightChild != null){
            
        }
    }
    
    private void inorder(BinaryNode node){
        
    }
    
    private void postorder(BinaryNode node){
        
    }
    
    public void preorderTraversal(){
        
    }
    
    public void inorderTraversal(){
        
    }
    
    public void postorderTraversal(){
        
    }
    
    public void depthFirstTraversal(){
        
    }
}
