import java.util.*;

public class Sorts<E extends Comparable<? super E>> {
    public static void main(){
        Sorts<Integer> rs = new Sorts<Integer>();
        List<Integer> data = new ArrayList<Integer>();
        data.add(910);
        data.add(5);
        data.add(15);
        data.add(288);
        data.add(3);
        data.add(200);
        data.add(1);
        data.add(7);
        rs.mergeSort(data);
        System.out.println(data);
    }
    
    /**Constant O(n^2)*/
    public void selectionSort(List<E> data){
        for(int i = 0; i < data.size(); i++) {
            E smallest = data.get(i);
            for(int j = i+1; j < data.size(); j++)
                if(data.get(j).compareTo(smallest) < 0)
                    smallest = data.get(j);
            if(smallest.compareTo(data.get(i)) < 0) {
                int x = data.indexOf(smallest);
                data.set(x, data.get(i));
                data.set(i, smallest);
            }
        }
    }
    
    /**Best: N; worst: N^2. Speed increases the closer the data is to sorted in ascending order*/
    public void insertionSort(List<E> data){
        for(int i = 0; i < data.size(); i++) {
            E temp = data.get(i);
            int j = i-1;
            while(j >= 0 && data.get(j).compareTo(temp) > 0) {
                data.set(j+1, data.get(j));
                j--;
            }
            data.set(j+1, temp);
        }
    }
    
    /**Constant nlog(n)  time*/
    public void mergeSort(List<E> data){
        if(data.size() == 1)
            return;
        int midline = data.size()/2 + 1;
        List<E> arr1 = new ArrayList<E>();
        List<E> arr2 = new ArrayList<E>();
        for(int i = 0; i < midline; i++)
            arr1.add(data.get(i));
        for(int i = midline+1; i < data.size(); i++)
            arr2.add(data.get(i));
        mergeSort(arr1);
        mergeSort(arr2);
        List<E> temp = combineLists(arr1, arr2);
        data.clear();
        data.addAll(temp);
    }
    private List<E> combineLists(List<E> one, List<E> two) {
        List<E> sorted = new ArrayList<E>();
        while(!one.isEmpty() || !two.isEmpty()) {
            if(one.get(0).compareTo(two.get(0)) <= 0)
                sorted.add(one.remove(0));
            else
                sorted.add(two.remove(0));
        }
        if(one.isEmpty())
            sorted.addAll(two);
        else if(two.isEmpty())
            sorted.addAll(one);
        return sorted;
    }
    
    /**Constant nlog(n) time*/
    public void heapSort(List<E> data){
        PriorityQueue<E> heap = new PriorityQueue<E>(data);
        data.clear();
        while(!heap.isEmpty())
            data.add(heap.poll());
    }
    
    /**Constant nlog(n) time*/
    public void bucketSort(List<Integer> data){
        final int BUCKETRANGE = 5;
        Integer small = data.get(0);
        Integer large = data.get(0);
        for(Integer i : data) {
            if(small.compareTo(i) > 0)
                small = i;
            if(large.compareTo(i) < 0)
                large = i;
        }
        int bucketCount = (large-small) / BUCKETRANGE+1;
        //I am a naughty guy...
        ArrayList<Stack<Integer>> buckets = new ArrayList<>(bucketCount);
        for(int i = 0; i < bucketCount; i++)
            buckets.add(new Stack<Integer>());
        for(Integer i : data)
            buckets.get( (i - small) / BUCKETRANGE).push(i);
        data.clear();
        for(Stack<Integer> bucket : buckets)
            data.addAll(bucket);
        insertionSort( (List<E>) data);
    }
    
    /**Worst: O(kn); best: O(k+n) where k = numBuckets*/
    public void radixSort(List<Integer> data){
        final int NUMBUCKETS = 10;
        Integer large = data.get(0);
        for(Integer i : data)
            if(large.compareTo(i) < 0)
                large = i;
        ArrayList<Stack<Integer>> bucketList = new ArrayList<>(NUMBUCKETS);
        
        int count = 1;
        while(large > 0) {
            for(Integer i : data)
                bucketList.get(i / count % NUMBUCKETS).add(i);
            data.clear();
            for(int i = 0; i < NUMBUCKETS; i++) {
                data.addAll(bucketList.get(i));
                bucketList.get(i).clear();
            }
            large /= 10;
            count *= 10;
        }
    }
    
    /**
     * Best: O(n), worst: O(n^2)
     * Procedure:
     * Select a pivot
     * Create 2 lists - smaller & larger
     * Sort the data based on the pivot
     * Recursive quicksort the smaller and larger
     * Combine smaller, pivot, and larger together
     */
    public void quickSort(List<E> data){
        //base case
        if(data.size() == 1)
            return;
        //Select pivot
        E pivot = data.remove((int)(Math.random()*data.size()));
        //Split arrays
        List<E> smaller = new ArrayList<E>();
        List<E> larger = new ArrayList<E>();
        while(!data.isEmpty())
            if(data.get(0).compareTo(pivot) < 0)
                smaller.add(data.remove(0));
            else
                larger.add(data.remove(0));
        //Quicksort each
        quickSort(smaller);
        quickSort(larger);
        //Combine lists
        data.addAll(smaller);
        data.add(pivot);
        data.addAll(larger);
    }
}