public class MediumOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return find(nums1, 0, nums2, 0, len / 2 + 1);
        }
        return (double)(find(nums1, 0, nums2, 0, len / 2)
                + find(nums1, 0, nums2, 0, len / 2 + 1)) / 2;
    }
    private int find(int[] a1, int idx1, int[] a2, int idx2, int target) {
        if (idx1 >= a1.length) {
            return a2[idx2 + target  -1];
        }
        if (idx2 >= a2.length) {
            return a1[idx1 + target - 1];
        }
        if (target == 1) {
            return Math.min(a1[idx1], a2[idx2]);
        }
        int num1 = idx1 + target / 2 - 1 >= a1.length
                ? Integer.MAX_VALUE
                : a1[idx1 + target / 2 - 1];
        int num2 = idx2 + target / 2 - 1 >= a2.length
                ? Integer.MAX_VALUE
                : a2[idx2 + target / 2 - 1];
        return num1 <= num2
                ? find(a1, idx1 + target / 2, a2, idx2, target - target / 2)
                : find(a1, idx1, a2, idx2 + target / 2, target - target / 2);
    }
}
