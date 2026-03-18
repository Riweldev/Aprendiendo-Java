import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
    double primerNumero , segundoNumero;
    double resultado=0;
    String operacion,otraMas;
    Scanner sc = new Scanner(System.in);
    do {
        boolean operacionValida = true;
        try {
            System.out.println("Ingrese el Primer numero");
            primerNumero = sc.nextDouble();
            System.out.println("Que division quiere realizar?");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            operacion = sc.next();
            System.out.println("Ingrese el Segundo numero");
            segundoNumero = sc.nextDouble();
            if (operacion.equalsIgnoreCase("Suma") || operacion.equals("1")) {
                resultado = primerNumero + segundoNumero;
            }else if (operacion.equalsIgnoreCase("Resta") || operacion.equals("2")) {
                resultado = primerNumero - segundoNumero;
            }else if (operacion.equalsIgnoreCase("Multiplicacion") || operacion.equals("3")) {
                resultado = primerNumero * segundoNumero;
            }else if (operacion.equalsIgnoreCase("Division") || operacion.equals("4")) {
                if (segundoNumero == 0) {
                    System.out.println("No se puede dividir por cero.");
                    operacionValida = false;
                } else {
                    resultado = primerNumero / segundoNumero;
                }
            }
            if (operacionValida) {
                System.out.println("Su Resultado es "+ resultado);
            }
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println(e);
            System.out.println("No Es posible realizar la operacion");
        }
        System.out.println("Desea hacer otra operacion?");
        otraMas = sc.next();
    } while (otraMas.equalsIgnoreCase("si"));
    }
}