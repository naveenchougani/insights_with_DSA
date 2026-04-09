See for anagrams... assume two strings s and t are to be compared
first in Java,  
  'a' = 97 --> 'a'-'a' = 0 , 'a'-97 = 0
  'A' = 65 --> 'A'-'A' = 0,  'A'-65 = 0
  ( because arithmetic operations between characters always arithmetic )

Now even if string contains 100's of characters.. int[26] woudl be sufficient to store them
Also during the comparing.. you no need to traverse all of the string.. because it may contain 1000's of characters..
But stored int[26] would be sufficeint to traverse


int[] ch=new int[26];

        if(s.length()!=t.length())
            return false;
        char c,d;
        for(int i=0;i<s.length();i++){
             c=s.charAt(i);
             d=t.charAt(i);
             ch[c-'a']++;
             ch[d-'a']--;
        }
                       ========================================
                        for(int i=0;i<s.length();i++){  --> this part can be replaced with below
                            if(ch[s.charAt(i)-'a']!=0)
                                return false;
                        }
                      ========================================
        for(int i=0;i<26;i++){
            if(ch[i]!=0)
                return false;
        }
        return true;
