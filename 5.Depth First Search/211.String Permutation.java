// Self
public class Solution {
    /*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null) {
            return false;
        } else if (B == null) {
            return false;
        }
        
        int[] hash = new int[256];
        for (int i = 0; i < A.length(); i++) {
            hash[A.charAt(i)]++;
        }
        
        for (int i = 0; i < B.length(); i++) {
            int b = B.charAt(i);
            
            if (hash[b] <= 0) {
                return false;
            }
            hash[b]--;
        }
        
        for (int i = 0; i < 256; i++) {
            if (hash[i] > 0) {
                return false;
            }
        }
        
        return true;
    }
};
