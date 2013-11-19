//inorder
public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> r = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        Boolean done = false;
        
        while (!done){
            if (cur!=null){
                s.push(cur);
                cur = cur.left;
            }else{
                if (s.isEmpty()){
                    done = true;
                }else{
                    cur = s.pop();
                    r.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return r;
}

//preorder traversal
public ArrayList<Integer> preorderTraversal(TreeNode root) { 
        ArrayList<Integer> ret=new ArrayList<Integer>(); 
        if (root==null) return ret; 
        Stack<TreeNode> s=new Stack<TreeNode>(); 
        s.add(root); 
        while (!s.isEmpty()){ 
            TreeNode cur=s.pop(); 
            ret.add(cur.val); 
            if (cur.right!=null) //right on stack first because we want left to be processed first! 
                s.push(cur.right); 
            if (cur.left!=null) 
                s.push(cur.left); 
        } 
        return ret; 
} 

//postorder
public ArrayList<Integer> postorderTraversal(TreeNode root) { 
        LinkedList<Integer> ret=new LinkedList<Integer>(); 
        if (root==null) return new ArrayList<Integer>(ret); 
        Stack<TreeNode> s=new Stack<TreeNode>(); 
        s.add(root); 
        while (!s.isEmpty()){ 
            TreeNode cur=s.pop(); 
            ret.addFirst(cur.val); //stored in reversed order 
            if (cur.left!=null) 
                s.push(cur.left); 
            if (cur.right!=null) 
                s.push(cur.right); 
        } 
        return new ArrayList<Integer>(ret); 
} 
