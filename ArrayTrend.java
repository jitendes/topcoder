//beating the stock market
public int maxProfit(int[] prices) {
        int max=0;
        int sum=0;
        for (int i=1; i<prices.length;i++){
            sum=prices[i]-prices[i-1]+Math.max(sum,0); //finds the largest increasing range
            max=Math.max(sum,max);
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
