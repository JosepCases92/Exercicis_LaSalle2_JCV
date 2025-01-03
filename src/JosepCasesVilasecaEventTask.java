import java.util.Objects;

public class JosepCasesVilasecaEventTask {
    private String text;
    private boolean isCompleted;   // Indica si la tarea está completada o no

    // Constructor
    public JosepCasesVilasecaEventTask(String text) {
        this.text = text;
        this.isCompleted = false;  // Inicialmente la tarea no está completada
    }


    public void completarTarea() {
        this.isCompleted = true;        // Marcar la tarea como completada
    }

    public void descompletarTarea() {
        this.isCompleted = false;       // Desmarcar la tarea como no completada
    }

    // Modo de representación del texto de la tarea y el estado en el que esta (completo o pendiente)
    @Override
    public String toString() {
        return "Tarea: " + text + " | Estado: " + (isCompleted ? "Completada" : "Pendiente");
    }

    // Devolvera true si la tarea esta completada y false si no lo esta
    public boolean isCompleted() {
        return isCompleted;
    }

    // Esto compara la tarea con otro objeto para determinar si son iguales y lo va a determinar si tienen el mismo texto (esto fue un dolor de cabeza) :)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                                 // Si es el mismo da true.
        if (o == null || getClass() != o.getClass()) return false;  // Si es nulo da false
        JosepCasesVilasecaEventTask that = (JosepCasesVilasecaEventTask) o;
        return Objects.equals(text, that.text);                     // Compara el texto de ambas
    }

    // Genera un codigo hash parala tarea y utiliza el texto de esta como base para crearlo
    @Override
    public int hashCode() {

        return Objects.hash(text);
    }
}
