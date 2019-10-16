package easy;

public class MergeSortArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //similar to insertion sort
        int size = -1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (nums1[i] != 0) {
                size = i;
                break;
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            int item = nums2[i];
            int j;
            for (j = size + 1; j > 0; j--) {
                if (nums1[j - 1] <= item) {
                    break;
                }
                nums1[j] = nums1[j - 1];
            }
            nums1[j] = item;
            size++;
        }
    }
}
