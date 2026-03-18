import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        ArrayList<tarea> tareas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String placheHold; 
        String eleccion;
        boolean repetir = true;
        do {
            System.out.println("== Gestor de Tareas ==");
            System.out.println("1. Ver Tareas");
            System.out.println("2. Agregar Tarea");
            System.out.println("3. Completar Tarea");
            System.out.println("4. Eliminar Tarea");
            System.out.println("5. Salir");
            System.out.println("");
            eleccion = sc.next();
            System.out.println("");
            try {
                switch (eleccion.toLowerCase()) {
                    case "1":
                    case "ver tareas":
                        if (tareas.size()>0) {
                            for (tarea elemento : tareas) {
                                System.out.println(elemento.index+". "+elemento.completado);
                                System.out.println("");
                            }
                        }else{
                            System.out.println("No hay tareas aun");
                            System.out.println("");
                        }
                        break;
                    case "2":
                    case "agregar tarea":
                        System.out.println("Que tarea desea agregar?");
                        System.out.println("");
                        placheHold = sc.next();
                        tarea nuevaTarea = new tarea(placheHold,tareas.size()+1);
                        tareas.add(nuevaTarea);
                        System.out.println("Tarea agregada");
                        System.out.println("");
                        break;
                    case "3":
                    case "completar tarea":
                        System.out.println("Que tarea desea completar?");
                        System.out.println("");
                        placheHold=sc.next();
                        for (tarea tarea : tareas) {
                            if (placheHold.equals(tarea.tarea)||Integer.parseInt(placheHold) == tarea.index) {
                                tarea.completar();
                            }
                        }
                        System.out.println("Tarea completada");
                        System.out.println("");
                        break;
                    case "4":
                    case "eliminar tarea":
                        System.out.println("Que tarea desea eliminar?");
                        System.out.println("");
                        placheHold = sc.next();
                        for (tarea tarea : tareas) {
                            if (placheHold.equals(tarea.tarea)||Integer.parseInt(placheHold) == tarea.index) {
                                tareas.remove(tarea);
                            }
                        }
                        tareas.remove(placheHold);
                        System.out.println("Tarea Eliminada");
                        System.out.println("");
                        break;
                    case "5":
                    case "salir":
                        System.out.println("Hasta luego");
                        System.out.println("");
                        repetir=false;
                        break;
                    default:
                        System.out.println("No se reconoce la instruccion");
                        System.out.println("");
                        break;
                }
            } catch (Exception e) {
                System.out.println("No se reconoce la instruccion");
                System.out.println("");
            }
        } while (repetir);
    }
}
