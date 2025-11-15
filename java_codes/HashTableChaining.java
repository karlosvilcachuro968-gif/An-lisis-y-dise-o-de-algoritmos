package vilcal.estructuras;

import java.util.LinkedList;
import vilcal.modelo.Vehiculo;

public class HashTableChaining {
    private LinkedList<Vehiculo>[] tabla;
    private int capacidad;

    @SuppressWarnings("unchecked")
    public HashTableChaining(int capacidad) {
        this.capacidad = capacidad;
        tabla = new LinkedList[capacidad];
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    private int hash(String placa) {
        return Math.abs(placa.hashCode()) % capacidad;
    }

    public void insertar(Vehiculo v) {
        int index = hash(v.getPlaca());
        tabla[index].add(v);
    }

    public Vehiculo buscar(String placa) {
        int index = hash(placa);
        for (Vehiculo v : tabla[index]) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }
}