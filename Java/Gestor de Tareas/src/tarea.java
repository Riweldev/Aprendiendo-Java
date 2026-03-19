public class tarea {
    int index;
    String tarea;
    boolean completado;

    public tarea(int i,String e,boolean b) {
        tarea = e;
        index = i;
        completado = b;
    }

    public void completar(){
        completado=true;
    }
}
