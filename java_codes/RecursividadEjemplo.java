package vilcal.recursividad;

public class RecursividadEjemplo {

    // Función recursiva: calcula el factorial de un número
    public static int factorial(int n) {
        if (n == 0 || n == 1) {  // Caso base
            return 1;
        } else {                 // Llamada recursiva
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int numero = 5;
        int resultado = factorial(numero);

        System.out.println("El factorial de " + numero + " es: " + resultado);
    }
}