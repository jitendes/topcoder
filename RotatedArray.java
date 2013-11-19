public class Solution {
    public int search(int[] A, int target) {
        int l=0;
        int r=A.length-1;
        while (l<=r){
            int mid=(l+r)/2;
            if (A[mid]==target)
                return mid;
            if (A[l]<=A[mid]){ //mid is in shifted range 1
                if (A[l]<=target && target<A[mid])
                    r=mid-1;
                else
                    l=mid+1;
            }else{ //mid is in range 2
                if (A[mid]<target && target<=A[r])
                    l=mid+1;
                else
                    r=mid-1;
            }
        }
        return -1;
    }
}
