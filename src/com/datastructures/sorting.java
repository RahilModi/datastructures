package com.datastructures;

import java.util.Arrays;

public class sorting {

    //Bubble Sort: O(n2) complexity even in best case
    //Best for to detect input is sorted or not.
    public static void bubbleSort(int[] input){
        if(input.length == 1) return;
        for(int i = input.length-1; i>=0;i--){
            for(int j = 0; j< i-1;j++){
                if(input[j] > input[j+1]){
                    int temp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                }
            }
        }
    }

    //Bubble Sort: O(n2) complexity , in best case O(n)
    //Use flag to detect already sorted input in first iteration
    public static void bubbleSortWithFlag(int[] input){
        if(input.length == 1) return;
        boolean swapped = true;
        for(int i = input.length-1; i>=0 && swapped;i--){
            swapped = false;
            for(int j = 0; j< i-1;j++){
                if(input[j] > input[j+1]){
                    int temp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                    swapped =true;
                }
            }
        }
    }

    //selection sort: inplace sorting based on the key => suited for large values based on keys
    //complexity: O(n2) in best, average and worst
    public static void selectionSort(int[] input){
        if(input.length == 1) return;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<input.length-1 ; i++){
            min = i;
            for(int j = i+1; j<input.length;j++){
                if(input[j]<input[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = input[i];
                input[i] = input[min];
                input[min] = temp;
            }
        }
    }

    //insertion sort: inplace sorting
    //complexity: O(n2) in best, average and worst
    public static void insertionSort(int[] input){
        if(input.length == 1) return;
        int j, val;
        for(int i = 1; i<input.length ; i++){
            val = input[i];
            j = i;
            while(j >= 1 && input[j-1] > val){
                input[j] = input[j-1];
                j--;
            }
            if(j != i) input[j] = val;
        }
    }

    //Shellsort: extension of insertion sort. instead of checking adjacent elements every time checks elements at h distance away
    //decrease the h in sequence and resulted h value will be 1 is same as insertion sort number of exchanges will be reduced significantly.
    //O(nlog^2 n) worst case //Bestcase O(n)
    public static void shellSort(int[] input){
        if(input.length == 1) return;
        int h,val,j;
        for(h = 1; h<= (input.length /9) ; h = (3*h)+1);
        for(; h>0;h/=3){
            for(int i = h+1;i<input.length;i++) {
                j = i;
                val = input[i];
                while (j >= h && input[j - h] > val) {
                    input[j] = input[j - h];
                    j -= h;
                }
                if (j != i) input[j] = val;
            }
        }
    }

    //MergeSort: Based on Divide And Conquer
    public static void mergeSort(int[] input, int left, int right){
        if(left < right){
            int mid = left + (right-left)/2;
            mergeSort(input,left,mid);
            mergeSort(input,mid+1, right);
            merge(input, left, mid, right);
        }
    }

    public static void merge(int[] input, int left, int mid, int right){
        int leftEnd = mid-left+1;
        int rightStart = right - mid;

        int[] L = new int[leftEnd];
        int[] R = new int[rightStart];

        for(int i = 0; i<leftEnd; i++){
            L[i] = input[left+i];
        }
        for(int j = 0; j<rightStart; j++){
            R[j] = input[mid+1+j];
        }
        int i = 0, j=0,k =left;
        while(i < leftEnd && j <rightStart){
            if(L[i] <= R[j]) {
                input[k] = L[i];
                i++;
            }else{
                input[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < leftEnd){
            input[k] = L[i];
            k++;
            i++;
        }

        while(j < rightStart){
            input[k] = R[j];
            k++;
            j++;
        }
    }

    //Quick Sort
    public static void quicksort(int[] input, int low, int high){
        if(high>low){
            int pivot = partitioner(input,low,high);
            quicksort(input,low,pivot-1);
            quicksort(input,pivot+1,high);
        }
    }

    public static int partitioner(int[] input, int low, int high){
        int pivot = input[high];
        int i = low - 1;

        for(int j=low;j<high;j++){
            if(input[j]<=pivot){
                i++;
                if(i!=j)
                    swap(input, i,j);
            }
        }
        swap(input, i+1, high);
        return i+1;
    }

    public static void swap(int[] input, int index, int index1){
        int temp = input[index];
        input[index] = input[index1];
        input[index1] = temp;
    }

    public static void print(int[] input){
        for(int i:input){
            System.out.print(i+"-");
        }
    }

    public static void heapSort(int[] input){
        int len = input.length;
        for(int i = (len/2) - 1; i>=0;i--){
            heapitfy(input,len,i);
        }

        for(int i = len-1;i>=0;i--){
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;

            heapitfy(input, i, 0);
        }

    }

    public static void heapitfy(int[] input, int len, int h){
        int largest = h;
        int left = 2 * h + 1;
        int right = 2 * h + 2;

        if(left < len && input[left]> input[largest]){
            largest = left;
        }
        if(right < len && input[right]> input[largest]){
            largest = right;
        }

        if(largest != h){
            int temp = input[h];
            input[h] = input[largest];
            input[largest] = temp;

            heapitfy(input, len, largest);
        }

    }

    public static void countingSort(int[] arr){
        int[] temp = new int[256];
        int[] output = new int[arr.length];
        for(int i = 0; i<256;i++){
            temp[i] = 0;
        }

        for(int i=0;i<arr.length;i++){
            ++temp[arr[i]];
        }

        for(int i = 1; i<256;i++){
            temp[i] += temp[i-1];
        }

        for(int i =0; i<arr.length;i++){
            output[temp[arr[i]]-1] = arr[i];
            --temp[arr[i]];
        }

        for(int i = 0;i<arr.length;i++){
            arr[i] = output[i];
        }
    }

    public static void bucketSort(int[] arr){
        final int BUCKETS = 10;
        int[] buckets = new int[BUCKETS];
        for(int i = 0; i<BUCKETS;i++){
            buckets[i] = 0;
        }
        for(int i = 0; i<arr.length;i++){
            ++buckets[arr[i]];
        }

        for(int i = 0, j = 0; i<BUCKETS;i++){
            for(int k = buckets[i]; k>0 ;k--){
                arr[j++] = i;
            }
        }
    }

    public static int getMax(int[] input){
        int max = Integer.MIN_VALUE;
        for( int i : input){
            if(max < i){
                max = i;
            }
        }
        return max;
    }

    public static void countSortForRadix(int[] arr, int base){
        int[] output = new int[arr.length];
        int [] count = new int[10];
        Arrays.fill(count,0);
        for(int i = 0; i<arr.length;i++){
            count[(arr[i]/base)%10]++;
        }

        for( int i = 1; i<count.length; i++){
            count[i] += count[i-1];
        }

        for (int i = arr.length-1;i>=0;i--){
            output[count[(arr[i]/base)%10] - 1] = arr[i];
            count[(arr[i]/base)%10]--;
        }

        for( int i =0 ;i<output.length;i++){
            arr[i] = output[i];
        }

    }
    public static void radixSort(int[]arr){

        int max = getMax(arr);
        for( int i = 1; max/i > 0; i*=10){
            countSortForRadix(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,5,2,5,3,7,9,10,2,4,7};
        //bubbleSort(input);
        print(input);
        System.out.println();
        int[] input1 = new int[]{3,2,1,4,5};
        //bubbleSort(input1);
        //selectionSort(input);
        insertionSort(input);
        print(input);
        insertionSort(input1);
        System.out.println();
        print(input1);
        System.out.println();
        int[] input22 = new int[]{1,5,2,5,3,7,9,10,2,4,7};
        shellSort(input22);
        print(input22);
        System.out.println();
        int[] input11 = new int[]{1,5,2,5,3,7,9,10,2,4,7};
        mergeSort(input11, 0, input11.length-1);
        print(input11);
        System.out.println();
        int[] input12 = new int[]{10,5,2,5,3,7,9,10,2,4,7};
        quicksort(input12, 0, input11.length-1);
        print(input12);
        System.out.println();
        int[] input13 = new int[]{1,2,2,4,3,7,9,10,4,8};
        heapSort(input13);
        print(input13);
        System.out.println();
        int[] arr = new int[]{1,24,43,244,22,4,22,133,5,67,9,23};
        countingSort(arr);
        print(arr);
        System.out.println();
        int[] arr1 = new int[]{1,2,4,2,3,1,4,2,6,5,8,9,6,2,5,4};
        bucketSort(arr1);
        print(arr1);
        System.out.println();
        int arr2[] = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr2);
        print(arr2);

    }
}
