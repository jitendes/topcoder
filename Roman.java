import java.util.*;
public class Solution {
// integer to roman
    TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    public void setup() {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }
    public String intToRoman(int num) {
        setup();
        StringBuilder ret=new StringBuilder();
        for (Integer i: map.descendingKeySet()){
            while (num>=i){
                ret.append(map.get(i));
                num-=i;
            }
        }
        return ret.toString();
    }
    
//Roman to integer
    Map<Character, Integer> romans = new HashMap<Character, Integer>();
    public int romanToInt(String s) {
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        char[] cs = s.toCharArray();
        int num = 0;
        for (int i = 0; i < cs.length; i++) {
            int tmp = romans.get(cs[i]);
            if (i == cs.length - 1 || romans.get(cs[i + 1]) <= tmp) {
                num += tmp;
            } else {
                num -= tmp;
            }
        }
        return num;
    }
}
