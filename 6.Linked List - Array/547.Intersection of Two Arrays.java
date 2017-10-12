//Self
public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        
        if (nums1.length == 0 || nums2.length == 0 ) {
            return new int[]{};
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        
        int[] result = new int[res.size()];
        int j = 0;
        for (int s : res) {
            result[j++] = s; 
        }
        
        return result;
    }
};
