public class MedianOfThree {

    /**
     * takes the middle of p and r as the mid value, and then
     * orders the three from smallest to largest with if statements.
     *
     * Calls the medianOfThreePartition method on the array with mid
     * being the pivot.
     *
     * returns resulting array.
     */
    public static int medianOfThree(int a[], int p, int r) {
        int mid = (p + r) / 2;
        if (a[r] < a[p]) {
            swap(a, p, r);
        }
        if (a[mid] < a[p]) {
            swap(a, mid, p);
        }
        if (a[r] < a[mid]) {
            swap(a, r, mid);
        }

        return medianOfThreePartition(a, p, r, mid);

    }

    /**
     * sorts the ints between p and r around the value at pivotIndex and then
     * returns the resulting array.
     */
    public static int medianOfThreePartition(int a[], int p, int r, int pivotIndex) {
        int x = a[pivotIndex];
        int i = p - 1;
        int j = p;
        while (j < r) {
            if (a[j] <= x) {
                i++;
                swap(a, i, j);
            }
            j++;
        }
        return i + 1;
    }

    /**
     * checks that the length of a is enough to call the medianOfThree on.
     * if it is not long enough it will just order the 2 values with an if statement.
     *
     * if it is it will call the medianOfThree method on the array then
     * call itself recursivly on the 2 resulting sides of the array (using the pivot 'q')
     */
    public static int[] medianOfThreeQuickSort(int a[], int p, int r) {
        int length = r + 1 - p;

        if (length >= 3) {

            int q = medianOfThree(a, p, r);

            a = medianOfThreeQuickSort(a, p, q - 1);
            a = medianOfThreeQuickSort(a, q, r);
        } else if (length == 2) {
            if (a[r] < a[p]) {
                swap(a, p, r);
            }
        }
        return a;
    }

    /**
     * swaps the values in indexes i and j inside array a.
     */
    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
