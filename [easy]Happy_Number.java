// Happy Number means whatever digit.. ie. > 1 would, we have to square them.. and that number digits have to be squared and added.. so on
// In that process when total value becomes 1 it is Happy Number. Else It would end in a loop.
// When Number becomes 1 or 7.. they end up in 1.. rest everything ends up in an infitnite loop and becomes 4 during their cycle
// So we have an helper function  which takes the number and try to add the squares of their digits..
// We will verify if that number is 1 or 4.. eighter of the case we will skip the while loop and return n==1.. so if n=4 false, else n=1 means true

class Solution {
    public boolean isHappy(int n) {
       
       if(n<=0 || n==2 || n==4)
        return false;

        while(n!=1 && n!=2 && n!=4) {  // when the digits become 1 (true) or 4 (false) break the loop
            n = calSquaresAndAdd(n);
        }

        return n==1;
       
    }
    public int calSquaresAndAdd(int n){ // This returns the sum of the squres of the individual digits of the number
        int sum=0;
        while(n>0){
            int num = n%10;
            sum = sum+ (num*num);
            n= n/10;
        }
        return sum;
    }
}
