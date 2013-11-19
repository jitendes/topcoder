public class Solution {
   	 public int ladderLength(String start, String end, HashSet<String> dict) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        Set<String> visited = new HashSet<String>();
	        Queue<String> q = new LinkedList<String>();
	        //bfs
	        q.add(start);
	        q.add(null);
	        //visited.add(start);
	        int len = 1;
	        String cur= null;
	        while (q.size()!=1){
	            cur = q.remove();
	            if (cur==null){
	                q.add(null);
	                len++;
	                continue;
	            }
	            if (oneStepAway(cur,end))
	                return len+1;
	            Iterator<String> it = dict.iterator();
	            while(it.hasNext()){
	                String s = it.next();
	                if (!visited.contains(s) && oneStepAway(cur, s)){
	                    q.add(s);
	                    visited.add(s);
	                }
	            }
	        }
	        if (oneStepAway(cur,end)) return len+1;
	        return 0;
	    }
	    public boolean oneStepAway(String s, String e){
	        if (s.length()!=e.length()) return false;
	        int diff = 0;
	        for (int i =0; i<s.length();i++){
	            if (s.charAt(i) != e.charAt(i))
	            diff++;
	            if (diff>1){
	                return false;
	            }
	        }
	        return diff == 1;
	    }

//faster way
	public int ladderLength(String start, String end,
			HashSet<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		Queue<String> q = new LinkedList<String>();
		// modified bfs
		q.add(start);
		q.add(null);
		int len = 1;
		String cur = null;
		while (q.size() != 1) {
			cur = q.remove();
			if (cur == null) {
				q.add(null);
				len++;
				continue;
			}
			for (int i = 0; i < cur.length(); i++) {
				char[] tmp = cur.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {					
					tmp[i] = c;
					String s = new String(tmp);
					if (s.equals(end))
						return len + 1;
					if (dict.contains(s)) {
						q.add(s);
						dict.remove(s);						
					}					
				}
			}

		}
		return 0;
	}
}
