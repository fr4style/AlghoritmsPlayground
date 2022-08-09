/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1) return s;
        if(numRows == s.length()) return s;

        boolean isGoingDown = true;

        StringBuilder[] container = buildStringBuilder(numRows);
        int currentIndex = 0;

        for(int i = 0; i< s.length(); i++){
            container[currentIndex].append(s.charAt(i));

            if(isGoingDown && currentIndex == numRows-1) isGoingDown = false;
            else if(!isGoingDown && currentIndex == 0) isGoingDown = true;

            currentIndex = currentIndex + ((isGoingDown)? 1 : -1);
        }

        for(int i = 1; i<numRows; i++)
            container[0].append(container[i].toString());

        return container[0].toString();

    }

    private StringBuilder[] buildStringBuilder(int size){
        StringBuilder[] result = new StringBuilder[size];
        for(int i=0; i<size; i++){
            result[i] = new StringBuilder();
        }
        return result;
    }

}
