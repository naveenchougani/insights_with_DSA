--> to get maximum profit or atleast profit
--> we will sell on the day where current sellStock price is always < that currentDay price ---> hence you will get profit on that day
--> Else if your sellStock pric is > that currentDay stock price..  then you will choose that price as your sellStock
  otherwise... you will be in --negatve (hahaha)
  --> Everytime you sell you always track of maximum profit...

int maxProfit = 0;
     int sellStock = prices[0];

     for(int i=1;i<prices.length;i++){
        if(sellStock<prices[i]) {
            int profit = prices[i]-sellStock;
            maxProfit= profit>maxProfit?profit:maxProfit;
        } else {
            sellStock=prices[i];
        }
     }
     return maxProfit;
