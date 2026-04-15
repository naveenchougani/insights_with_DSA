// In the recursion you have to remember very two things.
// Return statement is what actually stops the further processing and that value is been cascaded to the parents stacks waiting for childs execution complete
// So that value returned by the child is being substituted in the parents stack further cascaded to its parent
// So in the invert tree.. specifically we have used return statement to pop up the stack but we are not using anywhere the childs returned values.
// But in the same tree we are supposed to send False if nodes do not match...
// Also if we follow invert tree approach but by capturing the values
boolean left = isSameTree(p.left, q.left);   // Call 1
boolean right = isSameTree(p.right, q.right); // Call 2
return left && right;     

the problem is even if false is captured at any middle of the node.. it keeps on traversing the whole tree which is not expensive...

so how to solve this issue.

first return true if both are nodes are null stating.. we reached end of the sub trees

second return false becuase if control comes here.. above if is not satisfied
     so check if both values are not correct so the processig stops here

final return left tree && right tree... (if left tree is false.. by the nature of short ciruit operator, right side tree is avoided)
                                        ( if left and right were evaluated to true final true values is captured)

public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null && q==null)
            return true;    ---->     Very Very imp This statement is saying.. you have traversed the whole substree of (left/right)
                            ----->   And found 0 false matches. Hence substitue true in all of the parent nodes stack frames 

            if(p==null || q==null || p.val!=q.val)
            return false;   ---------------->         this return statement is a stoppage of a recursive function with false value saying we foudn a false match
                            ----------------> as the current function will not execute the below return with recursive calls, so further processing stopped

            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);  -----> this return statement would use && operator and send the evalution to the parent stack
              
        
    }
