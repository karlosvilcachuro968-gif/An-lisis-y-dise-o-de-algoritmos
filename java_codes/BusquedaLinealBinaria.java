package vilcal.busquedas;

import vilcal.modelo.Vehiculo;
import java.util.List;

public class BusquedaLinealBinaria {

    // 🔹 Búsqueda lineal
    public static Vehiculo busquedaLineal(List<Vehiculo> lista, int capacidad) {
        for (Vehiculo v : lista) {
            if (v.getCapacidad() == capacidad) {
                return v;
            }
        }
        return null;
    }

    // 🔹 Búsqueda binaria (requiere lista ordenada)
    public static Vehiculo busquedaBinaria(List<Vehiculo> lista, int capacidad) {
        int inicio = 0;
        int fin = lista.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Vehiculo v = lista.get(medio);

            if (v.getCapacidad() == capacidad) {
                return v;
            } else if (v.getCapacidad() < capacidad) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return null;
    }
}