public class MergeSort {

    /**
     *  seperates array a into 2 smaller arrays then calls itself recursively on them before
     *  calling 'merge' on them and then returning the resulting array.
     */
    public static int[] mergeSort (int a[]){
        if (a.length == 1){
            return a;
        }
        int n = a.length;

        int left[] = new int[(n+1)/2];
        for (int i = 0; i<(n+1)/2; i++){
            left[i] = a[i];
        }

        int right[] = new int[n/2];
        for (int i = ((n+1)/2); i<n; i++){
            right[i-((n+1)/2)] = a[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    /**
     * merges the ints in 2 arrays together in order from smallest to biggest.
     */
    public static int[] merge (int left[], int right[]){
        int result[] = new int[left.length + right.length];
        int r = 0;
        int l = 0;
        int m = 0;
        while (left.length>l && right.length>r){
            if (left[l] > right[r]){
                result[m]=right[r];
                m++;
                r++;
            }
            else{
                result[m]=left[l];
                l++;
                m++;
            }
        }
        while(left.length>l){
            result[m]=left[l];
            l++;
            m++;
        }
        while(right.length>r){
            result[m]=right[r];
            m++;
            r++;
        }
        return result;
    }
}
