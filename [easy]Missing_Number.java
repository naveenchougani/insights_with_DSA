// in the array of numbers length = n, array will contain the number upto the range of n  from 0
// But one will be missed from the range of 0 to n.. you have to give that number. Here they explicitly said range is upto n
// So easy way was sum of first natural numbers and remove the sum of array number.. rest would be the one missing ..

  public int missingNumber(int[] nums) {
        int sum=0,missingNumber=0,n=nums.length;
        for(var num:nums) {
            sum=sum+num;
        }
         long sumOfFirstN = (long)(n*(n+1))/2;   // if n would be so large addition of that may break out of int range so future proof
    
        return (int)sumOfFirstN - sum;  // convert it into as function requires int
    }

// Another way was using XOR where obviously 
// values in the array are between 0 to n
// indices are 0 to n-1,
// add the length also in the starting of XOR of them as n
// Hence this would cancel out if any of the number has been repeated twice and not repeated would be availabe

public int missingNumber(int[] nums) {
        int missed = nums.length;   // why to add nums.length because in the array value range is upto nums.length, so this might present or absent so 
                                    // if you wont add this.. result might differ like instead of n, result migh be 0 as values and indices are
                                      // cancelled out each other in the XOR
  
        for(int i=0;i<nums.length;i++) {
            missed = missed ^ i ^ nums[i];
        }

        return missed;

    }
