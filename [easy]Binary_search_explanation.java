// In Binaray search , it works only if the arrays is sorted. You must make sure " while ( l < = r) " works Beacuse
// l < r breaks only when l and r both stands at one index.. that might be at first, last, or somewhere in the middle.
// IMP And that might be the target we are looking. So while( l < r ) would skip that index making to fail at edge cases.
// for simple exmaple [5] just only 0 index and l=0, r=0 and l<r would even skip that.
// simlary [1,3,5] where target is 5, eventaully l hops from 1 to 5 and l goes mid+1 and now r and l both are at 5. and this l<r fails this edge case.

// And mid always found using l+(r-l)/2 instead of (l+r)/2 because if you add both results.. they might cause overflow and results in negative.
// But even l+(r-l)/2 can be re-written as (2l+r-l)/2 and becomes (l+r)/2 means both are identical
// Because if you integer limit is 30 lets say and left is at 15 and right is 20 and l+r is 35 which is way beyond 30 and resutls in negative 
// Hence to break this 20-15 gives 5/2=2.5, and add it to the left i.e, 15 results in 17.5 equals to 35/2=17.5.. ie. 
// IMP   Becuase the second formula is derived from first so both results will always be same. Just with safe way to not overfow

// And once arr[mid] != target either it is less than or greater than..
// Then you move the left or right index to mid+1 or mid -1 --> as this is equal to progressing towards the required answer.
// And that would eventually leads to cross left and right index , and helps to break the loop in case if target is not found

// Imp
// And right should always be the length-1 else.. it results in error.
// nums[10] and target is 20.. then l shifts to 1 and r is at 1 and both results 2/2=1 and arr[1] results in index out of bounds.
// if r sets to be 0 i.e, length-1 and as soon as left goes to 1 and loop breaks as l>r...

 int l=0, r=nums.length-1;  -> here l and r both are inclusive.. so we must check both places in case of target found at both edges
        int mid=0;
        while(l<=r){ -----------------> helps to capture the index where both results at same index due to above reason.. l<=r makes it happen
            mid = l+(r-l)/2;
            if(nums[mid]==target)
                return mid;
            
            if(nums[mid]<target) {
                l = mid+1;     ------------> grow towards right
            } else if (nums[mid]>target) {
                r = mid-1;    -------------> shrink towards left 
            }
        }
      return -1;
