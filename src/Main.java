import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        Main obj = new Main();

        /** Import file 'intBig.txt' */
        File file = new File("intBig.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String string;
        List<Integer> intList = new ArrayList<Integer>();

        /** store ints from file in intList */
        while ((string = br.readLine()) != null) {
            intList.add(Integer.parseInt(string));
        }

        /** define list to the size of intList */
        int list[] = new int[intList.size()];

        /** Transfer each element from intList to list */
        for (int i = 0; i<intList.size();i++){
            list[i] = intList.get(i);
        }

        String methods[] = {
                "mergeSort",
                "insertionSort",
                "threeWayQuickSort",
                "medianOfThreeQuickSort",
                "quickSortCutoff",
                "quickSort"
                };

        obj.timeSortingAlgorithms(list, methods);

        obj.testInputIncrease(0,30000, 1000);
    }

    /**
     * Checks if the list is sorted
     */
    public boolean isSorted(int a[]){
        for (int i = 0; i < a.length-1; i++){
            if (a[i] > a[i+1]){
                return false;
            }
        }
        return true;
    }

    /**
     * Runs each sorting algorithim in methods on the array 'a'
     * and prints the time each takes to finish
     */
    public void timeSortingAlgorithms(int a[], String methods[]) {
        Main obj = new Main();
        for (int i = 0; i < methods.length; i++){
            int b[] = new int[a.length];

            for (int k=0;k<a.length;k++){
                b[k]=a[k];
            }

            String method = methods[i];

            if (method == "quickSort"){
                Date past = new Date();
                b = QuickSort.quickSort(b,0,b.length-1);
                Date future = new Date();

                if (obj.isSorted(b)) {
                    System.out.println("Quick Sort Time (milliseconds) = " + (future.getTime() - past.getTime()));
                }
                else {
                    System.out.println("Quick Sort Failed To Sort");
                }
                System.out.println("\n");
            }
            else if (method == "quickSortCutoff") {
                Date past = new Date();
                b = Cutoff.quickSortCutoff(b, 0, b.length - 1, 10);
                b = Cutoff.insertionSort(b);
                Date future = new Date();

                if (obj.isSorted(b)) {
                    System.out.println("Quick Sort Cutoff Time (milliseconds) = " + (future.getTime() - past.getTime()));;
                }
                else {
                    System.out.println("Quick Sort Cutoff Failed To Sort");
                }
                System.out.println("\n");
            }
            else if (method == "medianOfThreeQuickSort") {
                Date past = new Date();
                b = MedianOfThree.medianOfThreeQuickSort(b, 0, b.length - 1);
                Date future = new Date();

                if (obj.isSorted(b)) {
                    System.out.println("Median Of Three Quick Sort Time (milliseconds) = " + (future.getTime() - past.getTime()));;
                }
                else {
                    System.out.println("Median Of Three Quick Sort Failed To Sort");
                }
                System.out.println("\n");
            }
            else if (method == "threeWayQuickSort") {
                Date past = new Date();
                ThreeWayQuickSort.threeWayQuickSort(b, 0, b.length - 1);
                Date future = new Date();

                if (obj.isSorted(b)) {
                    System.out.println("Three Way Quick Sort Time (milliseconds) = " + (future.getTime() - past.getTime()));;
                }
                else {
                    System.out.println("Three Way Quick Sort Failed To Sort");
                }
                System.out.println("\n");
            }
            else if (method == "insertionSort") {
                Date past = new Date();
                Cutoff.insertionSort(b);
                Date future = new Date();

                if (obj.isSorted(b)) {
                    System.out.println("Insertion Sort Time (milliseconds) = " + (future.getTime() - past.getTime()));;
                }
                else {
                    System.out.println("Insertion Sort Failed To Sort");
                }
                System.out.println("\n");
            }
            else if (method == "mergeSort") {
                Date past = new Date();
                b = MergeSort.mergeSort(b);
                Date future = new Date();

                if (obj.isSorted(b)) {
                    System.out.println("Merge Sort Time (milliseconds) = " + (future.getTime() - past.getTime()));
                    ;
                } else {
                    System.out.println("Merge Sort Failed To Sort");
                }
                System.out.println("\n");
            }
            else{
                System.out.println("Method " + method + " not recognised");
            }
            System.out.println("\n");
        }
    }

    /**
     * generates lists for each value between p and r with given iterator i, also
     * sorts each list with 'median of three' and prints the time taken
     */
    public void testInputIncrease(int p, int n, int i){
        for (int k = p; k <= n; k += i){
            if (k > 0) {
                int a[] = GenerateInput.generate(k);

                Date past = new Date();
                a = MedianOfThree.medianOfThreeQuickSort(a, 0, a.length - 1);
                Date future = new Date();

                if (isSorted(a)){
                    System.out.println("Length " + k + " was ran in " + (future.getTime() - past.getTime()) + "ms");
                }
                else{
                    System.out.println("Failed to sort at " + k);
                    k = n+1;
                }
            }
        }
    }
}