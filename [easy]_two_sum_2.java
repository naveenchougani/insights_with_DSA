// similar to two sum but i must be less than j
// and given array is sorted order
// So we can easily use two pointer approach as one solution is present

public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]>target) // if both value are higher decrement right side index as it is sorted
            j--;
            else if(numbers[i]+numbers[j]<target) // if both value is lesser increment left side to bring vlaue higher as it is ascending
            i++;
            else if(numbers[i]+numbers[j]==target) // else if both are true then send by incrementing as it needs one indexed
            return new int[]{i+1,j+1};
        }
