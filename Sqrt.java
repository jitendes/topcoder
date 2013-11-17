    public int sqrtLong(int x) {
        long l=0;
        long r=x/4+1;
        while(l<=r){
            long mid = (l+r)/2;
            long s = mid*mid;
            if(s==x)
                return (int)mid;
            if(s<x)
                l = mid+1;
            else
                r = mid-1;
        }
        return (int)(l+r)/2; 
    }
    
    public int sqrtInt(int x) {
        int l=0;
        int r=x/4<(int)Math.sqrt(Integer.MAX_VALUE)? x/4+1:(int)Math.sqrt(Integer.MAX_VALUE);
        while(l<=r){
            int mid = (l+r)/2;
            int s = mid*mid;
            if(s==x)
                return mid;
            if(s<x)
                l = mid+1;
            else
                r = mid-1;
        }
        return (l+r)/2; 
    }
    
    
