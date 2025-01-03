import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JosepCasesVilasecaEvent {
    private String title;
    private LocalDate date;
    private Priority priority;
    private List<JosepCasesVilasecaEventTask> tasks; // Lista de tareas asociadas al evento

    // Enum para las prioridades
    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    // Constructor
    public JosepCasesVilasecaEvent(String title, LocalDate date, Priority priority) {
        this.title = title;
        this.date = date;
        this.priority = priority;
        this.tasks = new ArrayList<>();
    }

    // Agregar una tarea al evento
    public void agregarTarea(JosepCasesVilasecaEventTask task) {
        tasks.add(task);
    }

    // Para las tareas completadas
    public int tareasCompletadas() {
        return (int) tasks.stream().filter(JosepCasesVilasecaEventTask::isCompleted).count();
    }

    // Ver los detalles del evento
    @Override
    public String toString() {
        return "Evento:" + title + " | Fecha:" + date + " | Prioridad:" + priority +
                " | Tareas Completadas: " + tareasCompletadas() + "/" + tasks.size();
    }

    public String getTitle() {
        return title;
    }

    public List<JosepCasesVilasecaEventTask> getTasks() {
        return tasks;
    }
}
