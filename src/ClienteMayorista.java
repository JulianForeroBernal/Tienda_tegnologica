public class ClienteMayorista extends  Cliente{
    private final int cantidadProductos;
    public ClienteMayorista(String name, int id, int valorCompra, int cantidadProductos) {
        super(name, id, valorCompra);
        this.cantidadProductos = cantidadProductos;
    }
    @Override
    public void calcularTotalPagar() {
       if (this.cantidadProductos > 50){
           this.descontar(50);
       } else if (this.cantidadProductos > 20) {
           this.descontar(35);
       }else {
           this.descontar(20);
       }
       if (this.valorCompra > 500000){
           this.valorCompra = 500000;
       }
    }
}
