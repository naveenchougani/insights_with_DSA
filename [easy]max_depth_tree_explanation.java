// In trees, below are the two golden rules
   1. The recursive stops only at the very first conditon regularly we write i..e, if(root==null) return null; i mean non valid nodes would always execute this line
   2. the actual return statemetns after recursive calls search(root.left), search(root.right) , return root or return 1 or something. This is by actual valid nodes

// And in the trees. it moslty suits for recursive approach by the nature. Now this code expects you to find the height of the tree. 

// And for trees, recursive is supposed to write initially for the very smalles part of all valid combos of tree and it would eventually works perfectly for the rest of the tree

// Assume we A-> left B, right C. This is the smallest valid combo of full binary tree

// Now we know when we reach   if(root==null) return null... Fine but here we want height of the tree where we want value of int or integer
// So..  in object null is nothing and to consider in its values.. we return 0; i.e, if(root==null) return 0;
// Now this respective call can be made by left null node or right null node of a valid root node. 
//And this Valid root node might be at right side or left side of its parent root node.
so let us frame this code piece of code
A->left(B), right(C) -> A -> calls(B)---> calls(null)-> return 0 (left) ---> returns 1+Math.max(0,0)--> return 1+0--> return 1; (left of A)
                                          calss(null)-> return 0 (right)
                             calls(C)---> same the above resutl --> return 1 (right of A)
                            return 1+Math.max(1,1)--> return 2;
    so 2 is the valid answer.
    The below code is working for the very small aspect fo the binary. Let us verify for left or right having higher then other to verify the same wresult

        A
      /  \
    B      C
          /  \
          D  E

A --> (left) - calls(B) --> (left) - calls(null) ---> return 0;
                            (right) - calls(null)---> return 0;
                            return 1+(0,0)----------> return 1;


      (right) - calls(C)--> (left) - calls(D) --> (left) - calls(null) -> return 0;
                                                  (right) - calls(null) -> return 0;
                                                  -> return 1+(0,0) -> return 1;
                            (right) - calls(E) --> (left) - calls(null) -> return 0;
                                                  (right) - calls(null) -> return 0;
                                                  -> return 1+(0,0) -> return 1;
                            return 1+(1,1)---------------------------> return 2;

     return 1+(1,2)---> 1+2-------------------------------------------> return 3; YEs its working for bigger also
                

//* If you dont write Math.max(left, right)--> you are about send only 1 value irrespective how many calls we make
// if you write return 1+left+right -------> we are going to find number of nodes available in the tree..
// if you write return 1+Math.max(left, right)--> you are saying pickup the bigger height from your sub treess
// Because as it is binary tree.. for a root node.. you have only 1 height of left and 1 height of right or zero nodes.
// Literally you will have only one node towards left or right node... and that number becomes the height of you immediate child.
// That is why when we evict a valid node.. we always send 1 value along with its child nodes..
// That is how it works. The main catch here is the number of node becomes the height of its left subtree or right subtree

      ///////////****** CODE ******//////////////

     int maxDepth(node root) {
        if(root == null )  // when yo have reached last node's left and right whose nodes are null its like you have hit the last wall
          return 0;   // here its height is 0.. because there is no node with heigth 0 

       int left = maxDepth(root.left); --> // you must traverse each left node..  By default every call must return a value to it.. it is int so store it
       int right = maxDepth(root.right);--> // you must traverse each right node.. same for right...

     return 1+Math.max(left, right) --> // now when you reach this state.. it means you have completed above left and right nodes means.. you are a valid node.
                                     // for every valid node we are supposed to send 1 value along with max(left tree, right tree value)
                                     // sometimes either of the tree might of the more levels so to tackle that we have this condition

                                   // By the least,, when last node would give value as 1+max(0,0) as its left and right nodes null,, they returns 0
                                 // If it has parent nodes then they capture value from its child stacks and compute the value and the very first root node would give the vlau
    }
     

        
