package casabolsa.modelo;

import casa.tdas.implementaciones.ListaOrdenadaNodos;
import casabolsa.instrumentos.InstrumentoFinanciero;

public class ListaInstrumentosPorCodigo extends ListaOrdenadaNodos<String, InstrumentoFinanciero> implements Listable {

	@Override
	public int compare(InstrumentoFinanciero dato1, InstrumentoFinanciero dato2) {
		 return dato1.getCodigo().compareTo(dato2.getCodigo());
	}

	@Override
	public int compareByKey(String clave, InstrumentoFinanciero elemento) {
		return clave.compareTo(elemento.getCodigo());
	}

	@Override
	public void listar() {
		System.out.println("\n-------------Lista de Instrumentos-------------");
		for (InstrumentoFinanciero instrumentoFinanciero : this) {
			System.out.println(instrumentoFinanciero.obtenerDatos());
		}
	}
}