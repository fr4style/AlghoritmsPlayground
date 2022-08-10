/**
 * https://leetcode.com/problems/roman-to-integer/
 */
class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int current = 0;
        int max = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++){
            current = getValueFromChar(s.charAt(i));
            if(current <= max){
                max = current;
            }else{
                total = total - 2 * getValueFromChar(s.charAt(i-1));
            }
            
            total += current;
        }
        return total;
    }

    public int getValueFromChar(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        return 0;

    }
}
