public class ThreeWayQuickSort {

    /**
     * swaps the values in indexes i and j inside array a.
     */
    public static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * sorts the array into 3 partitions smallest ints at the start biggest at the end
     * and ints equal to the pivot in the middle. It then returns the 2 indexes at either end
     * of the middle.
     */
    public static int[] threeWayPartition(int a[], int p, int r){
        if (r - p <= 1) {
            if (a[r] < a[p])
                swap(a, r, p);
            int re[] = {p, r};
            return re;
        }
        int mid = p;
        int pivot = a[r];
        while (mid <= r) {
            if (a[mid] < pivot) {
                swap(a, p, mid);
                mid++;
                p++;
            }
            else if (a[mid] == pivot) {
                mid++;
            }
            else if (a[mid] > pivot) {
                swap(a, mid, r);
                r--;
            }
        }
        int re[] = {p-1,mid};
        return re;
    }

    /**
     * This method gets the threeWayPartition to sort the middle of the list out then,
     * calls its self recursively on either side of the middle
     */
    public static void threeWayQuickSort(int a[], int p, int r){
        if (p >= r){
            return;
        }
        int re[] = threeWayPartition(a, p, r);
        int i = re[0];
        int j = re[1];
        threeWayQuickSort(a, p, i);
        threeWayQuickSort(a, j, r);
    }
}
