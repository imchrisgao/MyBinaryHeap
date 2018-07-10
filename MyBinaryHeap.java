package mybinaryheap;

import java.util.Arrays;

public class MyBinaryHeap { //let's just use ints for now and then we can implement generic Collection
	//let 0 be null value for convenience
	int[] arr;
	int end; //would be nice if this could just be a local variable...but no null value in array...
	
	MyBinaryHeap(int root){
		arr = new int[15]; //4 levels
		
		arr[0] = root;
		end = 0;
	}
	
	//*********************************
	//private methods
	
	//heapify + swap
	private void heapify(){ //eventually make it so that you don't check the whole tree
		int counter;
		do {
			counter=0;
			//let's do backwards for loop
			for (int n = end; n > 0; n--) { //don't need to go all the way to root
				if (n % 2 == 0) { //if divisible by 2, it's on the right
					if (arr[n]!=0 && arr[n] < arr[(n - 2) / 2]) {
						swap(n, (n - 2) / 2);
						counter++;
					}
				} else { //if it's not divisible by 2, it's on the left
					if (arr[n]!=0 && arr[n] < arr[(n - 1) / 2]) {
						swap(n, (n - 1) / 2);
						counter++;
					}

				}
			} 
		} while (counter!=0);
	}
	
	private void swap(int index1, int index2){ //a swap function specifically for arrays
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	//decreaseKey + extractMin
	private void decreaseKey(int index){ //i think this is necessary because pass by value
		arr[index] = -100;
	}
	
	private void extractMin(){
		heapify();
		arr = Arrays.copyOf(Arrays.copyOfRange(arr, 1, arr.length), arr.length);
		heapify();
	}
	
	//*********************************
	//public methods 
	public void insert(int i){
		end++;
		arr[end] = i;
		heapify();
	}
	
	public void delete(int i){
		int find = 0;
		for(int n=0; n<arr.length; n++){
			if(arr[n] == i){
				decreaseKey(n);
				find++;
				break;
			}
		}
		if(find == 0){
			System.out.println("'" + i + "' does not exist");
		}
		else{
			extractMin();
			end--;
		}
	}
	
	//?+?+?+?+?+?+?+?+?+?+?+?+?+?+?+?+?
	//print/view methods
	public String viewHeap(){ //not very useful
		StringBuilder temp = new StringBuilder();
		for(int n=0; n<arr.length; n++){
			temp.append(arr[n] + " ");
		}
		return temp.toString();
	}
	
	public void printTree(){
		for(int n=0; n<arr.length; n++){ 
			if(n==1 || n==3 || n==7){
				System.out.println();
			}
			System.out.print(arr[n]+" ");
		}
		System.out.println();
		System.out.println("-----------------------");
	}
	
	public int getMin(){
		return arr[0];
	}
	
}
