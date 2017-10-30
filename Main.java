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
             makeHeap(values);
             
             for(int i = values.length; i > 0; i--){
                 int lastItem = removeTopItem(values, i);
                 values[i - 1] = lastItem;                    
             }
         }
          
          public static String reverseParentheses(String inputString){  
              String result = "";
              Stack<Stack<Character>> letters = new Stack<Stack<Character>>();

              for(int i = 0; i < inputString.length(); i++){
                  char ch = inputString.charAt(i);
                  if (ch == '(' ){
                      letters.push(new Stack<Character>()); 
                  }
                  else if (ch == ')'){
                      Stack<Character> reversed = letters.pop();
                      if(letters.empty()){
                          while(!reversed.empty()){
                              result += reversed.pop();
                          }
                      }
                      else{
                          while(!reversed.empty()){
                              letters.peek().push(reversed.pop());
                          }
                      }
                  }
                  else {
                      if(!letters.empty()){
                          letters.peek().push(ch);
                      }
                      else{
                          result += ch;
                      }
                  }
              }
              return result;
          }
          
          public int factorial(int n) {
            if(n == 0){
                return 1;
            }else{
                return n * factorial(n-1);
            }
          }
          
            public int bunnyEars(int bunnies) {
             if(bunnies == 0){
               return 0;
             }else{
               return 2 * (bunnies);
             }
           }

        public int fibonacci(int n) {
          if(n <= 1){
            return n;
          }else{
            return fibonacci(n-1) + fibonacci(n-2);
          }
        }

        public int bunnyEars2(int bunnies) {
          if(bunnies == 0){
            return 0;
          }else{
            if(bunnies %2 != 0){
              return bunnyEars2(bunnies - 1) + 2;
            }else{
              return bunnyEars2(bunnies - 1) + 3;
            }
          }
        }        
          
        public int triangle(int rows) {
          if(rows == 0){
            return 0;
          }else{
            return triangle(rows - 1) + rows;
          }
        }       
        
        public int sumDigits(int n) {
          if(n == 0){
            return 0;
          }else{
            return sumDigits(n/10) + n%10;
          }
        }
        
        public int count7(int n) {
          if(n == 0){
            return 0;
          }else if(n%10 == 7){
              return count7(n/10) + 1;
            }
            else{
              return count7(n/10);
            }
        }        
        
        public int count8(int n) {
          if(n == 0){
            return 0;
          }else if(n%10 == 8){
            if(n / 10 % 10 == 8){
              return count8(n/10) + 2;
            }else{
              return count8(n/10) + 1;
            }
          }
            else{
              return count8(n/10);
            }
        }
        
        public int powerN(int base, int n) {
          if(n == 1){
            return base;
          }else{
            return base * powerN(base, n -1);
          }
        }
        
        public int countX(String str) {
          if(str.length() == 0){
            return 0;
          }else if(str.charAt(0) == 'x'){
            return 1 + countX(str.substring(1));
          }else{
            return countX(str.substring(1));
          }
        }

        public String changeXY(String str) {
          if(str.length() == 0){
            return str;
          }else if(str.charAt(0) == 'x'){
            return 'y' + changeXY(str.substring(1));
          }else{
            return str.charAt(0) + changeXY(str.substring(1));
          }
        }
        
        public boolean array6(int[] nums, int index) {
          if(index == nums.length){
            return false;
          }else if(nums[index] == 6){
            return true;
          }else{
            return array6(nums, index +1);
          }
        }

        public int array11(int[] nums, int index) {
          if(index == nums.length){
            return 0;
          }else if (nums[index] == 11){
            return array11(nums, index + 1) + 1;
          }else{
            return array11(nums, index + 1);
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
             
            System.out.println("ReverseParentheses");
            System.out.println(reverseParentheses("a(bc)de"));
            System.out.println(reverseParentheses("a(bc(de)fg)h"));

	}
}
        

