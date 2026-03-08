public class QuickSortMidPivot {

    public static void main(String[] args) {

        int[] arreglo = {64, 34, 25, 12, 22, 11, 90, 5};

        System.out.println("Arreglo original:");
        printArray(arreglo);

        quickSort(arreglo, 0, arreglo.length - 1);

        System.out.println("\nArreglo ordenado:");
        printArray(arreglo);
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partición usando pivote en la posición media
    public static int partition(int[] arr, int low, int high) {

        int mid = (low + high) / 2;
        int pivot = arr[mid];

        // mover pivote al final para reutilizar lógica
        swap(arr, mid, high);

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArray(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}