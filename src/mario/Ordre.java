package mario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Ordre {

    private ArrayList<Pizza> bestiltePizzaer = new ArrayList<Pizza>();
    private double prisTotal;

    public Ordre(ArrayList<Pizza> bestilling) {
        this.bestiltePizzaer = bestilling;
    }

    public void removePizza(Pizza addedPizza) {
        if (bestiltePizzaer.contains(addedPizza)) {
            bestiltePizzaer.remove(addedPizza);
        }
    }

    public void addPizza(Pizza addedPizza) {
        bestiltePizzaer.add(addedPizza);
        udregnPrisTotal();
    }

    public String printPizza() {
        String print = " ";
        for (Pizza pizza : bestiltePizzaer) {
            print += pizza;
        }
        return print;
    }

    public String printPizzaBestilling() {
        String print = " ";
        for (Pizza pizza : bestiltePizzaer) {
            print += "Pizza nr: " + pizza.getPizzaNummer() + ", ";
        }
        return print + "Total pris: " + udregnPrisTotal();
    }

    public double udregnPrisTotal() {

        double prisTotal = 0.0;
        for (Pizza pizza : bestiltePizzaer) {
            prisTotal = prisTotal + pizza.getPris();

        }

        this.prisTotal = prisTotal;
        return prisTotal;
    }

    public ArrayList<Pizza> getBestiltePizzaer() {
        return bestiltePizzaer;
    }

    @Override
    public String toString() {
        String udførteOrdrer = "Udførte ordrer: \n";
        for (Pizza pizza : bestiltePizzaer) {
            udførteOrdrer += pizza + "\n";
        }
        return udførteOrdrer;

    }

}
