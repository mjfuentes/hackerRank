package crackingTheCodingInterview;

import java.util.Scanner;

public class CountingInversions {
	
	static long countInversions(int[] arr) {
		int[] aux = arr.clone();
        return countInversions(arr, aux, 0, arr.length-1);
    }
	
	static long countInversions(int[] items,int[] aux, int begin, int end){
		
		if (begin == end){
			return 0;
		}
		
		long total = 0;
		int mid = (begin+end)/2;
		total += countInversions(aux,items, begin, mid);
        total += countInversions(aux,items, mid+1, end);
        total += merge(items,aux,begin, mid+1, end);
        
		return total;
	}
	
	static long merge(int[] items,int[] aux, int start, int mid, int end){

		int left = start, right = mid, index = start;
        long count = 0;
		while (left < mid && right <= end){
			if (items[left] <= items[right]){
				aux[index] = items[left];
				left++;
			} else {
				aux[index] = items[right];
				count+= mid - left;
				right++;
			}
			index++;
		}
		
		while (left < mid){
			aux[index] = items[left];
			left++; index++;
		}
		
        while (right <= end){
        	aux[index] = items[right];
        	right++; index++;
        }

		
		return count;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }
}
