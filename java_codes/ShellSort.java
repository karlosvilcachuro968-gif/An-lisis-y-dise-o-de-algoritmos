package vilcal.ordenamientos;

import java.util.Comparator;

public class ShellSort {

    // Método genérico que permite ordenar cualquier tipo de objeto
    public static <T> void ordenar(T[] arreglo, Comparator<? super T> comparador) {
        int n = arreglo.length;

        // Inicia con un salto grande y lo reduce
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = arreglo[i];
                int j;

                // Mueve elementos del subarreglo que están a "gap" posiciones
                for (j = i; j >= gap && comparador.compare(arreglo[j - gap], temp) > 0; j -= gap) {
                    arreglo[j] = arreglo[j - gap];
                }

                arreglo[j] = temp;
            }
        }
    }

    // Método para probar ShellSort con enteros
    public static void main(String[] args) {
        Integer[] numeros = {45, 12, 78, 23, 56, 89, 1, 9, 50};

        System.out.println("Antes de ordenar:");
        for (int n : numeros) System.out.print(n + " ");

        ordenar(numeros, Integer::compareTo);

        System.out.println("\n\nDespués de ordenar con Shell Sort:");
        for (int n : numeros) System.out.print(n + " ");
    }
}