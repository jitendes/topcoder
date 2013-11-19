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

//bst to double linked list
//http://cslibrary.stanford.edu/109/TreeListRecursion.html 
class TreeList { 
    /* 
     helper function -- given two list nodes, join them 
     together so the second immediately follow the first. 
     Sets the .next of the first and the .previous of the second. 
    */ 
    public static void join(Node a, Node b) { 
        a.large = b; 
        b.small = a; 
    } 
     
    /* 
     helper function -- given two circular doubly linked 
     lists, append them and return the new list. 
    */ 
    public static Node append(Node a, Node b) { 
        // if either is null, return the other 
        if (a==null) return(b); 
        if (b==null) return(a); 
         
        // find the last node in each using the .previous pointer 
        Node aLast = a.small; 
        Node bLast = b.small; 
         
        // join the two together to make it connected and circular 
        join(aLast, b); 
        join(bLast, a); 
         
        return(a); 
    } 
 
     
    /* 
     --Recursion-- 
     Given an ordered binary tree, recursively change it into 
     a circular doubly linked list which is returned. 
    */ 
    public static Node treeToList(Node root) { 
        // base case: empty tree -> empty list 
        if (root==null) return(null); 
         
        // Do it separately in pre-order, make left a list and make right a list, then turn root to a self pointed list 
        Node aList = treeToList(root.small); 
        Node bList = treeToList(root.large);       
        //Make the single root node into a list length=1 
        root.small = root; 
        root.large = root;
         
        aList = append(aList, root); 
        aList = append(aList, bList);         
        return(aList); 
    } 
} 
