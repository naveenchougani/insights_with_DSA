// See if array contains only one time appeared number along other elements appears twic..
// You can check in linear way.. by doing XOR ..
//  XOR means if bits are Same, then Zero.. if Bits are opposite bits are 1
//  Hence if you XOR a number with 0.. that number zero bits with zero are 0, with 1 bits with 0 are  1, it results in the same number
// But if you XOR a number with the same number, the bits are exactly same and hence XOR would be 0

// Simply XOR would cancels the same number if XORed twice.. But result with Same Number if you XORed with 0 number.

public int singleNumber(int[] nums) 
    {
        int x=0;  // It ensured XOREd with this number is alwasy the number itself
        for(int num:nums)
        {
            x=x^num;
        }
        return x; // would contain only one number that has appeared only once.
    }
