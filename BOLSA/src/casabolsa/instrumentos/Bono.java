package casabolsa.instrumentos;

import casabolsa.modelo.Moneda;

public class Bono extends InstrumentoFinanciero {
	private double interes;
	private double valorNominal;
	private Moneda moneda;

	public Bono(String codigo, String nombre, String emisor,  double interes, Moneda moneda, double valorNominal) {
		super(codigo, nombre, emisor);
		setInteres(interes);
		setValorNominal(valorNominal);
		setMoneda(moneda);
	}
	
	public Moneda getMoneda() {
		return moneda;
	}

	private void setMoneda(Moneda moneda) {
		if (moneda == null) {
			throw new RuntimeException("Moneda invalida");
		}
		this.moneda = moneda;
	}

	private void setValorNominal(double valorNominal) {
		if (valorNominal <= 0) {
			throw new RuntimeException("Vaor nomnimal invalido");
		}
		this.valorNominal = valorNominal;
	}

	private void setInteres(double interes) {
		if (interes < 0) {
			throw new RuntimeException("Interes invalido");
		}
		this.interes = interes;
	}

	@Override
	public double obtenerCotizacion() {
		 
		
		return (((valorNominal *  interes) / 100) * moneda.obtenerCotizacion());
	}

}
