    public int sqrtLong(int x) {
        long l=0;
        long r=x/4;
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
        return l*l<=x?(int)l:(int)l-1; 
    }
    
    
