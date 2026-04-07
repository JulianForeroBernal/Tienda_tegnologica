public class ClienteRegular extends Cliente{
    public ClienteRegular(String name, int id, int valorCompra) {
        super(name, id, valorCompra);
    }
    @Override
    public void calcularTotalPagar() {
       if (this.valorCompra > 300000){
           this.descontar(8);
       } else if (this.valorCompra > 150000) {
            this.descontar(5);
       } else if (this.valorCompra > 60000) {
           this.descontar(6);
       }else {
           this.setValorCompra(valorOriginal);
       }
    }
}
