public class Cutoff {

    /**
     * runs similarly to the QuickSort.quickSort method but includes if statments to check that
     * we have not yet reached the set cutoff 'k'.
     */
    public static int[] quickSortCutoff(int a[],int p, int r, int k){
        if(p < r){
            int q = QuickSort.partition(a, p, r);
            if ((q-1) - p > k) {a = quickSortCutoff(a, p, q-1, k);}

            if (r - (q+1) > k) {a = quickSortCutoff(a, q+1, r, k);}
        }
        return a;
    }

    /**
     * for each int it checks that the ints behind are smaller, if not
     * the int will be moved back until the ints behind are smaller resulting
     * in a sorted array.
     */
    public static int[] insertionSort(int a[]){
        for (int i = 0; i<a.length; i++){
            int k = a[i];
            int j = i - 1;

            while(j>=0 && k<a[j]){
                a[j+1] = a[j];
                j = j - 1;
            }
            a[j+1] = k;
        }
        return a;
    }
}
