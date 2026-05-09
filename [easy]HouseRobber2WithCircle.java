// This is house robber 2 but houses are arranged with circle
// This makes first and last house neighbors which means you cannot rob in neighbor house
// i.,e if you pick first house , avoid last house
// if not pick last house, avoid first house  And follow the dp approach of using for House Rob 1

    // Here houses are arranged in a circular way
        // Due to this. first house and last house becomes neighbors
        // As per condition.. if rob first house , cannot rob last house
        // If you rob last house, you cannot rob first house
        // Because in either the case if you rob first/last at a time
        // It would inform police. Then how to appraoch

        // 1st include First House, and remvoe last house as per instruction
        // 2nd include Last House, and remove first house as per instuction

        // Now their sequence becomes linear and implement dp for that
        // At last identify the maximum among them and return.
        // That would solve the problem

    public int rob(int[] nums) {
      
        int size=nums.length;
        if(size==1)
        return nums[0];
      
        if(size==2)
        return nums[0]>nums[1] ? nums[0] : nums[1];   
      
        int robWithFirstHouse = robHouse(0,size-2,nums);
        int robWithLastHouse = robHouse(1,size-1,nums);
      
        return Math.max(robWithFirstHouse,robWithLastHouse); 
      
    }

    public int robHouse(int start, int end, int[] nums) {
        
        int last2ndHouse = nums[start];
        int lastHouse = Math.max(nums[start],nums[start+1]);
        int maxHouse=0;

        for( int i=start+2;i<=end;i++) {
            maxHouse = Math.max(nums[i]+last2ndHouse,lastHouse);
            last2ndHouse = lastHouse;
            lastHouse = maxHouse;
        }

        return lastHouse;
    }
