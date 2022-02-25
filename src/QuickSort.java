public class QuickSort {


    /**
     * If length of section is > 1 it calls the partition methode
     * then itself recursively on each side of pivot q.
     */
    public static int[] quickSort(int a[], int p, int r){
        if(p < r){
            int q = partition(a, p, r);
            a = quickSort(a, p, q-1);
            a = quickSort(a, q+1, r);
        }
        return a;
    }

    /**
     * swaps the values in indexes i and j inside array a.
     */
    public static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * takes the last value as the pivot then puts all
     * larger values above and all smaller values below
     * before returning the index of the pivot.
     */
    public static int partition(int a[], int p, int r){
        int x = a[r];
        int i = p - 1;
        int j = p;
        while (j < r) {
            if (a[j] <= x) {
                i++;
                swap(a,i,j);
            }
            j++;
        }
        swap(a,i+1,r);
        return i+1;
    }
}


