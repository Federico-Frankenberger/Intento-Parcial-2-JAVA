import java.util.Scanner;

public class GeneraPC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [][] componentesPc = {{"AAA","Placa Madre", "20000", "S"} , {"BBB","Procesador" , "25000" , "S"} , {"CCC","Memoria RAM", "5000" , "S"} , {"DDD","Placa de Red", "3000" , "N"} , {"EEE","Disco Rigido SSD", "22000" , "S"} , {"FFF"," Placa de Video", "42000" , "N"} , {"GGG", "Monitor Led 21", "32000" , "N"} , {"HHH","Monitor Led 25", "41000" , "N"} , {"JJJ","Kit Teclado - Mouse", "9000" , "N"} , {"KKK","Gabinete", "6500" , "S"}, {"LLL","Fuente Alimentación", "6500" , "S"}, {"MMM","Placa de Sonido", "16500" , "N"}};
        Computadora computadora = new Computadora();
        computadora.cargaInicial();
        int cantidadComponentes= computadora.cantidadComponentes();
        computadora.inicioComponentes(cantidadComponentes);
        computadora.cargaComponentes(componentesPc,cantidadComponentes);
        computadora.mostrarResultado();



















    }
}
