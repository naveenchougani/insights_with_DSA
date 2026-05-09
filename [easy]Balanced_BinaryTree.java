// Binary Tree means atmost two children or nodes for a root node (i.e, 0 or 1 or 2 nodes for a parent that's it)
// Now Balanced Tree means.. the difference between left sub tree and right sub tree should not be greater than 1.
// i.,e left-right or right-left <=1
// So its very simple to find the height of a node by sending math.max(left,right)+1 -> picks the height of max subtree and adds 1 as root height also added
// But the after computing left and right sub trees find the math.abs(left-right) this helps to work at a time of left-right or right-left
// If that breaches like >1 return -1. This has to be propagated to the parent left or right corresponding root nodes

 public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return checkHeight(root)>-1 ;
    }

    public int checkHeight(TreeNode root){
        if(root==null)
            return 0;

        int left = checkHeight(root.left);
        if(left==-1) return -1 //    as math.abs(left-right)>1 send -1 so the above stack might recieve -1 from its sub tree
                                // so check this condition to identify if any skewed tree in its sub trees propagation
      
        int right = checkHeight(root.right);
        if(right==-1) return -1; // similary for the right node or right parent to check in its propagation of children root

        if(Math.abs(left-right)>1)
        return -1;    // if difference between two subtrees is greater than 1, send -1 becoming a non balanced sub tree

        return Math.max(left,right)+1;  // If everything is fine.. send the height of max subtree with nodes height adding up
      }
