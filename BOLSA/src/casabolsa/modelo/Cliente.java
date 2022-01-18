package casabolsa.modelo;

import casa.tdas.implementaciones.PilaNodos;
import casabolsa.tdas.interfaces.Pila;

public class Cliente {
	private final static String MSJ_CUIT_INVALIDO = "CUIT Invalido";
	private final static String MSJ_RSOC_INVALIDA = "Razon Social Invalida";

	private String cuit;
	private String razonSocial;
	private double saldo;
	private Pila <String> historial;


	public Cliente(String cuit, String razonSocial, double saldoInicial) {
		this.historial = new PilaNodos<>();
		setCuit(cuit);
		inicializarCuenta(saldoInicial);
		setRazonSocial(razonSocial);

		 
	}

	private void agregarEntradaEnHistorial(String mensaje, TipoHistorial tipo) {
		historial.push(mensaje + " Tipo: " + tipo + " CUIT: " + cuit + " Saldo: " + saldo);
	}

	public String getCuit() {
		return cuit;
	}

	/**
	 * Se tiene que mostrar en pantalla el historia completo del Cliente.
	 * Ejemplo: ------------- Mostrando historial de: Mario Perez Creacion de la
	 * cuenta con 60000.0$ de saldo Tipo: FONDEO_INICIAL Dni: 6852741 Saldo:
	 * 60000.0 Se proceso la orden. Codigo: YPFD - BONO USD 2030 L.A.(Gobierno
	 * Nacional Argentino) Tipo: VENTA Dni: 6852741 Saldo: 61200.0 Se proceso la
	 * orden. Codigo: SE - Superfondo Equilibrado(Santander Rio) Tipo: COMPRA
	 * Dni: 6852741 Saldo: 60958.5510105
	 */
	public void imprimirHistorial() {
	   System.out.println("\n ------------- Mostrando historial de " + this.razonSocial );
	   Pila <String> aux = new PilaNodos<>();
	   String auxString = null;
	   
	   while(!historial.isEmpty()) {
		   aux.push(historial.pop());
		 
	   }
	   
	   while(!aux.isEmpty()) {
		   auxString = aux.pop();
		   System.out.println(auxString);
		   historial.push(auxString);
		   
	   }
	   
	   
	}

	private void inicializarCuenta(double saldoInicial) {
		saldo = saldoInicial;
	 
		agregarEntradaEnHistorial("Creacion de la cuenta con " + saldoInicial + "$ de saldo",
				TipoHistorial.FONDEO_INICIAL);
	}

	/**
	 * El cliente es responsable de procesar sus ordenes Si la orden es de
	 * compra tiene que restar a su saldo el precio de la Orden al Cliente, si
	 * es menor a 0 se va a registrar en el historial un error de compra Si la
	 * orden es de venta se va a sumar el saldo el precio de la Orden al
	 * Cliente, si el saldo del cliente es menor que el precio de la orden se va
	 * a registrar un error de venta. En los dos casos si se realizo la
	 * operacion tambien tiene que registrarse en el historial
	 * 
	 * @param orden
	 */
	public void procesarOrden(Orden orden) {
		TipoHistorial tipo;

		double precio = orden.obtenerCotizacion();

		if (orden.isCompra()) {
			double calculo = saldo - precio;
			if (calculo < 0) {
				tipo = TipoHistorial.ERROR_EN_COMPRA;
			} else {
				tipo = TipoHistorial.COMPRA;
				saldo = calculo;
			}
		} else {
			tipo = TipoHistorial.VENTA;
			saldo = saldo + precio;
		}

		agregarEntradaEnHistorial(orden.obtenerDatosParaHistorial(), tipo);
	}

	private void setCuit(String cuit) {
		stringInvalido(cuit, MSJ_CUIT_INVALIDO);
		this.cuit = cuit;
	}

	private void setRazonSocial(String razonSocial) {
		stringInvalido(razonSocial, MSJ_RSOC_INVALIDA);
		this.razonSocial = razonSocial;
	}

	private void stringInvalido(String valor, String mensaje) {
		if (valor == null || valor.isEmpty()) {
			throw new RuntimeException(mensaje);
		}
	}
}
