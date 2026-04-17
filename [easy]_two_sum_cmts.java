 public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();

        int required=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                map.put(nums[i],i);     // store the value in map if it is of first one, its value and its index
                continue;
            }
            required=target-nums[i];  // target-nums[i] gives the number to make up target except current
            if(map.containsKey(required)) // if that number find in map.containsKe();
            return new int[]{map.get(required),i};  // then get that index and send with current index
            else
            map.put(nums[i],i); // else put the current value into map
            
        }
        return null; // if you come this line no combo present
    }
