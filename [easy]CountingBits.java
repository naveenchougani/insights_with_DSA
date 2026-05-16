// if n is given.. return an array from 0th index... to nth index..
// where each index represents the number and holds the no.of 1 bits in that number.

// This simple solution would do the work
arr[i] = arr[i >> 1] + (i & 1);

// the above code works like a dp and process it self it becomes like finding the solution
// arr [i >> 1] is equal i / 2 ===> so it halfs the number
// i & 1 i ===> it works like in binary repesentation 
//         ====> even number at last have 0, and 1 would always have only 1 bit at end..
          ======> due to this even number & 1 would always results in 0, even number >> 1 always removes the last 0 in the bits. So no harm here
          =====> odd number >> 1 means odd numbers ends with 1, and >> 1 removes that bit
          =====> odd number & 1 always makes it like last 1 of odd number and last of 1 bit of 1.. results in 1 and adding the back the same removed bit
          =====> this helps to restore the lost bit. Hence the combination is required to restore the last bit in the odd number case

Step 1: Process 3 
Binary:    1 1          -> Stored in DP table: ans[3] = 2

Step 2: Process 6
Binary:    1 1 0 
               └───> Shift right drops this 0, leaving '1 1' (which is 3)

DP Lookup: ans[6] = ans[3] + 0 
                  = 2 + 0 
                  = 2

=========================== CODE ==========================================

  class Solution {
    public int[] countBits(int n) {
      
        int[]  arr = new int[n+1];
  
        // Avoid 0th index, as 0 number would contain 0 1's.
  
        // Hence start from 1st index
        for(int i=1;i<=n;i++) {
          
            // i >> 1 = i/ 2 = half of i
          
            // i & 1 is like for even it returns 0, for odd it returns 1
            arr[i] = arr[i >> 1] + (i & 1);

        }

        return arr;
    }
}
