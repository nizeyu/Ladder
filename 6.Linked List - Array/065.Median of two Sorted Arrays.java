public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(0, A, 0, B, len / 2 + 1);
        } else {
            return (findKth(0, A, 0, B, len / 2) + findKth(0, A, 0, B, len / 2 + 1)) / 2.0;
        }
    }
    
    private int findKth(int start_a, int[] A, int start_b, int[] B, int k) {
        if (start_a >= A.length) {
            return B[start_b+k-1];
        }
        
        if (start_b >= B.length) {
            return A[start_a+k-1];
        }
        
        if (k == 1) {
            return Math.min(A[start_a], B[start_b]);
        }
        
        int value_a = start_a+k/2-1 < A.length ? A[start_a+k/2-1] : Integer.MAX_VALUE;
        int value_b = start_b+k/2-1 < B.length ? B[start_b+k/2-1] : Integer.MAX_VALUE;
        
        if (value_a > value_b) {
            return findKth(start_a, A, start_b+k/2, B, k-k/2);
        } else {
            return findKth(start_a+k/2, A, start_b, B, k-k/2);
        }
    }
}
