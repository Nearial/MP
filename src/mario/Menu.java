package mario;

//en arrayliste med de pizzaer, der er på menukortet
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {

    ArrayList<Pizza> menu = new ArrayList();

    public Menu() {
        menu.add(new Pizza(1, "Vesuvio", 57.0, "tomatsauce, ost, skinke, oregano"));
        menu.add(new Pizza(2, "Amerikaner", 53.0, "tomatsauce, ost, oksefars, oregano"));
        menu.add(new Pizza(3, "Cacciatore", 57.0, "tomatsauce, ost, pepperoni, oregano"));
        menu.add(new Pizza(4, "Carbona", 63.0, "tomatsauce, ost, kødsauce, spaghetti, oregano"));
        menu.add(new Pizza(5, "Dennis", 65.0, "tomatsauce, ost, skinke, pepperoni, cocktailpølser, oregano"));
        menu.add(new Pizza(6, "Bertil", 57.0, "tomatsauce, ost, bacon, oregano"));
        menu.add(new Pizza(7, "Silvia", 61.0, "tomatsauce, ost, pepperoni, rød peber, løg, oliven, oregano"));
        menu.add(new Pizza(8, "Victoria", 61.0, "tomatsauce, ost, skinke, ananas, champignon, løg, oregano"));
        menu.add(new Pizza(9, "Toronfo", 61.0, "tomatsauce, ost, skinke, bacon, kebab, chili, oregano"));
        menu.add(new Pizza(10, "Cappriciosa", 61.0, "tomatsauce, ost, skinke, champignong, oregano"));
        menu.add(new Pizza(11, "Hawaii", 61.0, "tomatsauce, ost, skinke, ananas, oregano"));
        menu.add(new Pizza(12, "Le Blissola", 61.0, "tomatsauce, ost, skinke, rejer, oregano"));
        menu.add(new Pizza(13, "Venezia", 61.0, "tomatsauce, ost, skinke, bacon, oregano"));
        menu.add(new Pizza(14, "Mafia", 61.0, "tomatsauce, ost, pepperoni, bacon, løg, oregano"));
    }

    public ArrayList<Pizza> getMenu() {

        return menu;
    }

    public Pizza getPizza(int brugerValg) {
        return menu.get(brugerValg - 1);
    }

    public void printMenukort() throws FileNotFoundException, IOException {
        File fil = new File("Menukort.txt");
        FileReader filereader = new FileReader(fil);
        BufferedReader buffy = new BufferedReader(filereader);
        String tekst;
        while ((tekst = buffy.readLine()) != null) {
            System.out.println(tekst);
        }
        buffy.close();
    }

    @Override
    public String toString() {
        return "Menu" + menu;
    }

}
