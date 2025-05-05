package lab4;

import java.util.Arrays;

public class Selection {
	public static void main(String[] args ) {
		int[] arr= {2, 3, 4, 1};
//selection sort
//		for(int i=0; i<arr.length-1;i++) {
//		for(int j=i+1; j<arr.length ; j++) {
//			if(arr[j] < arr[i]) {
//				int temp = arr[i];
//				arr[i]=arr[j];
//				arr[j]=temp;
//			}
//		}
//bubble sort
//		for(int i=0; i<arr.length-1; i++) {
//		for(int j=0; j<arr.length-1-i;j++) {
//			if(arr[j]>arr[j+1]) {
//				int temp = arr[j];
//				arr[j] = arr[j+1];
//				arr[j+1] = temp;
//			}
//		}
//insertion sort
		for(int i=1; i<arr.length; i++) {
			for(int j=i; j>0 && arr[j]<arr[j-1]; j--) {
				int temp = arr[j];
				arr[j]=arr[j-1];
				arr[j-1]=temp;
			}

		}
		
		System.out.println(Arrays.toString(arr));
	}
}

//	}




