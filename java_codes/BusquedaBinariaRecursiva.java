package vilcal.recursividad;

public class BusquedaBinariaRecursiva {

    // Búsqueda binaria recursiva
    public static int busquedaBinaria(int[] arr, int inicio, int fin, int objetivo) {
        if (inicio > fin) { // caso base: no encontrado
            return -1;
        }

        int medio = (inicio + fin) / 2;

        if (arr[medio] == objetivo) {
            return medio; // encontrado
        } else if (objetivo < arr[medio]) {
            // Buscar en la mitad izquierda
            return busquedaBinaria(arr, inicio, medio - 1, objetivo);
        } else {
            // Buscar en la mitad derecha
            return busquedaBinaria(arr, medio + 1, fin, objetivo);
        }
    }

    public static void main(String[] args) {
        int[] datos = {3, 7, 10, 15, 20, 25, 30}; // ARREGLO ORDENADO
        int objetivo = 15;

        int posicion = busquedaBinaria(datos, 0, datos.length - 1, objetivo);

        if (posicion != -1) {
            System.out.println("Elemento " + objetivo + " encontrado en la posición: " + posicion);
        } else {
            System.out.println("Elemento " + objetivo + " no encontrado.");
        }
    }
}