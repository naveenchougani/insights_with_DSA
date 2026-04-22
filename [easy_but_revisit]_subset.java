[1,2,3] subsets are [] [1] [1,2] [1,2,3] [1,3] [2,3] [3]. So have to find out all the susbets..
// This cannot be solved by having two inner loops as it would only help capture the size of two elemetns in a list.
// Okay Lets build a intuition by looking at the answer.
// first all combos starting with value at inde=[0] like 1 , 1,2  , 1,2,3  ,  1,3 
// then 2,  2,3  and then 3.
// But when you see.. 1,2,3  we also have to find out 1,3 combo i.e, result has to go to its back remove 2 and find out the solution.
// Mean we must need to go back to its..we can call it as backtracking but its bit complicated.
// We keep a shared temp folder and we always try to add the value into it and every time we add a value into it, we add it to resulst
// like 1, 2, 3 are added to temp in 3 iteration.. but 1, 1,2, 1,2,3 are added into result set.. this way temp would help.
// Here we use a combo of for loop with recursion along with remove so that it traverses through other possible combos

  // But simple logic is add a vlaue to the temp
  // call a recursion with next position of i,
  // also remove the last item of the temp.. because loop breaks when i greater than n.. and by that time.. last item is the one added by the current stack..
  // so remove the last item would do the work

  class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        subset(0,nums,temp,result);  // initially pass empty list
        return result;
    }

    public void subset(int start,int[] nums,List<Integer> temp,List<List<Integer>> result) {
      // this is very first step to ensure even empty list is added with deep copy
        result.add(new ArrayList<>(temp));
      
        for(int i=start;i<nums.length;i++) { // This for loop will run for i=0, i=1, i=2
          
            temp.add(nums[i]); // every time we will add only one element to the temp list.. this might be a single size, two size.. or infinite
          
            subset(i+1,nums,temp,result); // this recursion helps to for loop upto size n for every i =0, i=1, i=2
                                          // i.e, when i=0 at the top.. actaully this recursion would call for loop to run from i=1,2
                                          // i.e, when i=1 at the top, i=2
                                          // ie,, when i=3 at the top, calls i=3
          
            temp.remove(temp.size()-1);  // this always removes value added to the temp list.
                                        // why we need to remove this because once you hit the last 1,2,3 you might need to remove 3 and 2
                                        // and look for 1,3 and after that you might need to remove 3 and 1.. so that empty list carried by 
                                        // the next for loop starting at i=1.. ie, [2] then [2,3] and remove 3, and 2 and i become 3
                                        // add temp = [3] and recursion i=3 for loop fails and 3 is removed and i =4
                                        // so the final loop is is completed
        }
    }
}
