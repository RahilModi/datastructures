package com.datastructures.heap;

public class Heap {
    public int[] array;
    public int count;
    public int capacity;
    public int heap_type;

    public Heap(int capacity, int heap_type){
        this.capacity = capacity;
        this.heap_type = heap_type;
        this.count = 0;
        this.array = new int[capacity];
    }

    public int parent(int i){
        if(i <= 0 || i >= this.count) return -1;
        return (i-1)/2;
    }

    public int leftChild(int i){
        int left = (2 * i) + 1 ;
        if(left>=this.count) return -1;
        return left;
    }

    public int rightChild(int i){
        int right = (2 * i) + 2 ;
        if(right >= this.count) return -1;
        return right;
    }

    //Max-heap
    public int getMaximum(){
        if(this.count == 0) return -1;
        return this.array[0];
    }

    public void perlocateDown(int i){
        int left, right;
        int max, temp;
        left = leftChild(i);
        right = rightChild(i);

        if(left != -1 && this.array[left] > this.array[i]){
            max = left;
        }else{
            max = i;
        }

        if(right != -1 && this.array[right] > this.array[max]){
            max = right;
        }
        if(max != i){
            temp = this.array[max];
            this.array[max] = this.array[i];
            this.array[i] = temp;
            perlocateDown(max);
        }
    }

    //delete the max element from the heap and perlocatedown it from the root till satisfy the property.
    public int deleteMax(){
        if(this.count == 0) return -1;
        int root = this.array[0];
        this.array[0] = this.array[this.count -1];
        this.count--;
        perlocateDown(0);
        return root;
    }

    //insert at the end than move it up to satisfy the heap property
    public void insert(int data){
        if(this.count == this.capacity) resizeHeap();
        this.count++;
        int i = this.count -1;
        while( i >= 0 && data > this.array[(i-1)/2]){
            this.array[i] = this.array[(i-1)/2];
            i = (i-1)/2;
        }
        this.array[i] = data;
    }

    public void resizeHeap(){
        int[] old = new int[this.capacity];
        System.arraycopy(this.array,0,old,this.count-1,this.count-1);
        this.array = new int[this.capacity*2];
        int i = 0;
        for(int n:old){
            this.array[i] = n;
            i++;
        }
        this.capacity *= 2;
        old = null;
    }

    public void destroyHeap(){
        this.count = 0;
        this.array = null;
    }

    public void buildHeap(Heap h, int[] input, int n){
        if(h == null) return;
        while(n > h.capacity){
            h.resizeHeap();
        }
        for(int num : input){
            h.insert(num);
        }
        for(int i = (n-1)/2; i >= 0; i--) h.perlocateDown(i);
    }

    public void heapSort(int[] input, int n){
        Heap h = new Heap(n,0);
        int old_size,temp;
        buildHeap(h,input,n);
        old_size = h.count;
        for(int i = (n-1)/2 ; i >= 0 ; i--){
            temp = h.array[0];
            h.array[i] = h.array[h.count-1];
            h.count--;
            h.perlocateDown(0);
        }
        h.count = old_size;
    }

    public int findMaxinMin(Heap h){
        int max = Integer.MIN_VALUE;
        int firstLeafNode = ((h.count - 1) /2 ) + 1;
        for(int i = firstLeafNode; i < h.count; i++){
            if(h.array[i] > max) max = h.array[i];
        }
        return max;
    }

    //delete ith index element
    public int deleteElement(Heap h,int i){
        if(h.count < i) return Integer.MIN_VALUE;
        int key = h.array[i];
        h.array[i] = h.array[count-1];
        h.count--;
        h.perlocateDown(i);
        return key;
    }
}
