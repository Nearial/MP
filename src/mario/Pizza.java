package mario;

public class Pizza {

    private int pizzaNummer;
    private String pizzaNavn;
    private double pris;
    private String ingredienser;

    public Pizza() {

    }

    public Pizza(int pizzaNummer, String pizzaNavn, double pris, String ingredienser) {
        this.pizzaNummer = pizzaNummer;
        this.pizzaNavn = pizzaNavn;
        this.pris = pris;
        this.ingredienser = ingredienser;
    }

    public int getPizzaNummer() {
        return pizzaNummer;
    }

    public String getPizzaNavn() {
        return pizzaNavn;
    }

    public double getPris() {
        return pris;
    }

    public String getIngredienser() {
        return ingredienser;
    }

    @Override
    public String toString() {
        return "Pizza: " + pizzaNummer + ", " + pizzaNavn + ", " + pris + " kr., ingredienser:" + ingredienser;
    }
}
