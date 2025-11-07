package vilcal.recursividad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BusquedaRecursivaVehiculo {

    public static void main(String[] args) {
        String rutaArchivo = "src/data/vehiculos.txt"; // ✅ Ruta corregida
        System.out.println("Intentando leer el archivo: " + new File(rutaArchivo).getAbsolutePath());
        String[] vehiculos = cargarVehiculos(rutaArchivo);

        if (vehiculos == null || vehiculos.length == 0) {
            System.out.println("⚠️ No hay vehículos cargados. Verifica el archivo vehiculos.txt");
            return;
        }

        System.out.println("Vehículos cargados:");
        for (String v : vehiculos) {
            System.out.println("- " + v);
        }

        String placaBuscada = "ABC-123"; // puedes cambiar esta placa
        int indice = buscarVehiculoRecursivo(vehiculos, placaBuscada, 0);

        if (indice != -1) {
            System.out.println("✅ Vehículo encontrado: " + vehiculos[indice]);
        } else {
            System.out.println("❌ Vehículo con placa " + placaBuscada + " no encontrado.");
        }
    }

    // Método para leer los vehículos del archivo
    public static String[] cargarVehiculos(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            return br.lines().toArray(String[]::new);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    // Método recursivo para buscar un vehículo por su placa
    public static int buscarVehiculoRecursivo(String[] vehiculos, String placa, int indice) {
        if (indice >= vehiculos.length) {
            return -1; // caso base: no encontrado
        }

        if (vehiculos[indice].contains(placa)) {
            return indice; // caso base: encontrado
        }

        return buscarVehiculoRecursivo(vehiculos, placa, indice + 1); // llamada recursiva
    }
}