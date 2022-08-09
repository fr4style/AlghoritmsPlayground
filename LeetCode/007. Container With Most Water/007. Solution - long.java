/**
 * https://leetcode.com/problems/container-with-most-water/
 */

 class Solution {
    public int maxArea(int[] height) {
        int m1 = 0;
        int i1 = -1;
        int m2 = 0;
        int i2 = -1;
        int c = 0;
        int localMax = 0;
        for(int i=0; i<height.length; i++){
            c = height[i];
            //Update first and second
            if(c > m1 && c >=m2){
                m2 = m1;
                m1 = c;
                i2 = i1;
                i1 = i;
            //Update second
            }else if(c >= m2){
                m2 = c;
                i2 = i;
            }
        }


        localMax = Math.min(m1, m2) * Math.abs(i1-i2);
        int newM;
        int newI;
        int tmpMax1;
        int tmpMax2;

        while(true){
            newI  = -1;
            newM = 0;
            tmpMax1 = 0;
            tmpMax2 = 0;

            for(int i=0; i<height.length; i++){
                if(i >= Math.min(i1, i2) && i<=Math.max(i1, i2)) continue;
                c = height[i];
                if(c > newM){
                    newM = c;
                    newI = i;
                }
            }

            if(newI < 0) break; //exit
            tmpMax1 = Math.min(m1, newM) * Math.abs(i1 - newI);
            tmpMax2 = Math.min(m2, newM) * Math.abs(i2 - newI);


            if(tmpMax1 > tmpMax2){
                m2 = newM;
                i2 = newI;
                if(localMax < tmpMax1) localMax = tmpMax1;
            }else{
                m1 = newM;
                i1 = newI;
                if(localMax < tmpMax2) localMax = tmpMax2;
            }
        }

        return localMax;
    }
}
