package vilcal.ordenamientos;

public class BubbleSort {

    public static void bubbleSort(int[] arreglo) {
        int n = arreglo.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimización
        }
    }

    public static void mostrar(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}