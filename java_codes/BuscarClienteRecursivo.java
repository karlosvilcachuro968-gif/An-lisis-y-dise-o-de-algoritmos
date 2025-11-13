package vilcal.recursividad;

public class BuscarClienteRecursivo {

    public static Cliente buscarCliente(Cliente[] clientes, String rucBuscado, int indice) {
        if (indice >= clientes.length) {
            return null;
        }

        if (clientes[indice].getRuc().equals(rucBuscado)) {
            return clientes[indice];
        }

        return buscarCliente(clientes, rucBuscado, indice + 1);
    }

    // main igual (usar getNombre() para imprimir)
}