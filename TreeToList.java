/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    //in place convert to link list structure
    public void flatten(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Stack<TreeNode> s = new Stack<TreeNode>();
        if (root==null) return;
        s.add(root);
        TreeNode pre = null;
        while(!s.isEmpty()){
            TreeNode cur = s.pop();
            if (cur.right!=null) s.push(cur.right);
            if (cur.left!=null) s.push(cur.left);
            cur.left = null; //remove left child
            if (pre!=null) pre.right = cur; //add to pre's right
            pre = cur; //pre points to the newly modified node which only has right child
        }
    }
    
    