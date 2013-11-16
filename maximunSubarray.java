public class Solution {
    public int maxSubArray(int[] A){
        int local=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            local=local>=0?local+A[i]:A[i]; //previous local
            max=Math.max(max,local);
        }
        return max;
    }
}