/**
 * https://leetcode.com/problems/container-with-most-water/submissions/
 */
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxVolume = 0;
        int currentVolume = 0;

        while(i < j){
            currentVolume = Math.min(height[i], height[j]) * (j-i);
            if(currentVolume > maxVolume){
                maxVolume = currentVolume;
            }
        if(height[i]<height[j]) i++;
            else j--;
        }

        return maxVolume;
    }
}
