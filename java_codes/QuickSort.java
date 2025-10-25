package vilcal.ordenamientos;

public class QuickSort {

    // Método principal de QuickSort
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particion(arr, inicio, fin);
            quickSort(arr, inicio, indicePivote - 1);  // Lado izquierdo
            quickSort(arr, indicePivote + 1, fin);     // Lado derecho
        }
    }

    // Método para dividir el arreglo alrededor de un pivote
    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = (inicio - 1);

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar pivote a su posición correcta
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    // Método auxiliar para mostrar el arreglo
    public static void mostrar(int[] arr) {
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        int[] datos = {34, 7, 23, 32, 5, 62, 15, 28};

        System.out.println("Arreglo original:");
        mostrar(datos);

        quickSort(datos, 0, datos.length - 1);

        System.out.println("Arreglo ordenado (QuickSort):");
        mostrar(datos);
    }
}