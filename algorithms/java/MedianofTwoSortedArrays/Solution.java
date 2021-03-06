public class Solution {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;

            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0, iMax = m;
        int halfLen = (m + n + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i < iMax && B[j - 1] > A[i]) {
                iMin++;
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax--;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }

                if (((m + n) & 1) == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(A[i], B[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }
}