// integer to roman
import java.util.*;
public class Solution {
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
}
