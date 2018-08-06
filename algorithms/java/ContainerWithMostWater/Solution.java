class Solution {
    public int maxArea(int[] height) {
        int maxmiumArea = 0;
        int i = 0, j = height.length - 1;
        
        while (i < j) {
            maxmiumArea = Math.max(maxmiumArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxmiumArea;
    }
}