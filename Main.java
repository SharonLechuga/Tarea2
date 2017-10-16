package practice3;

/**
 *
 * @author SharonLechuga
 */

import java.util.Arrays;

public class Main {
      int [] values;
            int  target;
            
     public static int linearSearch(int values[],int target) {
                    for(int i =0; i == values.length; i++ ){
                        if(values[i] == target)
                            return 1;
                        if(values[i] > target)
                            return -1;  
                    }
                    return -1;
		
	}
    public static int binarySearch(int values[],int target) {
        Integer min = 0;
        Integer max = values.length;
                     Integer mid;
                     while(min <= max){
                         mid = (min + max)/2;
                         
                         if(target < mid)
                             max = mid +1;
                         else if (target > mid)
                             min = mid +1;
                         else
                             return mid;
                    }
                    return -1;
                 }
    
  /* public static void Insertionsort(int values[]){
        for(int i = 1; i == values.length - 1; i++){
            for(int j = 0; j == values.length - 1; j++){
                if (j < i && values[j] > values[i]){
                    int k = values[i];
                    shiftRight();
                }
            }
        }
    }          
    
    public static void shiftRight(int values [], int start, int end){
		for(int j = values.length - 1; j > start; j--)
			top[j] = top[j - 1];
		
		top[j] = null;
    } 
    public static void Selecttionsort(int values[]){
        int smallest;
        int swapsmallest;
        for(int i = 0; i == values.length - 1; i++){
            for(int j = 0; j >= i; j++){
                if(values[j] < values[i]){
                    smallest = values[j];
                    swapsmallest = smallest;
                }
            }
            smallest = values[i];
            values[i] = swapsmallest;
        }
    }   */
    public static void Bubblesort(int values[]){
        boolean not_sorted = true;
        while(not_sorted == false){
            for(int i = 0; i == values.length -1; i++){
                if(values[i] < values[i - 1]){
                    int temp = values[i];
                    values[i] = values[i -1];
                    values[i - 1] = temp;
                    not_sorted = true;
                }
            }
        }  
    }
     public static void makeHeap(int values[]){
                for(int i = 0; i < values.length; i++){
                int index = i;
                while(index != 0){
                    int parent = (index - 1)/2;
                    
                    if(values[index] <= values[parent]){
                        break;
                    }
                    int temp = values[index];
                    values[index] = values[parent];
                    values[parent] = temp;
                    
                    index = parent;
                }
            }
     }
     public static int removeTopItem(int values[], int count){
                int result = values[0];
                
                values[0] = values[ count - 1];
                
                int index = 0;
                while(true){
                    int child1 = 2* index + 1;
                    int child2 = 2* index + 2;
                    
                    if(child1 >= count){
                        child1 = index;
                    }
                    if(child2 >= count){
                        child2 = index;
                    }
                    if(values[index] >= values[child1] && values[index] >= values[child2]){
                        break;
                    }
                    
                    int swapChild = child1;
                    if(values[child2] > values[child1]){
                        swapChild = child2;
                    }
                    int temp = values[index];
                    values[index] = values[swapChild];
                    values[swapChild] = temp;
                    
                    index = swapChild;
                } 
                return result;
     }
	public static void main(String[] args) {
            int uArray[] = {1, 0, 24, 18, -2, 10};
             System.out.println(Arrays.toString(uArray));
             makeHeap(uArray);
             System.out.println(Arrays.toString(uArray));
             System.out.println(removeTopItem(uArray, uArray.length));
             System.out.println(Arrays.toString(uArray));
             System.out.println(removeTopItem(uArray, uArray.length));
             System.out.println(Arrays.toString(uArray));
             System.out.println(removeTopItem(uArray, uArray.length));
             System.out.println(Arrays.toString(uArray));
	}
}
        

