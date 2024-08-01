public class Merge {
    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = nums1.length - 1;
        int zeros = nums1.length - m;
        --n;
        --m;
        while (zeros > 0 &&n >= 0) {
            if (nums1[m] < nums2[n]) {
                nums1[x] = nums2[n];
                --n;
            } else {
                nums1[x] = nums1[m];
                --m;
            }
            --x;
            --zeros;
        }
    }

    public static void main(String[] args) {
        int num1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        merge(num1, 3, nums2, 3);
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
        System.out.println(num1);
    }
}
