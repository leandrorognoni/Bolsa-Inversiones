package casabolsa.modelo;

import casabolsa.instrumentos.Cotizable;

public class Moneda implements Cotizable {

	private double valorCotizacion;

	public Moneda() {
		this(1);
	}
	
	public Moneda(double valorCotizacion) {
		setValorCotizacion(valorCotizacion);
	}
	
	private void setValorCotizacion(double valor) {
		if (valor <= 0) {
			throw new RuntimeException("Valor inválido para la cotiacion de la Moneda");
		}
		valorCotizacion = valor;
	}

	@Override
	public double obtenerCotizacion() {
		return valorCotizacion;
	}

}
