public class tarea {
    int index;
    String tarea;
    String completado;

    public tarea(String e,int i) {
        tarea = e;
        index = i;
        completado = "[] "+e;
    }
    
    public void completar(){
        completado="[X]"+tarea;
    }

    public void mostrar(){
        System.out.println(index+". "+completado);
    }
}
