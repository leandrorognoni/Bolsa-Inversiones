package casabolsa.test;

import casabolsa.modelo.CasaDeBolsa;


public class Test {
    public static void main(String[] args) {
        CasaDeBolsa casaDeBolsa = new CasaDeBolsa();

        System.out.println("-------------Casa De Bolsa------------- \n");
        
        System.out.println("-------------Inicializando Clientes---------");
        inicializarClientes(casaDeBolsa);

        casaDeBolsa.imprimirListaPrecios();

        System.out.println("-------------Procesando Ordenes-------------");
        inicializarOrdenes(casaDeBolsa);
        casaDeBolsa.procesarOrdenesDeClientes();

        casaDeBolsa.imprimirHistorialDelCliente();
    }

    private static void generarOrden(CasaDeBolsa casaDeBolsa, int cantidad, String codigoInstrumento, String idCliente, boolean esVenta) {
        try {
            casaDeBolsa.cargarOrden(cantidad, codigoInstrumento, idCliente, esVenta);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void inicializarClientes(CasaDeBolsa casaDeBolsa) {
    
        casaDeBolsa.altaCliente("13-32654897-3", "UnaEmpresa S.A.", 30000);
        casaDeBolsa.altaCliente("18-31754887-3", "Maria A. Redondo - FICTICIO", 15000);
        casaDeBolsa.altaCliente("10-28123756-4", "Jose Luis M. - FICTICIO", 1000000);
        casaDeBolsa.altaCliente("14-46852741-7", "Mario Perez & Co - FICTICIO.", 60000);
    	//Ej invalido , se mostrarà por pantalla como razon social invalida por estar vacia 
        //casaDeBolsa.altaCliente("14-92654897-8", "", 30000);
    }

    private static void inicializarOrdenes(CasaDeBolsa casaDeBolsa) {
        generarOrden(casaDeBolsa, 5, "AL30", "13-32654897-3", true);
        generarOrden(casaDeBolsa, 2000, "SE", "13-32654897-3", false);
        generarOrden(casaDeBolsa, 1, "YPFD", "18-31754887-3", false);
        generarOrden(casaDeBolsa, 5, "AL30", "10-28123756-4", false);
        generarOrden(casaDeBolsa, 1, "YPFD", "14-46852741-7", true);
        generarOrden(casaDeBolsa, 5, "GP30", "18-31754887-3", false);
        generarOrden(casaDeBolsa, 300, "SE", "14-46852741-7", false);
        //S mostrara por pantalla que es invalida la generacion de la orden por datos invalidos (ejemplo BACD, ya que no existe)
        //generarOrden(casaDeBolsa, 3, "BACD", "10-28123756-4", false);
    }

}
