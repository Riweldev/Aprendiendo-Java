import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    double primerNumero , segundoNumero;
    double resultado=0;
    String operacion,otraMas;
    Scanner sc = new Scanner(System.in);
    do {
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
        } catch (Exception error) {
            System.out.println("Error: un valor no es un numero");
            sc.next();
        }
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
            System.out.println("Su resultado es "+ resultado); 
        }else if (operacion.equalsIgnoreCase("Resta") || operacion.equals("2")) {
            resultado = primerNumero - segundoNumero;
            System.out.println("Su resultado es "+ resultado); 
        }else if (operacion.equalsIgnoreCase("Multiplicacion") || operacion.equals("3")) {
            resultado = primerNumero * segundoNumero;
            System.out.println("Su resultado es "+ resultado); 
        }else if (operacion.equalsIgnoreCase("Division") || operacion.equals("4")) {
            if (segundoNumero == 0) {
                System.out.println("No se puede dividir por 0");
            }else{
                resultado = primerNumero / segundoNumero;
                System.out.println("Su resultado es "+ resultado); 
            }
        }
        System.out.println("Desea hacer otra operacion?");
        otraMas = sc.next();
    } while (otraMas.equalsIgnoreCase("si"));
    }
}
