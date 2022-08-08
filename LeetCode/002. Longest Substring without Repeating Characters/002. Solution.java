/**
 * Problem: 3. Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int max = 0;
        HashSet<Character> chars = new HashSet();
        for(int p=0 ;p<s.length() - max; p++){
            chars.add(s.charAt(p));
            boolean isFound = false;
            for(int c = p+1; c<s.length() && !isFound; c++)
                isFound = !chars.add(s.charAt(c));

            max = Math.max(chars.size(), max);
            chars.clear();
        }

        return max;
    }
}
