    //easy version, treated like one array
    public boolean searchMatrix(int[][] matrix, int target) { 
        int l=0, r=matrix.length*matrix[0].length-1; 
        while (l<=r){ 
            int mid=(l+r)/2; 
            if (target==matrix[mid/matrix[0].length][mid%matrix[0].length]) 
                return true; 
            if (target<matrix[mid/matrix[0].length][mid%matrix[0].length]){ 
                r=mid-1; 
            }else{ 
                l=mid+1; 
            } 
        } 
        return false; 
    }
    
    //easy version, two binary search
    public boolean searchMatrix(int[][] matrix, int target) { 
        int lrow=0, rrow=matrix.length-1; 
        while (lrow<rrow){ //guarantee to stop at l=0 or r=length-1 
            int mid=(lrow+rrow)/2; 
            if (target==matrix[mid][0]) return true; 
            if (target<matrix[mid][0]){ 
                rrow=mid-1; //if target<all values, lrow=rrow=first row 
            } else if (target<matrix[mid+1][0]){ 
                lrow=mid; //find the row 
                break; 
            } else { 
                lrow=mid+1; //if target>all values, lrow=rrow=last row 
            } 
        } 
        int lcol=0, rcol=matrix[lrow].length-1; 
        while (lcol<=rcol){ 
            int mid=(lcol+rcol)/2; 
            if (target==matrix[lrow][mid]) return true; 
            if (target<matrix[lrow][mid]){ 
                rcol=mid-1; 
            }else{ 
                lcol=mid+1; 
            } 
        } 
        return false; 
    }
    
    //hard version, search from right upper corner
    public boolean searchMatrix(int[][] matrix, int matrix ){ 
        int row=0; 
        int col=matrix[0].length-1; //start point
        while (row<matrix.length && col>=0){ 
            if (matrix[row][col]==elem) return ture; 
            if (matrix[row][col]> elem{ 
                col--; 
            else 
                row++; 
            } 
        } 
        return false; 
    } 
    
