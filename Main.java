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
                    for(int i =0; i < values.length; i++ ){
                        if(values[i] == target)
                            return i;
                        if(values[i] > target)
                            return -1;  
                    }
                    return -1;
		
	}
    public static int binarySearch(int values[],int target) {
        Integer min = 0;
        Integer max = values.length - 1;
                     while(min <= max){
                        Integer mid = (min + max)/2;
                         
                         if(target < values[mid])
                             max = mid - 1;
                         else if (target > values[mid])
                             min = mid +1;
                         else
                             return mid;
                    }
                    return -1;
                 }
    
   public static void Insertionsort(int values[]){
        for (int i = 1; i < values.length; ++i)
        {
            int store = values[i];
            int j = i-1;
 
            while (j >= 0 && values[j] > store)
            {
                values[j+1] = values[j];
                j = j-1;
            }
            values[j+1] = store;
        }
    }        
    
   /* public static void shiftRight(int values [], int start, int end){
		for(int j = values.length; j > start; j--){
                    values[j+1] = values[j];
                    values[j+1] = start;
                    j = j - 1;
                }
		start = end;
    } */
    
    public static void Selecttionsort(int values[]){
        int smallest;
        int swapsmallest;
        for(int i = 0; i < values.length - 1; i++){
            for(int j = 0; j < values.length; j++){
                if(values[j] < values[i]){
                    smallest = j;
                    swapsmallest = values[smallest];
                    values[smallest] = values[i];
                    values[i] = swapsmallest;
                }
            }
        }
    }   
    public static void Bubblesort(int values[]){
        boolean not_sorted = true;
        
        while(not_sorted){
            not_sorted = false;
            
            for(int i = 0; i < values.length; i++){
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
     
          public static void heapsort(int values[]){
                for(int i = 0; i < values.length; i--){
                    int temp = values[0];
                    values[0] = values[i];
                    values[i] = temp;
                    
                }
            }
          
	public static void main(String[] args) {
            System.out.println("makeHeap");
            int uArray[] = {1, 0, 24, 18, -2, 10};
             System.out.println(Arrays.toString(uArray));
             makeHeap(uArray);
             System.out.println(Arrays.toString(uArray));
             System.out.println("removeTopItem");
             System.out.println(removeTopItem(uArray, uArray.length));
             System.out.println(Arrays.toString(uArray));
             System.out.println(removeTopItem(uArray, uArray.length));
             System.out.println(Arrays.toString(uArray));
             
             System.out.println("heapsort");
            int dArray[] = {1, 0, 24, 18, -2, 10};
             System.out.println(Arrays.toString(dArray));
             heapsort(dArray);
             System.out.println(Arrays.toString(dArray));
             
             System.out.println("LinearSearch");
             int bArray[] = {2, 5, 9, 12, 18, 20};
             System.out.println(Arrays.toString(bArray));
             System.out.println(linearSearch(bArray, 20));
             
             System.out.println("BinarySearch");
             System.out.println(Arrays.toString(bArray));
             System.out.println(binarySearch(bArray, 2));
             
             System.out.println("InsertionSort");
             int nArray[] = {1, 0, 24, 18, -2, 10};
             System.out.println(Arrays.toString(nArray));
             Insertionsort(nArray);
             System.out.println(Arrays.toString(nArray));
             
             System.out.println("SelectionSort");
             int hArray[] = {1, 0, 24, 18, -2, 10};
             System.out.println(Arrays.toString(hArray));
             Insertionsort(hArray);
             System.out.println(Arrays.toString(hArray));
             
             System.out.println("BubbleSort");
             int kArray[] = {0, 1, 2, 9, 3, 6, 5, 7, 8, 4};
             System.out.println(Arrays.toString(kArray));
             Insertionsort(kArray);
             System.out.println(Arrays.toString(kArray));
	}
}
        

