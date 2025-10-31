package vilcal.busquedas;

import vilcal.modelo.Vehiculo;
import vilcal.estructuras.HashTableChaining;
import java.util.*;

/**
 * Demostración de cinco tipos de búsqueda:
 * 1️⃣ Búsqueda lineal
 * 2️⃣ Búsqueda binaria
 * 3️⃣ Búsqueda secuencial con bloques
 * 4️⃣ Búsqueda con índice
 * 5️⃣ Búsqueda por transformación de claves (hash)
 */
public class MainBusquedas {

    public static void main(String[] args) {

        // === 1. Crear lista de vehículos (simulando carga de datos) ===
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("AAA-111", "Volvo FH", 15, true));
        vehiculos.add(new Vehiculo("BBB-222", "Scania R500", 18, true));
        vehiculos.add(new Vehiculo("CCC-333", "Mercedes Actros", 20, true));
        vehiculos.add(new Vehiculo("DDD-444", "Iveco Stralis", 16, true));
        vehiculos.add(new Vehiculo("EEE-555", "Freightliner", 14, true));
        vehiculos.add(new Vehiculo("FFF-666", "Hino 500", 12, true));

        // === 2. Ordenar lista por capacidad (requerido para algunas búsquedas) ===
        vehiculos.sort(Comparator.comparingInt(Vehiculo::getCapacidad));

        System.out.println("=== LISTA DE VEHÍCULOS ORDENADOS POR CAPACIDAD ===");
        for (Vehiculo v : vehiculos)
            System.out.println(v.getPlaca() + " - Capacidad: " + v.getCapacidad());

        // === 2.5. Búsquedas adicionales (Lineal y Binaria) ===
        int capacidadBuscada = 16;
        System.out.println("\n🔍 Buscando capacidad = " + capacidadBuscada);

        // === Búsqueda LINEAL ===
        long inicio = System.nanoTime();
        Vehiculo encontradoLineal = BusquedaLinealBinaria.busquedaLineal(vehiculos, capacidadBuscada);
        long fin = System.nanoTime();
        mostrarResultado("Búsqueda Lineal", encontradoLineal, inicio, fin);

        // === Búsqueda BINARIA ===
        inicio = System.nanoTime();
        Vehiculo encontradoBinaria = BusquedaLinealBinaria.busquedaBinaria(vehiculos, capacidadBuscada);
        fin = System.nanoTime();
        mostrarResultado("Búsqueda Binaria", encontradoBinaria, inicio, fin);

        // === 3. Búsqueda con BLOQUES ===
        inicio = System.nanoTime();
        Vehiculo encontrado1 = BusquedaBloques.buscarPorCapacidad(vehiculos, capacidadBuscada);
        fin = System.nanoTime();
        mostrarResultado("Búsqueda con Bloques", encontrado1, inicio, fin);

        // === 4. Búsqueda con ÍNDICE ===
        BusquedaConIndice buscadorIndice = new BusquedaConIndice(vehiculos, 2);
        inicio = System.nanoTime();
        Vehiculo encontrado2 = buscadorIndice.buscarPorCapacidad(capacidadBuscada);
        fin = System.nanoTime();
        mostrarResultado("Búsqueda con Índice", encontrado2, inicio, fin);

        // === 5. Búsqueda por TRANSFORMACIÓN DE CLAVES (HASH) ===
        HashTableChaining hash = new HashTableChaining(10);
        for (Vehiculo v : vehiculos) {
            hash.insertar(v);
        }
        inicio = System.nanoTime();
        Vehiculo encontrado3 = hash.buscar("DDD-444");
        fin = System.nanoTime();
        mostrarResultado("Búsqueda por Hash", encontrado3, inicio, fin);

        System.out.println("\n✅ Comparación completada.");
    }

    // Método auxiliar para mostrar los resultados en consola
    private static void mostrarResultado(String tipo, Vehiculo v, long inicio, long fin) {
        System.out.println("\n📘 " + tipo);
        if (v != null)
            System.out.println("Resultado: " + v.getPlaca() + " (" + v.getModelo() + ")");
        else
            System.out.println("No se encontró el vehículo.");
        System.out.println("Tiempo: " + (fin - inicio) + " ns");
    }
}