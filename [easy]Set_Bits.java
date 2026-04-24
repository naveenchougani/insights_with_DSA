// Set Bits means the no of 1's in Binary Representation of Digit
// For example 7 = 0111 -> means we have to return 3.. But how can we do that..
// We have a trick for that   while(n!=0) { n & (n-1); count++; } return count;
// " & " single AND operator is a bitwsie operator. When you perform it with a number n and n-1 .. ie 7 and 6
// It almost flips the right side 1 digit to the 0. And it needs that many iterations.. for 7.. it goes for 3 iterationst to make number 0.
Binary of 7 is 0 1 1 1.
Deletion 1 (Rightmost bit at index 0)
n = 7 (0111)
n-1 = 6 (0110)
n & (n-1) 
 0111 & 0110 = 0110
---------------------------
Deletion 2 (New rightmost bit at index 1)
n = 6 (0110)
n-1 = 5 (0101)
n & (n-1) 
 0110 & 0101 = 0100
---------------------------
Deletion 3 (Last remaining bit at index 2)
n = 4 (0100)
n-1 = 3 (0011)
n & (n-1) 
 0100 & 0011 = 0000
----------------------------------
  It happens because each time you perform n & (n-1), the total number of 1s in the binary string decreases by exactly one.
If a number has three 1s (like the number 7, which is 0111), the loop is essentially "deleting" the 1s one at a time. It takes 3 deletions to reach zero.
----------- Code -----------------

  public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n)
     {
        int count=0;

        while(n!=0)
        {
            n=n&(n-1);
            count++;
        }
        return count;
    }
}

------------------------------------
