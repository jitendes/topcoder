//beating the stock market, one trans
public int maxProfit(int[] prices) {
        int max=0;
        int sum=0;
        for (int i=1; i<prices.length;i++){
            sum=prices[i]-prices[i-1]+Math.max(sum,0); //finds the largest increasing range
            max=Math.max(sum,max);
        }
        return max;
}

//beating the stck market, many trans
public int maxProfit(int[] prices) {
        int sum=0;
        for (int i=1; i<prices.length; i++){
            sum+=prices[i]>prices[i-1]?prices[i]-prices[i-1]:0; //find all monotone increasing range
        }
        return sum;
}

//only two trans
public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int[] left=new int[prices.length];
        int[] right=new int[prices.length];
        left[0]=right[prices.length-1]=0;
        
        int sum=0;
        for (int i=1;i<prices.length;i++){
            sum=prices[i]-prices[i-1]+Math.max(sum,0); //accumulated profit, if <0, start again
            left[i]=Math.max(left[i-1], sum); //max profit before i
        }
        sum=0;
        for (int i=prices.length-2;i>=0;i--){
            sum=prices[i+1]-prices[i]+Math.max(sum,0);
            right[i]=Math.max(right[i+1], sum); //max profit after i
        }
        int max=0;
        for (int i=0;i<prices.length;i++){
            max=Math.max(max, left[i]+right[i]);
        }
        return max;
}

//max continous subarray sum
public int maxSubArray(int[] A){
        int local=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            local=local>=0?local+A[i]:A[i]; //derivative of discrete sequence
            max=Math.max(max,local);
        }
        return max;
}
