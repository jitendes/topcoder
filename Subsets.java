//recursive
    ArrayList<ArrayList<Integer>> result; 
    public ArrayList<ArrayList<Integer>> subsets(int[] S) { 
        Arrays.sort(S); 
        result=new ArrayList<ArrayList<Integer>>(); 
        ArrayList<Integer> subset=new ArrayList<Integer>(); 
        dfsRecursive(S,0,new ArrayList<Integer>()); 
        return result; 
    } 
     
    public void dfsRecursive(int[] array, int ptr, ArrayList<Integer> tmp){ 
        if (ptr==array.length){ 
            result.add((ArrayList<Integer>)tmp.clone()); 
            return; 
        } 
        // no cur 
        dfsRecursive(array, ptr+1, tmp); 
        // add cur 
        tmp.add(array[ptr]); 
        dfsRecursive(array, ptr+1, tmp); 
        tmp.remove(tmp.size()-1); //to reuse the tmp 
    } 
    
//iterative
  public ArrayList<ArrayList<Integer>> subsets(int[] S) { 
        Arrays.sort(S); 
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(); 
        int len = (int) Math.pow(2, S.length); 
        for (int i = 0; i < len; i++) { 
            ArrayList<Integer> subset = new ArrayList<Integer>(); 
            for (int j = 0; j < S.length; j++) 
                if ((i >> j & 1) == 1) 
                    subset.add(S[j]); 
            ret.add(subset); 
        }    
        return ret; 
  } 
