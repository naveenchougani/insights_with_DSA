// String might contain non alpha numeric numbers

        if(s.length()==1 || s.length()==0) 
            return true;

        String ls = s.toLowerCase(); - -----------> to make sure everythign is compared easily
        System.out.println(ls);

        int i=0,j=ls.length()-1;

        while(i<j) {   --> breaks when j goes to i, or i goes to j , preicely.. when they meet at same index
        
        while(!Character.isLetterOrDigit(ls.charAt(i)) && i<j) ---------> while condition is if string contains "     a"
        {                                                      ---> so it can accomodate multiple sequentical non alpha numeric digits 
            i++;                                               --> and i < j would make sure to avoid arrayIndexOutOfBoudns("    ") and try to stay 
         }                                                    ---> max to max at j position as j is at last position max
          
        while(!Character.isLetterOrDigit(ls.charAt(j)) && j>i) -------> while condition is if string contains "a       " and similar to top
        {                                                          ----> and same j>i would make sure to avoid arrayIndexOutOfBounds("    ")
            j--;                                                   ----> and it can stop j at max to max of first position at i
         }
        if( ls.charAt(i)!=ls.charAt(j) ) {   
            return false;
         }
         i++;
         j--;
        }
        return true;
