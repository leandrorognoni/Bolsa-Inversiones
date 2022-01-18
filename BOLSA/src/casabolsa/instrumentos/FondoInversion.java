package casabolsa.instrumentos;

import casabolsa.modelo.ListaInstrumentosPorCodigo;

public class FondoInversion extends InstrumentoFinanciero {

	private int nroCuotaPartes;
	private ListaInstrumentosPorCodigo instrumentos;

	public FondoInversion(String codigo, String nombre, String emisor, int nroCuotaPartes) {
		super(codigo, nombre, emisor);
		this.nroCuotaPartes = nroCuotaPartes;
		this.instrumentos = new ListaInstrumentosPorCodigo();
	}

	public void agregarInstrumento(InstrumentoFinanciero instrumentoFinanciero) {
		instrumentos.add(instrumentoFinanciero);
	}

	@Override
	public double obtenerCotizacion() { 
		
		/*
		ListaInstrumentosPorCodigo aux = new ListaInstrumentosPorCodigo();
		InstrumentoFinanciero instru = null;
		double sumaTotal = 0;
		
		
		while(!instrumentos.isEmpty()) {
			instru = instrumentos.removeAt(0);
			sumaTotal += instru.obtenerCotizacion();
			aux.add(instru);
		}
		
		if(!aux.isEmpty()) {	
			instru = aux.removeAt(0);
			instrumentos.add(instru);
		}
		
		sumaTotal = sumaTotal / this.nroCuotaPartes;
		
		return sumaTotal;
		
		*/
		double sumaTotal = 0;
		for(InstrumentoFinanciero instru : instrumentos) {
			sumaTotal += instru.obtenerCotizacion();
		}
		
        sumaTotal = sumaTotal / this.nroCuotaPartes;
		
		return sumaTotal;
		
	}

}
