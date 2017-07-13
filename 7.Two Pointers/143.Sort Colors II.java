class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        
        rainbowSort(0, colors.length - 1, 1, k, colors);
    }
    
    private void rainbowSort(int left, int right, int colorFrom, int colorTo, int[] colors) {
        if (colorFrom == colorTo) {
            return;
        }
        
        if (left >= right) {
            return;
        }
        
        int colorMid = (colorFrom + colorTo) / 2;
        int l = left;
        int r = right;
        while (l <= r) {
            while (l <= r && colors[l] <= colorMid) {
                l++;
            }
            
            while (l <= r && colors[r] > colorMid) {
                r--;
            }
            
            if (l <= r) {
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;
                
                l++;
                r--;
            }
        }
        
        rainbowSort(left, r, colorFrom, colorMid, colors);
        rainbowSort(l, right, colorMid + 1, colorTo, colors);
    }
}
