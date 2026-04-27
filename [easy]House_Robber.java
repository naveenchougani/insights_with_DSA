class Solution {
    // Here they are asking you cannot rob the very adjacent house..
    // I.e, assume you are at house 3.. you can only rob house 1 and house 3
    // or you can only rob house 2.
    // Now return the maximum of them.. so put max function
    // But what if you have more than 3 houses and many houses..
    // So use dp,that at every house.. I will store the max possible score
    // By abidng the rules ie. max(currentHouse+prev2House, or prev1House)
    
    // So in this dp programming, the above rules starts from the very first house
    // if house = 1.. prev2ndHouse always holds that value..
    // if house = 2.. prev1stHouse always holds max(nums[0], nums[1]);
    // from house 3 and so on.. you find max at that house from prev1 or house+prev2;
    // then swap the houses so they are ready for next houses.. and by end of loop
    // prev1 always holds the current max.. as it is updated after each iteration.
    // Like prev1 and prev2 are maximum weight carriage at any stage

    public int rob(int[] nums) {

        int size=nums.length;
        
        if(size==1) return nums[0];

        if(size==2) return nums[0]>nums[1] ? nums[0] : nums[1] ;

        int maxAtCurrHouse = 0, prev2ndHouse = nums[0];
        int prev1stHouse = nums[0] > nums[1] ? nums[0] : nums[1];

        // at every house.. always hold the maximum rob abiding by rules
        // By this third house we rob.. we can included from prev2nd house.
        // And get the maximum by comparing the previous1 house;

        for(int i=2;i<nums.length;i++) {
        
        // Already prev1 and prev2 holds the best possible answer
        // so add the current house to prev2 and compare with last and get max
        // As you cannot rob from adjacent or immediate last house
        maxAtCurrHouse = Math.max(prev2ndHouse+nums[i],prev1stHouse);

        // After calculating the maxAtCurrentHouse, if you go to next house
        // the maxAtCurrentHouse becomes prev1 house, and prev1 house becomes prev2;
        // So swap the values and get correct results
            prev2ndHouse = prev1stHouse;
            prev1stHouse=maxAtCurrHouse;
        }

        // At end of each iteration / or end of loop
        // prev1 holds the bestPossible soultion at currentHouse/LastHouse
        // Hence return prev1stHouse after loop terminated

        return prev1stHouse;
    
    }
}
