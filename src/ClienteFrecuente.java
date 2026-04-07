public class ClienteFrecuente extends Cliente{
    private final int numeroCompras;

    public ClienteFrecuente(String name, int id, int valorCompra, int numeroCompras) {
        super(name, id, valorCompra);
        this.numeroCompras = numeroCompras;
    }
    @Override
    public void calcularTotalPagar() {
        if (numeroCompras > 20){
            this.descontar(30);
        } else if (numeroCompras > 10) {
            this.descontar(20);
        } else{
            this.descontar(10);
        }
        if (this.esCompraAlta()){
            this.descontar(5);
        }
    }
    @Override
    public String imprimirResumen() {
        return super.imprimirResumen() + "\nnumero compras: " + this.numeroCompras;
    }
}
