/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
//normal level order, queue
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root==null) return new ArrayList<ArrayList<Integer>>();
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);//mark level
        ArrayList<Integer> level=new ArrayList<Integer>();
        while (q.size()!=0){
            TreeNode cur=q.remove();
            if (cur!=null){
                level.add(cur.val);
                if (cur.left!=null)
                    q.add(cur.left);
                if (cur.right!=null)
                    q.add(cur.right);
            }else if (q.size()!=0){
                //reach the end of a level
                result.add((ArrayList<Integer>)level.clone());
                level=new ArrayList<Integer>();
                q.add(cur);
                continue;
               
            }
        }
        result.add((ArrayList<Integer>)level.clone());//last round
        return result;
    }
    
//reversed level order, recursive
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        int h = height(root); 
        for (int i =0 ;i<h; i++){ 
            result.add(new ArrayList<Integer>()); 
        } 
        levelOrderHelper(root, h-1, result); 
        return result; 
    } 
     
    public void levelOrderHelper(TreeNode root, int level, ArrayList<ArrayList<Integer>> result){ 
        if (root ==null) return; 
        result.get(level).add(root.val); 
        levelOrderHelper(root.left, level-1, result); 
        levelOrderHelper(root.right, level-1, result); 
    } 
     
    public int height(TreeNode root){  
        if(root == null) return 0;  
        return 1+Math.max(height(root.left), height(root.right)); 
    }
    
}
