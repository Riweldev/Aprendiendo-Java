import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        ArrayList<String> tareas = new ArrayList<>();
        String tarea;
        Scanner sc = new Scanner(System.in);
        String eleccion;
        System.out.println("== Gestor de Tareas ==");
        System.out.println("1. Ver Tareas");
        System.out.println("2. Agregar Tarea");
        System.out.println("3. Completar Tarea");
        System.out.println("4. Eliminar Tarea");
        System.out.println("5. Salir");
        eleccion = sc.next();
        switch (eleccion) {
            case "1":
                if (tareas.size()>0) {
                    for (String elemento : tareas) {
                        System.out.println(elemento);
                    }
                }else{
                    System.out.println("No hay tareas aun");
                }
                break;
            default:
                break;
        }
    }
}
