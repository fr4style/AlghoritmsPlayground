/**
 * https://leetcode.com/problems/reverse-integer/
 */
class Solution {
    public int reverse(int x) {
        if(x == Integer.MAX_VALUE || x == Integer.MIN_VALUE || x == 0) return 0;


       boolean isPositive = x > 0;

       if(!isPositive) x *= -1;

       int result = 0;
       int y = x;
       int exp = 0;
       int nextUnit = 0;
       while(true){
           nextUnit = y % 10;
           y = y / 10;

           if(result > (Integer.MAX_VALUE - nextUnit) / 10) return 0;

           result = result*10 + nextUnit;

           if(y == 0) return (isPositive)  ? result : result * -1;

           exp++;
       }
   }
}
