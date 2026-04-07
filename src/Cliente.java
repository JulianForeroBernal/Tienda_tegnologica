public class Cliente {
    //atributos
    protected String name;
    protected int id;
    protected int valorCompra;
    protected int valorOriginal;
    //constructor
    public Cliente(String name, int id, int valorCompra) {
        this.name = name;
        this.id = id;
        this.valorCompra = valorCompra;
        this.valorOriginal = valorCompra;
    }
    //getter and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(int valorCompra) {
        this.valorCompra = valorCompra;
    }
    public int getValorOriginal() {
        return valorOriginal;
    }
    public void setValorOriginal(int valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    //métodos propios
    public void calcularTotalPagar(){
        this.setValorCompra(this.valorCompra);
    }
    public void descontar(int porcentaje){
        this.setValorCompra(this.getValorCompra() - (int)(this.getValorCompra() * (porcentaje / 100.0)));
    }
    public void aumentar(int percent){
        this.setValorCompra(this.getValorCompra() + (int)(this.getValorCompra() * (percent / 100.0)));
    }
    public boolean esCompraAlta(){
        return this.valorCompra > 300000;
    }
    public String imprimirResumen(){
        return "nombre: " + this.name +
                "\nid: " + this.id + " " +
                "\nvalor original de la consulta: " +this.valorOriginal +
                "\nvalor final de la consulta: " + this.getValorCompra();
    }
}
