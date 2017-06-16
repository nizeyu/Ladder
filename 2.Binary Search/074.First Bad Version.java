/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        
        SVNRepo svn = new SVNRepo();
        
        int l = 0;
		int r = n;
        while(l < r) {
            int mid = l + (r - l) / 2;
            
            if(svn.isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}
