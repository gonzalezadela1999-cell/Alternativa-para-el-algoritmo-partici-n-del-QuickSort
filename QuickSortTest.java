import java.util.Random;

public class QuickSortTest {

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000, 20000, 50000};

        System.out.println("Tamaño\tPivot Final (ns)\tPivot Medio (ns)");

        for (int size : sizes) {

            int[] arr1 = generateArray(size);
            int[] arr2 = arr1.clone();

            // QuickSort con pivote final
            long start1 = System.nanoTime();
            QuickSortMidPivot.quickSort(arr1, 0, arr1.length - 1);
            long end1 = System.nanoTime();
            long timeFinal = end1 - start1;

            // QuickSort con pivote medio
            long start2 = System.nanoTime();
            QuickSortMidPivot.quickSort(arr2, 0, arr2.length - 1);
            long end2 = System.nanoTime();
            long timeMiddle = end2 - start2;

            System.out.println(size + "\t" + timeFinal + "\t\t" + timeMiddle);
        }
    }

    // Genera arreglos aleatorios
    public static int[] generateArray(int size) {

        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        return arr;
    }
}