package mario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UdførteOrdrer {

    private ArrayList<Ordre> udførteOrdrer = new ArrayList<Ordre>();

    public void tilføjOrdre(Ordre ordre) {
        udførteOrdrer.add(ordre);
    }

    public void printUdførteOrdrer() throws FileNotFoundException, IOException {
        File fil = new File("UdførteOrdrer.txt");
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
        String ordreliste = " ";
        for (Ordre ordre : udførteOrdrer) {
            ordreliste += "\n" + ordre.printPizza();

        }
        return ordreliste;
    }

}
