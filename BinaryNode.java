/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice3;

import java.util.NoSuchElementException;


/**
 *
 * @author SharonLechuga
 */
public class BinaryNode  {
    public int value;
    public BinaryNode leftChild;
    public BinaryNode rightChild;
    private LinkedList<BinaryNode> queue;
    
    public BinaryNode(int value){
        this.value = value;
        leftChild = null;
        rightChild = null;
                
    }
    
    public void offer(BinaryNode e) {
        queue.addFirst(e);
    }
    
    private void preorder(BinaryNode node){
        System.out.print(node.value);
        if(node.leftChild==null){
            if(node.rightChild==null){
                return;
            } else {
                preorder(node.rightChild);
            }
        } else {
            preorder(node.leftChild);
            if(node.rightChild==null){
                return;
            } else {
                preorder(node.rightChild);
            }
        }
    }
    
    private void inorder(BinaryNode node){
        if(node.leftChild==null){
            System.out.print(node.value);
            if(node.rightChild==null){
                return;
            } else{
                inorder(node.rightChild);
            }
        } else {
            inorder(node.leftChild);
            System.out.print(node.value);
            if(node.rightChild==null){
                return;
            } else {
                inorder(node.rightChild);
            }
        }
    }
    
    private void postorder(BinaryNode node){
        if(node.leftChild==null){
            if(node.rightChild==null){
                System.out.print(node.value);
                return;
            } else{
                postorder(node.rightChild);
                System.out.print(node.value);
            }
        } else {
            postorder(node.leftChild);
            if(node.rightChild==null){
                System.out.print(node.value);
                return;
            } else{
                postorder(node.rightChild);
                System.out.print(node.value);
            }
        }
    }
    
    public void preorderTraversal(){
        preorder(this);
    }
    
    public void inorderTraversal(){
        inorder(this);
    }
    
    public void postorderTraversal(){
        postorder(this);
    }
    
    public void depthFirstTraversal(){
        Queue<BinaryNode> fila = new Queue<BinaryNode>() {
            @Override
            public Object[] toArrayy() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }};
        fila.offer(this);
        
        while(!fila.isEmpty()){
            if(fila.element().leftChild==null){
                if(fila.element().rightChild==null){
                    System.out.print(fila.remove().value);
                } else{
                    fila.offer(fila.element().rightChild);
                    System.out.print(fila.remove().value);
                }
            } else{ 
                fila.offer(fila.element().leftChild);
                if(fila.element().rightChild==null){
                    System.out.print(fila.remove().value);
                } else{
                    fila.offer(fila.element().rightChild);
                    System.out.print(fila.remove().value);
                }
            }
        }
    }
    
    public void addNode(int value){
       if(value < this.value){
           if (leftChild == null){
               leftChild = new BinaryNode(value);
           }else{
               leftChild.addNode(value);
           }
       }else if (value > this.value){
          if(rightChild == null){
               rightChild = new BinaryNode(value);
           }else{
               rightChild.addNode(value);
           } 
       }
    }
    
    public BinaryNode findNode(int target){
        if(target == value){
            return this;
        }
        
        if(target < value){
            if(leftChild == null){
                return null;
            }else{
                return leftChild.findNode(target);
            }
        }else{
            if(rightChild == null){
                return null;
            }else{
                return rightChild.findNode(target);
            }
        }
    }
    
}
