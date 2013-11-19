public class Solution {
    String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    ArrayList<String> ret;
    public ArrayList<String> letterCombinations(String digits) {
        ret=new ArrayList<String>();
        if (digits.equals("")){ 
            ret.add("");  
            return ret;  
        } 
        dfsRecursive(digits,0,new StringBuilder());
        return ret;
    }
    
    public void dfsRecursive(String s, int ptr, StringBuilder letters){
        if (ptr==s.length()){
            ret.add(letters.toString());
            return;
        }
        int number=s.charAt(ptr)-'0';
        String candidate=keypad[number];
        for (int i=0;i<candidate.length();i++){
            letters.append(candidate.charAt(i)); //must pick up one
            dfsRecursive(s, ptr+1, letters);
            letters.deleteCharAt(letters.length()-1); //unmark the current
        }
    }
}
