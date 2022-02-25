public class GenerateInput {

    /**
     * swaps the values in indexes i and j inside array a.
     */
    public static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * generates a list of ints up to n in the order that 'median of three' will have the most
     * difficulty with.
     */
    public static int[] generate(int n){
        int result[] = new int[n];
        result[0] = n-1;
        int count = 1;
        for (int i = 1 - (n%2); i < n-2; i += 2){
            result[count] = i;
            count++;
        }

        for (int i = n%2 ; i < n-1; i += 2){
            result[count] = i;
            count++;
        }

        return result;
    }
}
