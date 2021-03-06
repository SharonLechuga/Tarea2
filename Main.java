package practice3;

/**
 *
 * @author SharonLechuga
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

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
        
        public static void Quicksort(int values [], int start, int end){
            // If the list has no more than one element, it’s sorted.
            if(start >= end){
                return;
            }
            // Use the first item as the dividing item.
            int divider = values[start];
            // Move items < divider to the front of the array and
            // items >= divider to the end of the array.
            Stack<Integer> before = new Stack<Integer>();
            Stack<Integer> after = new Stack<Integer>();
            
            for(int i = start + 1; i <= end; i++){
                if(values[i] < divider){
                    before.push(values[i]);
                }else{
                    after.push(values[i]);
                }
            }
            
            int i = start;
            while(!before.empty()){
                values[i ++] = before.pop();
            }
            int middle = i++;
            values[middle] = divider;
            while(!after.empty()){
                values[i ++] = after.pop();
            }
            // Recursively sort the two halves
            Quicksort(values, start, middle - 1);
            Quicksort(values, middle + 1, end);
        }
        
        public static void Mergesort(int values [], int scratch [], int start, int end){
            if(start >= end){
                return;
            }
            int midpoint = (start + end)/2;
            
            // Recursively sort the two halves
            Mergesort(values, scratch, start, midpoint);
            Mergesort(values, scratch, midpoint + 1, end);
            
            int leftIndex = start;
            int rightIndex = midpoint + 1;
            int scratchIndex = leftIndex;
            
            while(leftIndex <= midpoint && rightIndex <= end){
                if(values[leftIndex] <= values[rightIndex]){
                    scratch[scratchIndex] = values[leftIndex];
                    leftIndex = leftIndex +1;
                }else{
                    scratch[scratchIndex] = values[rightIndex];
                    rightIndex = rightIndex +1;
                }
                
                scratchIndex = scratchIndex +1;
            } 
            for(int i = leftIndex; i <= midpoint; i++){
                scratch[scratchIndex] = values[i];
                scratchIndex = scratchIndex +1;
            }
            for(int i = rightIndex; i <= end; i++){
                scratch[scratchIndex] = values[i]; 
                scratchIndex = scratchIndex +1;
            }
            
            for(int i = start; i <= end; i++){
                values[i] = scratch[i];
            }
        }
        // Recursive function to return gcd of a and b
        public static int GCD(int a, int b){
        // Everything divides 0 
        if (a == 0 || b == 0)
           return 0;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return GCD(a-b, b);
        return GCD(a, b-a);
        }
    
    /* Function to calculate x raised to the power y */
        public static int pow(int x, int y){
            if (y == 0){
                return 1;
            }
            else if (y%2 == 0){
                return pow(x, y/2)*pow(x, y/2);
            }
            else{
                return x*pow(x, y/2)*pow(x, y/2);
            }
        }
        public static int gdc(int m, int n){
         int b;
         if (m == n){
             return m;
         }
        else if (m > n){
             b = m - n;
            return gdc(b,n);
         }
         else {
            b = n - m;
            return gdc(m,b);    
         }
     }
     
     public static int pow2(int base, int exponent){
         if (exponent == 0){
             return 1;
         }else{
             return base *pow(base, (exponent-1));
         }
     }
     
     public static int consecutiveAddition(int start, int end){
         if( start > end){
             return 0;
         }
         return start + consecutiveAddition((start + 1), end);
     }
     
        public static String allStar(String str){
          if(str.length() == 0){
            return str;
          }else{
            return  str.charAt(0) + '*' +  allStar(str.substring(1));
          }
        }
        
        public static String endx(String str){
            if (str.length()== 0){
            return str;
            }else if (str.charAt(0) == 'x'){
                return endx(str.substring(1)) + 'x';
            }else{
                return str.charAt(0) + endx(str.substring(1));
            }
        }
        
        public static int shapeArea(int n){
        if ( n == 1){
            return 1;
        }
       return 4*(n-1)+shapeArea(n-1); 
    }  
        
        public static void superSort(String[] arr) {
		if (arr.length == 0)
			return; // empty check

		// Determine max length
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			// update max length
			if (max < arr[i].length())
				max = arr[i].length();
		}

		// Initialize buckets
		int bucketCount = 10; // numbers
		// buckets in maps
		HashMap<Character, Vector<String>> buckets = new HashMap<Character, Vector<String>>(bucketCount);
		// create the buckets
		char a = '0';
		for (int i = 0; i <= bucketCount; i++, a++) {
			buckets.put(a, new Vector<String>());
		}

		// assign array values into buckets
		for (int i = 0; i < arr.length; i++) {
			// get first letter of word
			String current = arr[i];
			char letter = current.charAt(0);
			buckets.get(letter).add(arr[i]);
		}

		// Sort buckets and place back into input array
		int index = 0; // keeps global array index
		for (char key = '0'; key <= '9'; key++) {
			// retrieve the bucker
			Vector<String> bucket = buckets.get(key);

			// do an insertion sort on bucket
			for (int i = 1; i < bucket.size(); i++) {
				// i starts as 1, as a list of size 1 is already sorted

				// save the value at the index and remove it
				String temp = bucket.get(i);
				bucket.remove(i);

				// move all values one up, until we find the saved value's location
				int j;
				for (j = i - 1; j >= 0 && bucket.get(j).compareToIgnoreCase(temp) > 0; j--) {
					// to "insert", we need to add and remove
					bucket.add(j + 1, bucket.get(j));
					bucket.remove(j);
				}
				// place the saved value in the proper location
				bucket.add(j + 1, temp);
			}

			// pile the current bucket back into array
			for (int j = 0; j < bucket.size(); j++) {
				arr[index++] = bucket.get(j);
			}

		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "," + " ");
			
		}

	}
        
       public static LinkedList<Integer> union(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList<Integer> union = new LinkedList<Integer> ();
            while(!list1.isEmpty()){
                union.addLast(list1.removeFirst());
            }
            while(!list2.isEmpty()){
                union.addLast(list2.removeFirst());
            }
        return union;
    }
       
    public static void moveToBeginning(LinkedList<Integer> lst, int i){
        if (i < 0 || i >= lst.size()){
            throw new IndexOutOfBoundsException();
       }
        lst.addFirst(lst.remove(i));
    }
       
    public static String cleanString(String str){
        String nuevo = str.replaceAll("[^a-zA-Z]", "");
        return nuevo.toUpperCase();
    }
    
    public static int mystery(int m, int n){
        if(m == 0){
            return n + 1;
          }else if(m > 0 && n == 0){
              return mystery(m - 1, 1);
            }else if(m > 0 && n > 0){
              return mystery(m - 1, mystery(m, n-1));
            }else{
                return mystery(m , n);
            }
    }
    
    public static void moveToTop(Stack<Integer> stack, int i){
        Stack<Integer> temp = new Stack<Integer>();
        while(stack.peek() != i){
            int quitar = stack.peek();
            stack.pop();
            temp.push(quitar);
        }stack.pop();
        while(!temp.empty()){
            int value = temp.peek();
            temp.pop();
            stack.push(value);
        }
        stack.push(i);
    }
	public static void main(String[] args) {
            
            /*System.out.println("Testing train ordering");
 		Stack<Integer> train = new Stack<Integer>();
 		train.push(2);
 		train.push(3);
 		train.push(1);
 		train.push(2);
 		train.push(3);
 		
 		System.out.println("Train as it arrived to the station: " + Arrays.toString(train.toArray()));
                
 		Stack<Integer> tOne = new Stack<Integer>();
 		Stack<Integer> tTwo = new Stack<Integer>();
 		Stack<Integer> tThree = new Stack<Integer>();
                
                train.pop();
                train.pop();
                train.pop();
                train.pop();
                train.pop();
                
                tOne.push(2);
                tTwo.push(3);
                tThree.push(1);
                tOne.push(2);
                tThree.pop();
                train.push(1);
                tOne.pop();
                train.push(2);
                tOne.pop();
                train.push(2);
                tTwo.pop();
                train.push(3);
                train.push(3);

                System.out.println("Train ordered by priority: " + Arrays.toString(train.toArray()));
 		System.out.println();
                
 		Stack<Integer> towerOne = new Stack<Integer>();
 		Stack<Integer> towerTwo = new Stack<Integer>();
 		Stack<Integer> towerThree = new Stack<Integer>();
                
                towerOne.push(3);
                towerOne.push(2);
                towerOne.push(1);
                
 		System.out.println("At the beginning");
 		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
 		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
 		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
 		
 		towerOne.pop();
 		towerTwo.push(1);
                towerOne.pop();
 		towerThree.push(2);
                towerTwo.pop();
                towerThree.push(1);
                towerOne.pop();
                towerTwo.push(3);
                towerThree.pop();
                towerOne.push(1);
                towerThree.pop();
                towerTwo.push(2);
                towerOne.pop();
                towerTwo.push(1);
                 
 		System.out.println("At the end");
 		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
 		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
 		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
 		System.out.println();*/
            
              System.out.println("** TEST SINGLY-LINKEDLIST CLASS **");
		System.out.println("\t** USING INTEGERS **");
		SLinkedList<Integer> iList = new SLinkedList<Integer>();
		
		System.out.println("Testing: addFirst(i | i >= 0 && i < 10) + toString");
		System.out.println(iList);
		for(int i = 0; i < 10; i++) {
			iList.addFirst(i);
			System.out.println(iList);
		}
		/*LinkedList<Character> chList = new LinkedList<Character>(),
                newList = new LinkedList<Character>();
                chList.addFirst('A');
                chList.addFirst('V');
                chList.addFirst('A');
                chList.addFirst('J');
                System.out.println(chList);
                while (chList.size() !=0) {
                newList.addFirst(chList.getFirst());
                newList.addLast(chList.getFirst());
                chList.removeFirst();
                System.out.println(newList);
                }*/
                SLinkedList<Character> chList = new SLinkedList<Character>(),
                newList = new SLinkedList<Character>();
                chList.addFirst('A');
                chList.addFirst('V');
                chList.addFirst('A');
                chList.addFirst('J');
                System.out.println(chList);
                while (chList.size() !=0) {
                newList.addFirst(chList.getFirst());
                newList.addLast(chList.getFirst());
                chList.removeFirst();
                System.out.println(newList);
                }
                System.out.println(newList.countValue('A'));
                LinkedList<Character> rList = new LinkedList<Character>();
                rList.addFirst('A');
                rList.addFirst('V');
                rList.addFirst('A');
                rList.addFirst('J');
                rList.reverseOrder(0, 3);
                rList.reverseOrder1(0, 3);
                System.out.println(rList);
                
                System.out.println("Testing: superSort");
                String [] ar = {"123","398","210","019","528","003","513","129","220","294"};
                superSort(ar);
                System.out.Println(Arrays.toString(ar.toArray()));
                
                System.out.println("Testing: cleanString");
                System.out.println(cleanString("YOLO234567$&!"));
                System.out.println(cleanString("a#b$c"));
                System.out.println(cleanString("a&b"));
                
                System.out.println("Testing: mystery");
                System.out.println(mystery(0,0));
                System.out.println(mystery(3,4));
                System.out.println(mystery(1,3));
                System.out.println(mystery(2,2));
               
                System.out.println("Testing: moveToTop");
                Stack<Integer> prueba = new Stack<Integer>();
                prueba.push(9);
                prueba.push(8);
                prueba.push(7);
                prueba.push(5);
                prueba.push(3);
                moveToTop(prueba,8);
                System.out.println(Arrays.toString(prueba.toArray()));
                
                System.out.println("Testing Union");
                LinkedList<Integer> a = new LinkedList<Integer>();
                a.addFirst(5);
                a.addFirst(4);
                a.addFirst(3);
                a.addFirst(2);
                a.addFirst(1);
                a.addFirst(0);
                LinkedList<Integer> b = new LinkedList<Integer>();
                b.addFirst(8);
                b.addFirst(7);
                b.addFirst(6);
                b.addFirst(5);
                System.out.println("Resultado"+union(a,b));
                
                System.out.println("Testing moveToBeginning: ");
                LinkedList<Integer> ind = new LinkedList<Integer>();
                ind.addFirst(5);
                ind.addFirst(4);
                ind.addFirst(3);
                ind.addFirst(2);
                ind.addFirst(1);
                moveToBeginning(ind,2);
                System.out.println("Resultado" + ind);

                
                /*
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
            
            System.out.println("Quicksort");
            int sArray[] = {10, 4, 1, 240, 1024, 23, 21, 3048, 0, 8000, 1000, 3, 14, 16, 4, 9, 15};
            System.out.println("Before: " + Arrays.toString(sArray));
            Quicksort(sArray, 0, sArray.length - 1);
            System.out.println("Quicksort: " + Arrays.toString(sArray));
            
            System.out.println("Mergesort");
            int[] mArray = {10, 4, 1, 240, 1024, 23, 21, 3048, 0, 8000, 1000, 3, 14, 16, 4, 9, 15};
            int[] temp = new int [mArray.length];
            System.out.println("Before: " + Arrays.toString(mArray));
            Mergesort(mArray, temp, 0, mArray.length - 1);
            System.out.println("Mergesort: " + Arrays.toString(mArray));
            
            System.out.println("allStar");
            System.out.println(allStar("hello"));
            System.out.println(allStar("abc"));
            System.out.println(allStar("ab"));
            System.out.println(allStar("a"));
            
            System.out.print("BinaryNode \n");
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
        
        root.addNode(5);
        
        System.out.print("preorderTraversal \n");
        root.preorderTraversal();
        System.out.println();
        
        System.out.print("inorderTraversal \n");
        root.inorderTraversal();
        System.out.println();
        
        System.out.print("postorderTraversal \n");
        root.postorderTraversal();
        System.out.println();
        
        System.out.print("depthFirstTraversal \n");
       root.depthFirstTraversal();
        System.out.println();*/
	}
}
        

