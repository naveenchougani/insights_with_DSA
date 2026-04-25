 public int diameterOfBinaryTree(TreeNode root) {
        edgesOfNode(root);
        return max;
    }

    public int edgesOfNode(TreeNode root){
        if(root == null)
            return 0;

        int left = edgesOfNode(root.left);
        int right = edgesOfNode(root.right);

        // once you have left and right recursion completed now find the diameter of the node
        // Here we just only includes the left and righ height as 1-2-3 here diameter is 2(edges)
        // That is how we are not including the root number.. and correct edges.
        // If you want no of nodes in the diameter of tree.. then we can add left+right+1 that 1 is 
        // current root node.
        max = Math.max(max,left+right);  

        return 1+Math.max(left,right);
    }
