
// Deque is latest and modern way of implementing stack 

// Valid Parenthesi means..  (( )) valid, ({[ ]}) valid
// you may be tempted to use two pointer approach but it fails when input is (){}[].... hahaha shocked.. so lets go with another way
// Input is ({[]})
// Now for every input for the correct order ( -> insert ) in stack
                                            {  -> insert } in stack
                                            [  -> insert ] in stack
// now ({[ -> you have ]}) in stack. If you combine the both ({[ ]}) resembles the input... because from stack the access would be last inserted like inverted unlike array
// Now as string traversal goes in ]}) ih this way.. and even stack traversal goes ]}) in this way..
// This way stck becomes the optimal way to solve this. Like this problem exactly made for the stack usage example or to understand stack working.
// So for every closed brakcet we encounter in string.. we pop up from stack and compare it as both should same to form a correct comb.. if they are not.. input was wrong
// ([}) -> ( [-> we insert ] ) in stack.. so obviously }) is not equlas to ] } and it fails. and same way
// (){] -> for open ( , ) closed is inserted, for closed ) - popped closed ) from stack fine.
                                              // Now for {, } is inserted in stack and for ] , } is popped up from stack which obvioulsy not a combo
// (())}}.. so in this case... popping up may cause issue.. so if you still get data from string.. but stack becomes empty mean.
                                              // correct combos are closed but excessive closed ones only avaiable.. which is also a not a valid combo
    

                                

Deque<Character> s=new ArrayDeque<>();
        char c;
        for(int i=0;i<S.length();i++)
        {
          c=S.charAt(i);  --> S is String
           
           if(c=='(')
            s.push(')');
            else if(c=='{')
            s.push('}');
            else if(c=='[')
            s.push(']');
            else if(s.isEmpty() || s.pop()!=c )  -> so encoutered closed one.. and pop up from stock which would exactly match.. else or stack empty return false
                return false;
        }
        return s.isEmpty();
