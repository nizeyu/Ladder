public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int max = 0;
        boolean single = false;
        
        int[] map = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        
        for (int i = 0; i < map.length; i++) {
            max += map[i] / 2 * 2;
            
            if (map[i] % 2 == 1 && !single) {
                max += 1;
                single = true;
            }
        }
        
        return max;
    }
}
