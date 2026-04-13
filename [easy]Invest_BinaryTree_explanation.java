// Binary tree is having two nodes or 0 nodes.
// Mostly solved by recurisve calls
// But how does recursive call resumes to executes its next instruction
// If a recursive call started in the method execution.. at that time , at that specific line
// Program counter would remember that line and creates new stack fram with details at that snapshot
// Now somewhere that stack frame would get popped out by "return" statement.
// Now Program counter would resume where it stopped and follows the next steps
// The same behaviour is executed in the subsequent recursive calls.
// That is how recursive works and best suited for Tree problems.

// While inverting binary tree , binary tree is also object with left and right fields of its own type.
// The main logic is when you swap left and right.. the child nodes attached them also comes towards left and right.
// And this logic has to be followed for all of its left and right nodes.
// So eventally somewhere the recursive has to stop right.. we will stop it when the nodes becomes null..


public TreeNode invertTree(TreeNode root) {

        if(root==null) ------> specifically for the child nodes which do not have further child nodes.. 
            return null;     -----> this would eventually pops up the recustive stack frame for that node
        
        TreeNode temp = root.left; -> swapping would what makes the binary tree to become invert
        root.left=root.right;
        root.right=temp;
        
        invertTree(root.left);  ---> now when this executes, this line is saved in parents stack so, after this frame gets
                                      popped out.. the parent execution would go to the next (root.rigth) line
                                      --> this pops out due to return null statement
        invertTree(root.right); -----> same.. here also with help of PC stored in the parents stack which is callin this recursive call
                                  ----> then once this popped out due to return null statemtn the next root statement is executed
        return root;       ---> this would eventually returns the root which has executed the above instructions
                          ---> this statement helps to pop out the the very parent of the above nodes stack frame
                          ---> and gives the parent frames to executed if exist
    }


    4 has 2, 7 and 2 has 3,4 and 7 has 5,6
    now the stack frame looks like
      -> invert(4)
      -> 2,7 became 7 , 2
      -> invert(7 root.left) called and stack fram looks like this
        invert(7)
        invert(4)
        and it follows like this
          
        invert(4)-> it has no childes and it gets popped out
        invert(7) -> the above one is its child left , so this frame pc remebers that right and last return root has to exeucte
        invert(4)

        now 

          invert(3)-> it has 0 nodes and return root would pops out this frame
          invert(7)-> and at last this stack would return by root ie, 7 and 
          invert(4)-> next this frame would remember now it has to go for right child

          thats it
