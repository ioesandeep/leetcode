package hard;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[a.length+b.length];
        //merge the arrays and then find the median
        while(i < a.length || j < b.length) {
            if(i >= a.length && j < b.length){
                while(j < b.length){
                    res[k++] = b[j++];
                }
                continue;
            }
            if(j >= b.length && i < a.length){
                while(i < a.length){
                    res[k++] = a[i++];
                }
                continue;
            }
            while(j < b.length && i < a.length && a[i] <= b[j]){
                res[k++] = a[i++];
            }
            while(j < b.length && i < a.length && a[i] > b[j]){
                res[k++] = b[j++];
            }
        }

        if(res.length % 2 == 1) {
            return res[res.length/2];
        }
        int mid = res.length / 2;
        return (double) (res[mid-1] + res[mid])/2;
    }
}
