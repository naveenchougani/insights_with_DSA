// Give the no of different ways to reach a stair with below restrictions.
// But you can only move either 1 step or 2 steps. For example below
// To reach Step 1: paths [1] = 1 way
// To reach Step 2: paths [1,1],[2] = 2 ways

But the magic of the above problem is if you add the ways of n-1 step and n-2 step brings the answer to the 3rd step
Because to reach any destination you must take 1 jump or 2 jump, hence to reach destination
you can only go their from last step by 1 jump or from last 2nd step by 2 jump
  
  n = ways(n-1) + ways(n-2);
  n = ways(2)  +   ways (1);
  n = 2 + 1;
  n = 3;

Now technically n = (n-1)ways + (n-2)ways means we are adding ( ways req for 2nd step) + (ways req for 1st step)
  
then how does this formula works?

The truth is from step (1)  ways => [1] only one way, to reach 3rd step
                            ways => [1,2] ia new combo but one way again . Here last jump 2 is added to all existing ways
the truth is from step (2)  ways => [1,1] , [2] two ways, to reach 3rd step
                            ways => [1,1,1] [2,1] is a new combo but two ways again. Here last jump 1 is addded to all existing ways

Clearly even if you stand at destination or at last step to reach destination..  
The number of ways remains same. But why?
  
Because the last step you take to reach destination is the key to all the available different ways to reach destination. 
So without that combo.. an existing way can never reach destination. Hence all the existing ways would make their with this or throught this new jump.
Hence every lane becomes different/new with addition of this new jump. This jump alone would not create new lane. It just makes them distinct

Hence ways at n-1 + ways at n-2 would works true. The below you can look at code:

========================================================================================

class Solution {
    public int climbStairs(int n) {

        if(n<=2)
        return n;

       int waysFrom1stLastStep=2, waysFrom2ndLastStep=1, totalWays=0;  // From stair 2 => 2 ways, from stair 1 => 1 way
      
       for(int i=3;i<=n;i++)          // we will start from counting for the stair 3. And we will swap last step and last second step
       {
        totalWays= waysFrom2ndLastStep+waysFrom1stLastStep;
        waysFrom2ndLastStep=waysFrom1stLastStep;
        waysFrom1stLastStep = totalWays;
       }

       return totalWays;

    }
}

