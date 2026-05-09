    // if you look at this "Initially positioned at the first index"
    // means your indexes are the positions.
    // And from that position.. values would become the max jump you can take
    //0 index has 3, 0+3 = 3-> you can reach 1st or 2nd or 3rd index(pos) maximum 
    //1 index has 1, 1+1 = 2-> you can reach  2nd index (position) maximu

    // Now they asked whether you can reach last position or not
    // Now how can we make sure we would reach the final step
    // If you current position + value = maxJump is good enough to reach last index
    // So at each index we calculate its jump, track the max jump it can reach
    // At every index.. we make sure we have the ability to reach that step
    // By making sure maxJump > i.. i.e maxPosition is greater than current position
    // And we will check if it breached the last index or not,
    // As part of maxJump>i.. we reverse it as maxJump<i. return false
    // Else we would go for next position and calcualte the max jump
    public boolean canJump(int[] nums) {
        int maxJump=0;
        for(int i=0;i<nums.length;i++) {
            if(maxJump < i) //if your maxJump would never reach the current position
             return false; // Means you can never reach last postion, return false

             // You can consider this array which could justify the above condition
             // [2,0,0,1]
             // Now first index, 0+2(value) = 2 max 
             // next 2 < 1(index) no,  1+0(value) = 1-> 2 max
             // next 2 < 2(index) no,  2+0(value) = 2 -> 2 max
             // next 2 < 3(index) yes, now index is 3rd, but you can only reach 2
             // Hence we will return false

            // Now from the current index, adding its value gives us current max jump 
            // So we would track always the maxJump from previous jump also
            // So it would help us to avoid fresh jumps and tack max jumps
             maxJump = Math.max(maxJump, i+nums[i]);

            // incase if your jump is breached the last index.. you can reach there
             if(maxJump>=nums.length)
             return true;
        }

        return true;
        
    }
