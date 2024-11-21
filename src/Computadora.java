import java.sql.SQLOutput;
import java.util.Scanner;

public class Computadora {

    private String marca;
    private String modelo;
    private long codigoBarras;
    private double precioTotal;
    private double porcentajeAumento;
    private double montoFinal;
    private String [][] componentes;
    Scanner sc = new Scanner(System.in);



    public void mostrarResultado(){
        System.out.println("La computadora especificada es:");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("CodigoBarras: " + codigoBarras);
        System.out.println("Año: " + "2024");
        System.out.println("Codigo item \t"+"Denominacion \t"+"Precio \t");
        for(int i = 0;i<componentes.length;i++){
            for(int j = 0;j<4;j++){
                System.out.print(componentes[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("Total componentes: "+precioTotal);
        System.out.println("Recargo: "+ porcentajeAumento);
        System.out.println("Monto Final: "+montoFinal);
    }



    public void montoFinal(){
        this.montoFinal = this.precioTotal + this.porcentajeAumento;
    }

    public void porcentajeAumento() {
        if (controlMarcados(componentes)){
           this.porcentajeAumento=(precioTotal*0.20);
        }else{
            this.porcentajeAumento=0;
        }
    }

    public void precioTotal(String [][] componentes){
        double suma =0;
        for(int i=0;i<componentes.length;i++){
            suma += Double.parseDouble(componentes[i][2]);
        }
        this.precioTotal = suma;
    }



    public void cargaComponentes(String [][] componentesPc, int cantidadComponentes) {
        System.out.println("Componentes de la Computadora");
        String codigo;
        String [] listaCodigos = new String[cantidadComponentes];
        sc.nextLine();
        int contador = 0;
        for(int i = 0; i < cantidadComponentes; i++){
            do{
                System.out.println("Ingrese el código del componente "+(i+1));
                codigo = sc.nextLine();
            }while (codigoEnMatriz(componentesPc,codigo)||controlCodigos(listaCodigos,codigo,contador));
            cargaMatriz(componentes,componentesPc,codigo,contador);
            contador++;

        }
        for(int i = 0; i < cantidadComponentes; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(componentes[i][j]+"\t");
            }
            System.out.println();
        }
        precioTotal(componentes);
        porcentajeAumento();
        montoFinal();

    }

    public boolean controlMarcados(String [][] componentes){
        int contador = 0;
        for(int i = 0; i < componentes.length; i++){
            if(componentes[i][3].equals("S")){
                contador++;
            }
        }
        if(contador < 5){
            System.out.println("Atención, 1 o más de los componentes obligatorios no fueron agregados, por este motivo se cobrara un recargo del 20%");
            return true;
        }else {
            return false;
        }
    }

    public void cargaMatriz(String [][]componentes,String[][] componentesPc , String codigo,int contador  ) {
        for(int i = 0; i < componentesPc.length; i++){
            if(componentesPc[i][0].equals(codigo.toUpperCase())){
                this.componentes[contador][0]=componentesPc[i][0];
                this.componentes[contador][1]=componentesPc[i][1];
                this.componentes[contador][2]=componentesPc[i][2];
                this.componentes[contador][3]=componentesPc[i][3];
            }
        }

    }

    public boolean controlCodigos(String [] listaCodigos, String codigo, int contando){
        int contador=0;
        for(int i = 0; i <contando; i++){
            if (codigo.equals(listaCodigos[i])){
                contador++;
            }
        }
        if (contador > 0){
            System.out.println("El codigo ya fue ingresado");
            return true;
        }else {
            listaCodigos[contando]=codigo;
            return false;
        }
    }

    public boolean codigoEnMatriz(String [][] componentesPc, String codigo){
        int contador = 0;
        for(int i=0;i<componentesPc.length;i++){
            if(componentesPc[i][0].equals(codigo.toUpperCase())){
                contador++;
            }
        }
        if (contador > 0){
            return false;
        }else {
            System.out.println("El codigo del componente no existe, vuelva a intentarlo");
            return true;
        }

    }

    public void inicioComponentes(int cantidadComponentes){
        componentes=new String[cantidadComponentes][4];
    }

    public int cantidadComponentes(){
        int cantidad;
        do {
            System.out.println("Indique la cantidad de componentes que tendra la pc:");
            cantidad = sc.nextInt();
            if(cantidad<5||cantidad>12){
                System.out.println("Error la cantidad de componentes tiene que ser entre 5 y 12");
            }
        }while (cantidad<5||cantidad>12);
        return cantidad;
    }

    public void cargaInicial(){
        System.out.println("Introduce la marca de la pc:");
        this.marca=sc.nextLine();
        System.out.println("Introduce el modelo de la pc:");
        this.modelo=sc.nextLine();
        String codigoBarras;
        do{
            System.out.println("Introduce el codigo de barras de la pc:");
            codigoBarras=sc.nextLine();
            if(codigoBarras.length()<7||codigoBarras.length()>15){
                System.out.println("El codigo de barras tiene que tener entre 7 y 15 caracteres");
            }
        }while (codigoBarras.length()<7||codigoBarras.length()>15);
        this.codigoBarras=Long.parseLong(codigoBarras);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPorcentajeAumento() {
        return porcentajeAumento;
    }

    public void setPorcentajeAumento(double porcentajeAumento) {
        this.porcentajeAumento = porcentajeAumento;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String[][] getComponentes() {
        return componentes;
    }

    public void setComponentes(String[][] componentes) {
        this.componentes = componentes;
    }
}
