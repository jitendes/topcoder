//is BST
public boolean isBSTHelper(TreeNode root, int leftmax, int rightmin){ 
        if (root==null) return true; 
        if (leftmax>=root.val || rightmin<=root.val) return false; 
        return isBSTHelper(root.left, leftmax, root.val) && isBSTHelper(root.right, root.val, rightmin); 
} 

//isBalanced
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.right) - height(root.left)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }

//height, depth
    public int height(TreeNode root){
        if(root == null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    
//Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root==null) return true;
        return isMirror(root, root);
    }
    
    public boolean isMirror(TreeNode l, TreeNode r){
        if (l==null && r==null) return true;
        if (l==null||r==null) return false;
        return l.val==r.val && isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }
    
//if two trees are the same
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        if (p.val!=q.val) return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }

//diameter of a tree
/*
The diameter of a tree T is the largest of the following quantities: 
* the diameter of T’s left subtree 
* the diameter of T’s right subtree 
* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
*/
int diameter(struct node * tree) 
{ 
   /* base case where tree is empty */ 
   if (tree == 0) 
     return 0; 
  
  /* get the height of left and right sub-trees */ 
  int lheight = height(tree->left); 
  int rheight = height(tree->right); 
  
  /* get the diameter of left and right sub-trees */ 
  int ldiameter = diameter(tree->left); 
  int rdiameter = diameter(tree->right); 
  
  /* Return max of following three 
   1) Diameter of left subtree 
   2) Diameter of right subtree 
   3) Height of left subtree + height of right subtree + 1 */ 
  return max(lheight + rheight + 1, max(ldiameter, rdiameter)); 
} 
