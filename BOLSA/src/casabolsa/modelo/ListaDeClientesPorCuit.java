package casabolsa.modelo;

import casa.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaDeClientesPorCuit extends ListaOrdenadaNodos<String, Cliente> {

	@Override
	public int compare(Cliente cliente1, Cliente cliente2) {
		return cliente1.getCuit().compareTo(cliente2.getCuit());
	}

	@Override
	public int compareByKey(String clave, Cliente cliente) {
	          return clave.compareTo(cliente.getCuit());
	}

}

