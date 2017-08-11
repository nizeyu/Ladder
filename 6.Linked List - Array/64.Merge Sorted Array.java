// Self
class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int r = m + n - 1;
        int a = m - 1;
        int b = n - 1;
        while (r >= 0 && a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[r] = A[a];
                a--;
                r--;
            } else {
                A[r] = B[b];
                b--;
                r--;
            }
        }
        
        while (a >= 0) {
            A[r] = A[a];
            a--;
            r--;
        }
        
        while (b >= 0) {
            A[r] = B[b];
            b--;
            r--;
        }
    }
}
