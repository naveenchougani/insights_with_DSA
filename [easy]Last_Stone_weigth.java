// in an array which represents weight of stone.. we have to do following things
// we choose the heaviest two stones and smash them together ( so we must sort the array into descending order or reverse order)
// if x is large, y is small and if x==y, we have smash them together, else if x!=y, create a new stone weight by x-y.
// So if stones left =1 return its weight... if no stones left return 0.

// Clearly we can use priority queue with collections.reverseOrder() method so always we pick highest stone
// and we always take two stones.. so they might create new stone.. else if they are equal they are popped
// So while loop we ensure we will only run only if size()>=2.. so we always ensure 2 elements were available to process

    public int lastStoneWeight(int[] stones) {
      
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); // PQ with maximum heap
      
        for(var stone:stones)
            pq.offer(stone);
      
        int small=0,large=0;
        
      while(pq.size() >= 2 ){  // So run loop atleast or greater than size = 2.. so it can always picks up two elemetns 
            large = pq.poll();
            small = pq.poll();
        // Now it two elements may be equal or not equal
        // Let us assume they are equal and we already took them from list
        
        // So another check we perform , if both are unequal then we minus and insert new weight
            if(large!=small)
                pq.offer(large-small);
        } 

      // See what if size =2 and both are equal, size becomes 0
      // But what if both are not equal and size becomes 1..
      // So we may have size ==0 or size==1, so handle both
        return pq.isEmpty() ? 0 : pq.peek() ;        
    }
