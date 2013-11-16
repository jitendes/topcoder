    public int[] twoSumUnsorted(int[] numbers, int target) { 
        HashMap<Integer, Integer> myMap=new HashMap<Integer, Integer>(); 
        for (int i=0;i<numbers.length;i++){ 
            myMap.put(numbers[i],i); 
        } 
         
        int[] r=new int[2]; 
        for(int i=0;i<numbers.length;i++){ 
            int remain=target-numbers[i]; 
            if (myMap.containsKey(remain) && i!=myMap.get(remain)){ //check when two same number add to target 
                int tmp=i+myMap.get(remain)+2; //1 based 
                r[0]=i<myMap.get(remain)?i+1:myMap.get(remain)+1; //store in order 
                r[1]=tmp-r[0]; 
            } 
        } 
        return r; 
    }
    
    public void twoSumSorted(int[] numbers, int target) { 
        Arrays.sort(numbers);
        int l = 0;
        int r = numbers.length-1; //index
        while (l<r){
            if (numbers[l]+numbers[r]==target){
                //to do
                break;
            }
            if (numbers[l]+numbers[r]<target){
                l++;
            }else{
                r--;
            }
        }
    }
    
    
