import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class JosepCasesVilasecaMain {
    // Array para almacenar los eventos creados
    private static ArrayList<JosepCasesVilasecaEvent> events = new ArrayList<>();

    public static void main(String[] args) {
        // Lectura de lo que el usuario entra en el programa
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Bucle principal que muestra el menu y procesa las opciones seleccionadas por el usuario
        while (!salir) {
            System.out.println("Bienvenido a Event Planner. Seleccione una opción:");
            System.out.println("[1] Añadir evento");
            System.out.println("[2] Borrar evento");
            System.out.println("[3] Listar eventos");
            System.out.println("[4] Marcar/desmarcar tarea como completada");
            System.out.println("[5] Salir");

            String opcion = scanner.nextLine();

            // Menu principal con sus 5 opciones
            switch (opcion) {
                case "1":
                    añadirEvento(scanner);
                    break;
                case "2":
                    borrarEvento(scanner);
                    break;
                case "3":
                    listarEventos();
                    break;
                case "4":
                    marcarTarea(scanner);
                    break;
                case "5":
                    salir = true;
                    System.out.println("Saliendo del programa :(");
                    break;
                default:
                    System.out.println("Opción incorrecta :(");
            }
        }

        scanner.close();
    }

    // Añadir un evento nuevo en el que se le van a pedir todos los datos nombre, fecha, prioridad y tarea
    private static void añadirEvento(Scanner scanner) {
        System.out.print("Introduzca el nombre del evento:");
        String title = scanner.nextLine();

        System.out.print("Introduzca la fecha del evento (año-mes-día):");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Seleccione la prioridad (HIGH, MEDIUM, LOW): ");
        JosepCasesVilasecaEvent.Priority priority =
                JosepCasesVilasecaEvent.Priority.valueOf(scanner.nextLine().toUpperCase());

        // Crea el evento con la informacion de nombre (titulo) fecha y prioridad
        JosepCasesVilasecaEvent event = new JosepCasesVilasecaEvent(title, date, priority);

        // Aqui he ehcho un bucle para poder añadir tareas al evento con el modo (si/no)
        System.out.print("¿Desea añadir tareas al evento? (si/no):");
        while (scanner.nextLine().equalsIgnoreCase("si")) {
            System.out.print("Introduzca una descripción de la tarea:");
            event.agregarTarea(new JosepCasesVilasecaEventTask(scanner.nextLine()));
            System.out.print("¿Añadir otra tarea? (si/no):");
        }

        events.add(event); // Aqui finalmente añade el evento con toda la info
        System.out.println("Evento añadido!");
    }

    // Borra el evento identificandolo con su nombre
    private static void borrarEvento(Scanner scanner) {
        System.out.print("Introduzca el nombre del evento a borrar:");
        String title = scanner.nextLine();

        // Aqui en caso de que el evento exista lo elimina
        events.removeIf(event -> event.getTitle().equalsIgnoreCase(title));
        System.out.println("Si el evento existía se ha borrado");
    }

    // Aqui permite ver la lista de los eventos añadidos. En caso de que no haya eventos va a mostrar el mensaje (No hay eventos)
    private static void listarEventos() {
        if (events.isEmpty()) {
            System.out.println("No hay eventos");
        } else {
            for (JosepCasesVilasecaEvent event : events) {
                System.out.println(event);
            }
        }
    }

    // Esta parte permite marcar o desmarcar una tarea del evento y es necesario dar el nombre
    private static void marcarTarea(Scanner scanner) {
        System.out.print("Introduzca el nombre del evento:");
        String title = scanner.nextLine();

        // Busca el evento con el título proporcionado
        JosepCasesVilasecaEvent event = events.stream()
                .filter(e -> e.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);

        if (event == null) {
            System.out.println("Evento no encontrado"); // Mensaje si no se encuentra el evento
            return;
        }

        // Aqui aparece la lista de los eventos
        System.out.println("Lista de tareas:");
        for (int i = 0; i < event.getTasks().size(); i++) {
            System.out.println((i + 1) + ". " + event.getTasks().get(i));
        }

        System.out.print("Seleccione el número de la tarea:");
        int taskIndex = Integer.parseInt(scanner.nextLine()) - 1;

        // Comprueva si es valido y luego permite marcar o desmarcar la tarea seleccionada
        if (taskIndex >= 0 && taskIndex < event.getTasks().size()) {
            JosepCasesVilasecaEventTask task = event.getTasks().get(taskIndex);
            if (task.isCompleted()) {
                task.descompletarTarea();
                System.out.println("Tarea desmarcada");
            } else {
                task.completarTarea();                                // Desmarca la tarea si ya esta completada
                System.out.println("Tarea marcada como completada");  // Marca la tarea como completada
            }
        } else {
            System.out.println("Número de tarea incorrecto");         // Mensaje que ve el usuario en caso de que se introduza un valor incorrecto
        }
    }
}
