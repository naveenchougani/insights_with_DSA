// First understand the problem that Kth largest element means.. you must need array to be sorted.
// Then from sorted ( ascending order) you will return size-1-k would give the index of kth element from las size.
// Because Large elements are from last so 3rd largest, 4th largest are always at 4th position from last.
// So.. we are picking up the smallest element in the group of K large elemetns.. and that becomes the Kth largest element
// So if the numbers in array is billion or similar to that level and k group is 10 or 11,
// The storing in List and returning from last would become expensive. So any other way
// Priority Queue will store the smallest element at the top among the available set of integers..
// Means it would become the kth largest element by making priority queue size is always equal to k.. then peek the value
// Because the values are almost sorted in ascending order and we are removing the smallest numbers 
// and only stores the large numbers of equal to size k. And the very first item in K group becomes the kth largest element

Kth Largest element means... in a group of numbers.. the highest largest number becomes 1st, then its lower number is 2nd, and lower number than 2nd becomes 3 rd largest
  and number less 3rd largest becomes 4th largest number.

  // Code....


class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>(k);

        for(var num:nums){
            pq.add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()!=k){ // remove extra elements from priority queue until k and its size equal
            pq.poll();
        }
        return pq.peek();  // the first lower number among size of K largest group would become the kth Largest number
    }
}
