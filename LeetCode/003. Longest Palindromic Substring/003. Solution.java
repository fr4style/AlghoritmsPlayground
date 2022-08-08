class Solution {
    public String longestPalindrome(String s) {

        int resultSize = s.length();

        int i,j;
        boolean isFound = false;
        while(resultSize > 1){
            for(i=0, j=i+resultSize-1; j<s.length(); i++,j++){
                isFound = checkPalindrome(s, i, j);
                if(isFound) return s.substring(i, j+1);
            }
            resultSize--;
        }
        return s.substring(0,1);
    }

    private boolean checkPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
