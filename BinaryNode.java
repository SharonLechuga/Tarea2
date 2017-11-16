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
        Queue<binaryNode> fila = new Queue<binaryNode>() {};
        fila.offer(this);
        
        while(!fila.isEmpty()){
            if(fila.element().leftChild==null){
                if(fila.element().rightchild==null){
                    System.out.print(fila.remove().value);
                } else{
                    fila.offer(fila.element().rightchild);
                    System.out.print(fila.remove().value);
                }
            } else{ 
                fila.offer(fila.element().leftChild);
                if(fila.element().rightchild==null){
                    System.out.print(fila.remove().value);
                } else{
                    fila.offer(fila.element().rightchild);
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
