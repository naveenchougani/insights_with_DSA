class Solution {
    public int minCostClimbingStairs(int[] cost) {

        if(cost.length==1)
        return cost[0];
        if(cost.length==2)
        return cost[1]>cost[0]?cost[0]:cost[1];

        int Last2ndStep = cost[0]; 
        int Last1stStep = cost[1]; 
        // We have number of stairs so that we can reach top.
        // I.e, you can reach from last stair,, or from last 2nd stair because you can take 1 or 2 jumps
        // So to reach top only 1 jump from last step and 2 jump from last 2nd step would do the work

        // Assume the above return statements are worked if it has only 2 stairs
        // Now if you reach this step.. you have stairs =3 or > 3
        // Assume if you have stairs 3.. you can reach top from 3rd stair and 2nd stair
        // So we find 3rd stair cost by including it cost + minimum of its previous 2;
        // So now.. Last1Step becomes Last2ndStep and Last1Step becomes CurrentStep..
        // after loop, top can choose to select minimum from laststep and its previous step..
        // Similar for the 4th step also.. calculate its currentcost by its + min(previous 2 step)
        // Last2ndBecomes the Last1st  and Last1st becomes the currentCost..
        // After the loop top can choose from these two.. and 
        // Top would not required to incure any cost.. hence we are not adding any
        
        for(int i=2;i<cost.length;i++) {
            int currentStepCost = cost[i]+Math.min(Last1stStep,Last2ndStep);
            Last2ndStep=Last1stStep;
            Last1stStep=currentStepCost;
        }

        return Math.min(Last1stStep,Last2ndStep); // Top can always choose last or last2nd step
    }
}
