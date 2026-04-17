// if [9] then return [1,0] array, if [9,9,9] then return [1,0,0,0], if [1,2,3] then return [1,2,4]
// Simple.. first if you find last index value to be less than 9,, then no need to create new array just increment the last index and return the array

// But last digit can be 9 and also all the digits can be 9
// So the approach would be first we will traverse from last digit
// Each traverse would check if <9 found increment it and return the digit
// Else make the value to be 0 as 9 was found
// When you reach index =0 make the value 1 and return the value
    public int[] plusOne(int[] digits) {
        int size = digits.length-1;

        if(digits[size]<9) {  // if the last digit is less than 9, hence we would increment it and will send
            digits[size]++;
            return digits;
        }

        digits[size]=0;  // if you reach this block, the above if condition is false.. i.e,last digit is 9, so current make it 0
        for(int i=size-1;i>=0;i--){ // now traverse from last second element
            if(digits[i]<=8) {    // anywhere if you found its less than 9.. just increment it and return it
             digits[i]++;
             return digits;
            } 
            digits[i]=0;     // if you reach this block means above if not satified.. i.e, the value is 9 so make it as 0
        }

        int[] newDigits =new int[digits.length+1];  // if you reached this line means,.. in for loop , <=8 is not encountered
                                                      // means all are 9 only. So create new array with digits.length+1 size to accomodate 1
        newDigits[0]=1;  // make first value 1
        return newDigits; // return it
        
    }
