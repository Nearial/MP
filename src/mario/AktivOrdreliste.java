package mario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AktivOrdreliste {

    private ArrayList<Ordre> aktiveOrdrer = new ArrayList<Ordre>();

    public void tilføjOrdre(Ordre ordre) {
        aktiveOrdrer.add(ordre);
    }

    public void fjernOrdre(int index) {
        aktiveOrdrer.remove(index);

    }

    public ArrayList<Ordre> getAktiveOrdrer() {
        return aktiveOrdrer;
    }

    public Ordre getAktiveOrdrer(int index) {
        return aktiveOrdrer.get(index);
    }

    @Override
    public String toString() {
        String ordreliste = " ";
        int nummer = 0;
        for (Ordre ordre : aktiveOrdrer) {
            ordreliste += "\n" + "Ordrenr: " + (nummer + 1) + ordre.printPizzaBestilling();
            nummer++;
        }
        return ordreliste;
    }
}
