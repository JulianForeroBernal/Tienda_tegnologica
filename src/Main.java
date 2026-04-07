import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        List<Cliente> clientes = new java.util.ArrayList<>();
        int opcion;
        do {
            String name;
            int id;
            int valorCompra;
            int numeroCompras;
            int cantidadProductos;
            System.out.println("""
                    1. Registrar cliente regulas
                    2. Registrar cliente frecuente
                    3. Registrar cliente mayorista
                    4. Buscar cliente por documento
                    5. Mostrar todos los clientes
                    6. Mostrar clientes por tipo
                    7. Calcular total compras
                    8. Mostrar compras altas
                    9. mostrar cliente con mayor pago
                    0. salir
                    """);
            opcion = scan.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("nombre del cliente: ");
                    name = scan.next();
                    System.out.println("ID del cliente: ");
                    id = scan.nextInt();
                    System.out.println("Valor compra: ");
                    valorCompra = scan.nextInt();
                    ClienteRegular cR = new ClienteRegular(name, id, valorCompra);
                    clientes.add(cR);
                    break;
                case 2:
                    System.out.println("nombre del cliente: ");
                    name = scan.next();
                    System.out.println("ID del cliente: ");
                    id = scan.nextInt();
                    System.out.println("Valor compra: ");
                    valorCompra = scan.nextInt();
                    System.out.println("numero Compras: ");
                    numeroCompras = scan.nextInt();
                    ClienteFrecuente cF = new ClienteFrecuente(name, id, valorCompra, numeroCompras);
                    clientes.add(cF);
                    break;
                case 3:
                    System.out.println("nombre del cliente: ");
                    name = scan.next();
                    System.out.println("ID del cliente: ");
                    id = scan.nextInt();
                    System.out.println("Valor compra: ");
                    valorCompra = scan.nextInt();
                    System.out.println("cantidad productos: ");
                    cantidadProductos = scan.nextInt();
                    ClienteMayorista cM = new ClienteMayorista(name, id, valorCompra, cantidadProductos);
                    clientes.add(cM);
                    break;
                case 4:
                    int busqueda;
                    boolean encontrado = false;
                    Cliente cliente = null;
                    System.out.println("Documento del cliente: ");
                    busqueda = scan.nextInt();
                    for (Cliente c : clientes){
                        if( c.id == busqueda){
                            encontrado = true;
                            cliente = c;
                        }
                    }
                    if (encontrado){
                        System.out.println(cliente.imprimirResumen());
                        boolean salir = true;
                        do {
                            int numero;
                            System.out.println("""
                                    1. Calcular costo final
                                    2. Aplicar descuento
                                    3. Aplicar aumento
                                    4. Mostrar datos
                                    0. Salir
                                    """);
                            numero = scan.nextInt();
                            int porcentaje;
                            switch (numero){
                                case 1:
                                    cliente.calcularTotalPagar();
                                    System.out.println("costo original: " + cliente.getValorOriginal() +
                                            "\ncosto final: " + cliente.getValorCompra());
                                    break;
                                case 2:
                                    cliente.calcularTotalPagar();
                                    System.out.println("costo actual: " + cliente.getValorCompra());
                                    System.out.println("porcentaje de descuento: ");
                                    porcentaje = scan.nextInt();
                                    cliente.descontar(porcentaje);
                                    System.out.println("se aplico un descuento del: " + porcentaje + "% al costo de la compra\n costo actual: " + cliente.getValorCompra());
                                    System.out.println("tenga en cuenta que calcular de nuevo el valor de la compra resetea los descuentos y aumentos aplicados manualmente");
                                    break;
                                case 3:
                                    cliente.calcularTotalPagar();
                                    System.out.println("costo actual: " + cliente.getValorCompra());
                                    System.out.println("porcentaje de aumento: ");
                                    porcentaje = scan.nextInt();
                                    cliente.aumentar(porcentaje);
                                    System.out.println("se aplico un aumento del: " + porcentaje + "% al costo de la compra\n costo actual: " + cliente.getValorCompra());
                                    System.out.println("tenga en cuenta que calcular de nuevo el valor de la compra resetea los descuentos y aumentos aplicados manualmente");
                                    break;
                                case 4:
                                    System.out.println(cliente.imprimirResumen());
                                    break;
                                case 0:
                                    salir = false;
                                    break;
                            }
                        }while (!salir);
                    }else {
                        System.out.println("no se encontró ningún cliente con ese ID");
                    }
                    break;
                case 5:
                    for (Cliente c : clientes){
                        System.out.println(c.imprimirResumen());
                    }
                    break;
                case 6:
                    int tipo;
                    boolean salir = false;
                    do {
                        System.out.println("""
                                Tipo de cliente:
                                1. Particular
                                2. Paciente EPS
                                3. Paciente VIP
                                0. Salir de la búsqueda
                               """);
                        tipo = scan.nextInt();
                        switch (tipo) {
                            case 1:
                                for (Cliente c : clientes){
                                    if (c instanceof ClienteRegular){
                                        System.out.println(c.imprimirResumen());
                                    }
                                }
                                break;
                            case 2:
                                for (Cliente c : clientes){
                                    if (c instanceof ClienteFrecuente){
                                        System.out.println(c.imprimirResumen());
                                    }
                                }
                                break;
                            case 3:
                                for (Cliente c : clientes){
                                    if (c instanceof ClienteMayorista){
                                        System.out.println(c.imprimirResumen());
                                    }
                                }
                                break;
                            case 0:
                                salir = true;
                        }
                    }while (!salir);
                    break;
                case 7:
                    for (Cliente c : clientes){
                        c.calcularTotalPagar();
                    }
                    break;
                case 8:
                    for (Cliente c : clientes){
                        if (c.esCompraAlta()){
                            System.out.println(c.imprimirResumen());
                        }
                    }
                    break;
                case 9:
                    Cliente mayor = clientes.getFirst();
                    for (Cliente c : clientes){
                        if (c.getValorCompra() > mayor.getValorCompra()){
                            mayor = c;
                        }
                    }
                    System.out.println(mayor.imprimirResumen());
                    break;
                case 0:
                    break;
            }
        }while (opcion != 0);
    }
}
