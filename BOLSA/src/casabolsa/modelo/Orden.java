package casabolsa.modelo;

import casabolsa.instrumentos.Cotizable;
import casabolsa.instrumentos.InstrumentoFinanciero;

public class Orden implements Cotizable {
    private final int cantidad;
    private final InstrumentoFinanciero instrumentoFinanciero;
    private final Cliente cliente;
    private final boolean esCompra;

    public Orden(int cantidad, InstrumentoFinanciero instrumentoFinanciero, Cliente cliente, boolean esCompra) {
    	if (cantidad < 1 || instrumentoFinanciero == null || cliente == null) {
    		throw new RuntimeException("Datos invalidos en la creacion de la orden");
    	}
        this.cantidad = cantidad;
        this.instrumentoFinanciero = instrumentoFinanciero;
        this.cliente = cliente;
        this.esCompra = esCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public InstrumentoFinanciero getInstrumentoFinanciero() {
        return instrumentoFinanciero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isCompra() {
        return !esCompra;
    }

	public String obtenerDatosParaHistorial() {
		return "Codigo: " + instrumentoFinanciero.getCodigo() + " - " + instrumentoFinanciero.getNombre() + " (" + instrumentoFinanciero.getEmisor() + ")";
	}

	@Override
	public double obtenerCotizacion() {

		return instrumentoFinanciero.obtenerCotizacion() * cantidad ;
	}
}
