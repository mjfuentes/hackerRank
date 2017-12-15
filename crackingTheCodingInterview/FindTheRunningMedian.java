package crackingTheCodingInterview;

import java.util.Scanner;

public class FindTheRunningMedian {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        
        int n = in.nextInt();
        int[] a = new int[n];
        MaxHeap maxHeap = new MaxHeap(n);
        MinHeap minHeap = new MinHeap(n);
        
    	int first = in.nextInt();
    	System.out.println((double) first);
    	int second = in.nextInt();
    	minHeap.addElement(Math.max(first, second));
    	maxHeap.addElement(Math.min(first, second));
        System.out.println(getMedian(minHeap, maxHeap));
        
        for(int a_i=2; a_i < n; a_i++){
            int newInt = in.nextInt();
            if (newInt < maxHeap.peekTop()){
            	maxHeap.addElement(newInt);
            	if (maxHeap.size > minHeap.size +1){
            		minHeap.addElement(maxHeap.removeTop());
            	}
            } else{
            	minHeap.addElement(newInt);
            	if (minHeap.size > maxHeap.size +1){
            		maxHeap.addElement(minHeap.removeTop());
            	}
            }
            
            System.out.println(getMedian(minHeap, maxHeap));
        }
    }
	
	private static double getMedian(MinHeap minHeap, MaxHeap maxHeap) {
		if (minHeap.size == maxHeap.size){
			return (minHeap.peekTop() + maxHeap.peekTop()) / 2.0;
		} else if (minHeap.size > maxHeap.size){
			return minHeap.peekTop();
		} else {
			return maxHeap.peekTop();
		}
	}

	static class MaxHeap {
		int capacity;
		int size = 0;
		
		public MaxHeap(int capacity) {
			super();
			this.capacity = capacity;
			this.elements = new int[capacity];
		}

		int[] elements = new int[capacity];
		
		void addElement(int element){
			int index = size;
			elements[index] = element;
			size++;
			while (index > 0 && elements[index] > elements[(index-1)/2]){
				int temp = elements[index];
				elements[index] = elements[(index-1)/2];
				elements[(index-1)/2]=temp;
				index = (index-1)/2;
			}
		}
		
		int removeTop(){
			int index = size-1;
			int top = elements[0];
			elements[0] = elements[index];
			index = 0;
			size--;
			siftDown(index);
			return top;
		}
		
		void siftDown(int index) {
            int leftIndex, rightIndex, maxIndex, tmp;
            leftIndex = (index*2)+1;
            rightIndex = (index*2)+2;
            if (rightIndex >= size) {
                if (leftIndex >= size)
                        return;
                  else
                	  maxIndex = leftIndex;
            } else {
                  if (elements[leftIndex] >= elements[rightIndex])
                	  maxIndex = leftIndex;
                  else
                	  maxIndex = rightIndex;
            }
            if (elements[index] < elements[maxIndex]) {
                  tmp = elements[maxIndex];
                  elements[maxIndex] = elements[index];
                  elements[index] = tmp;
                  siftDown(maxIndex);
            }
      }
		
		int peekTop(){
			return elements[0];
		}
	}
	
	static class MinHeap {
		int capacity;
		int size = 0;
		int[] elements;
		
		public MinHeap(int capacity) {
			super();
			this.capacity = capacity;
			this.elements = new int[capacity];
		}
		
		void addElement(int element){
			int index = size;
			elements[index] = element;
			size++;
			while (index > 0 && elements[index] < elements[(index-1)/2]){
				int temp = elements[index];
				elements[index] = elements[(index-1)/2];
				elements[(index-1)/2]=temp;
				index = (index-1)/2;
			}
		}
		
		void siftDown(int index) {
            int leftIndex, rightIndex, minIndex, tmp;
            leftIndex = (index*2)+1;
            rightIndex = (index*2)+2;
            if (rightIndex >= size) {
                  if (leftIndex >= size)
                        return;
                  else
                        minIndex = leftIndex;
            } else {
                  if (elements[leftIndex] <= elements[rightIndex])
                        minIndex = leftIndex;
                  else
                        minIndex = rightIndex;
            }
            if (elements[index] > elements[minIndex]) {
                  tmp = elements[minIndex];
                  elements[minIndex] = elements[index];
                  elements[index] = tmp;
                  siftDown(minIndex);
            }
      }
		
		int removeTop(){
			int index = size - 1;
			int top = elements[0];
			elements[0] = elements[index];
			index = 0;
			size--;
			siftDown(index);
			return top;
		}
		
		int peekTop(){
			return elements[0];
		}
	}
}
