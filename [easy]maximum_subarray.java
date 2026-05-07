// maximum subarray whose total addition was greater. 
// if you think all are +ves, then its easy as adding up all the numbers would make the maximum subarray...
// But the problem comes only if negatives introduced.. the very main problem comes if the array starts with -ve numbers.
// so how we solve the problem , we will solve the problem by step by step

// currentMax = (nums[i], nums[i]+currentMax) 
// the above line tackels if currentMax is value suddenly becomes lesser than the currentNumber nums[i], which is a very possible scenario with negative numbers included
// that is taken care of to incude the very maximum number at every addition. Else if all are +Ve nums[i]+currentMax is considere. So this one handles everything

//******* IMP IMP IMP *****//
// This also handle another case. Assume you have array [10, -2, 20]
// now currentMax is 10, when you add -2 to 10, currentMax becomes 8, nums[i] is 2
// i.e, currentMAx = Max(-2, -2+10) = 8 (i,e, you have included -2 in you sum calculation which bought down 10 to 8.
// Assume if you think as nums[i] is negative integer and it is bringdown the sum.. so lets stop this subarray.
// We will pickup new next +ve integer and start fresh from there.. 20 woudl becomes new maxSubarray.
// But if you include 8 to the 20 it becomes 28.  Obviousl u 28 > 20
// I.e, currentMax = max(nums[i],currentMax+nums[i]) 
// saying if nums[i] -ve, and its addition to currentMax is +Ve or greater than its value means
// currentMax is atleast greater than 1 or more than that.. and that extra offset of 1 or more than value is excess
// that addition to next value ( 8 adding to 20) is alwasy greater than picking up new positive integer
// That is how it tackes the problem

// Simple with -ve numbers introduction.. currentMax can be -ve and nums[i] can be positive,, and here you need to offset ot nums[i]
// that is taken care by math.max(nums[i], nums[i]+currentMAx) , else currentMax + nums[i] is greater and it is picked up always
// This single case woudl also handles anothe edge case as side effect
// even if nums[i] additon bringsdown the currentMax..i.e nums[i] is negative.. but if currentMax is +Ve and still we have +Ve offset..
// then still we include nums[i] additon so it helps the next addtion of number + this extra +V offset is cumulatively greater..
// and this make sure that the additon was contagious..

// So yeah its bit and pieces but it has clearly sovle the issue for maximum sub array


    public int maxSubArray(int[] nums) {

            if(nums.length==1)
            return nums[0];

            int maxSubArray =nums[0] , currentMax=nums[0]; // good idea as if nums[i] becomes starting point to compare instead of 0,-1 which would be narrow intial value
                                                          // this nums[0] make sure that we are always compring and picking up the nums array value not missing any one

            for(int i=1;i<nums.length;i++) {
                currentMax = Math.max(nums[i], nums[i]+currentMax);
                maxSubArray = Math.max(currentMax,maxSubArray);
            }

            return maxSubArray;

    }
