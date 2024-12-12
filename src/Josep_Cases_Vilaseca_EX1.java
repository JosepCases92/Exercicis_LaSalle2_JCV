import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


// Aqui se define la clase Perfil, que representa el perfil personal

class Perfil {
    private String name;
    private String story;
    private ArrayList<String> hobbies;
    private ArrayList<String> foods;
    private ArrayList<String> funFacts;


    // Constructor de la clase Perfil que inicializa todos los atributos

    public Perfil(String name, String story, ArrayList<String> hobbies, ArrayList<String> foods, ArrayList<String> funFacts) {
        this.name = name;
        this.story = story;
        this.hobbies = hobbies;
        this.foods = foods;
        this.funFacts = funFacts;
    }

    // Aqui hay los metodos getter para acceder a los atributos de la clase

    public String getName() {
        return name;}
    public String getStory() {
        return story;}
    public ArrayList<String> getHobbies() {
        return hobbies;}
    public ArrayList<String> getFoods() {
        return foods;}
    public ArrayList<String> getFunFacts() {
        return funFacts;}
    public String formatStory() {
        return "Mi Historia: " + story;}
    public String formatFavorites() {
        return "Hobbies:\nFavoritos: " + hobbies + "\nComida: " + foods;}
    public String formatRandomFunFact() {
        Random random = new Random();
        return "Dato curioso: " + funFacts.get(random.nextInt(funFacts.size()));}
}


//Clase principal para interactuar con el perfil.

public class Josep_Cases_Vilaseca_EX1 {
    public static void main(String[] args) {

        // Crea listas para hobbies, comidas favoritas y datos curiosos

        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("Componer");
        hobbies.add("Hacer deporte");
        hobbies.add("Aprender");

        ArrayList<String> foods = new ArrayList<>();
        foods.add("Pasta");
        foods.add("Sushi");
        foods.add("Pizza");

        ArrayList<String> funFacts = new ArrayList<>();
        funFacts.add("Puedo estar todo el dia haciendo musica");
        funFacts.add("Me encantan los gatos");
        funFacts.add("He sido professor durante 5 años");

        //Aqui creo un objeto de la clase Perfil

        Perfil perfil = new Perfil(
                "Josep Cases Vilaseca",
                "Editor audiovisual con mucha curiosidad para el desarollo de aplicaciones",
                hobbies,
                foods,
                funFacts
        );

        // Menu del programa que le permite seleccionar la opcion que quiera el usuario)

        Scanner scanner = new Scanner(System.in);
        int option;

        // Bucle do-while para mostrar el menu siempre hasta que la persona decida salir del progrtama

        do {
            System.out.println("Informacion de [" + perfil.getName() + "]");
            System.out.println("[1] Historia: Muestra la historia personal");
            System.out.println("[2] Favoritos: Muestra los hobbies y comidas favoritas");
            System.out.println("[3] Dato curioso: Muestra un dato curioso sobre Josep");
            System.out.println("[4] Salir");
            System.out.print("Selecciona una opción:");

            while (!scanner.hasNextInt()) {
                System.out.println("Opción invalida!");
                scanner.next();}

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println(perfil.formatStory());
                    break;
                case 2:
                    System.out.println(perfil.formatFavorites());
                    break;
                case 3:
                    System.out.println(perfil.formatRandomFunFact());
                    break;
                case 4:
                    System.out.println("Has salido del programa :(");
                    break;
                default:
                    System.out.println("Opción invalida!");}
        } while (option != 4);

        scanner.close();
    }
}
