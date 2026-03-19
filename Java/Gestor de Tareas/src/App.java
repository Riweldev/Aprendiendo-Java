import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args){

        //Utilizo try-with-resources para manejar excepciones y poder modificar archivos
        try (BufferedReader br = new BufferedReader(new FileReader("tareasGuardadas.txt"))){
            
            //Declaracion de variables a usar
            ArrayList<tarea> tareas = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            String placheHold; 
            String eleccion;
            boolean repetir = true;
            String[] ayuda;
            String linea;

            while ((linea = br.readLine()) != null) {
                ayuda = linea.split(",");
                tarea nuevaTarea = new tarea(Integer.valueOf(ayuda[0]),ayuda[1], Boolean.valueOf(ayuda[2]));
                tareas.add(nuevaTarea);
            }
            try {
                //Ciclo de el programa
                do {
                    //Menu de inicio
                    System.out.println("== Gestor de Tareas ==");
                    System.out.println("1. Ver Tareas");
                    System.out.println("2. Agregar Tarea");
                    System.out.println("3. Completar Tarea");
                    System.out.println("4. Eliminar Tarea");
                    System.out.println("5. Salir");
                    System.out.println("");
                    eleccion = sc.nextLine();
                    System.out.println("");
                        //switch selector
                        switch (eleccion.toLowerCase()) {
                            
                            //crear tarea
                            case "1":
                            case "ver tareas":
                                if (tareas.size()>0) {
                                    for (tarea elemento : tareas) {
                                        if (elemento.completado) {
                                            System.out.println(elemento.index+". [x]"+elemento.tarea);
                                        }else{
                                            System.out.println(elemento.index+". [ ]"+elemento.tarea);
                                        }
                                    }
                                }else{
                                    System.out.println("No hay tareas aun");
                                    System.out.println("");
                                }
                                break;

                            //agregar tarea
                            case "2":
                            case "agregar tarea":
                                System.out.println("Que tarea desea agregar?");
                                System.out.println("");
                                placheHold = sc.nextLine();
                                tarea nuevaTarea = new tarea(tareas.size()+1,placheHold,false);
                                tareas.add(nuevaTarea);
                                System.out.println("Tarea agregada");
                                System.out.println("");
                                break;

                            //completar tarea
                            case "3":
                            case "completar tarea":
                                System.out.println("Que tarea desea completar?");
                                System.out.println("");
                                placheHold=sc.nextLine();
                                boolean encontrada = false;
                                try {
                                    for (tarea tarea : tareas) {
                                        if (placheHold.equalsIgnoreCase(tarea.tarea)||(placheHold.matches("\\d+") && Integer.parseInt(placheHold) == tarea.index)) {
                                            tarea.completar();
                                            encontrada = true;
                                        }
                                    }
                                    if (encontrada) {
                                        System.out.println("Tarea completada");
                                        System.out.println("");   
                                    }
                                } catch (Exception e) {
                                    System.out.println("No se encontro la tarea" + placheHold);
                                }
                                
                                break;

                            //eliminar tarea
                            case "4":
                            case "eliminar tarea":
                                System.out.println("Que tarea desea eliminar?");
                                System.out.println("");
                                String valorBuscado = sc.nextLine();
                                try {
                                    tareas.removeIf(n -> valorBuscado.equalsIgnoreCase(n.tarea) || (valorBuscado.matches("\\d+") && Integer.parseInt(valorBuscado) == n.index));
                                    for (int i = 0; i < tareas.size(); i++) {
                                        tareas.get(i).index = i + 1;
                                    }
                                    System.out.println("Tarea Eliminada");
                                    System.out.println("");
                                } catch (Exception e) {
                                    System.out.println("No se encontro la tarea" + valorBuscado);
                                }
                                break;

                            //salir del menu y guardar objeto en archivo
                            case "5":
                            case "salir":
                                try (BufferedWriter bw = new BufferedWriter(new FileWriter("tareasGuardadas.txt"))){
                                    for (tarea tarea : tareas) {
                                    bw.write(tarea.index+","+tarea.tarea+","+tarea.completado);
                                    bw.newLine();
                                }
                                System.out.println("Hasta luego");
                                System.out.println("");
                                repetir=false;
                                } catch (Exception e) {
                                    System.out.println("Ocurrio un error");
                                }
                                
                                break;
                            default:
                                System.out.println("No se reconoce la instruccion");
                                System.out.println("");
                                break;
                        }
                    } while (repetir);
                } catch (Exception e) {
                    System.out.println("Ocurrio un error");
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error");
                System.out.println(e);
            }
    }
}