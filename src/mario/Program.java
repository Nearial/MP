package mario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    AktivOrdreliste aktiveOrdrer = new AktivOrdreliste();
    UdførteOrdrer udførteOrdrer = new UdførteOrdrer();
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);

    public void run() throws FileNotFoundException, IOException {

        int brugerValg = 0; //for at komme ind i loopen

        
        while (brugerValg != 5) {
            System.out.println();
            System.out.println("Velkommen til Marios Pizzeria");
            System.out.println();
            System.out.println("Tast 1 for at se menukortet");
            System.out.println("Tast 2 for at oprette en ordre");
            System.out.println("Tast 3 for at se aktive ordrer");
            System.out.println("Tast 4 for at fjerne en ordre, der er udført");
            System.out.println("Tast 5 for at se de udførte ordrer");
            System.out.println("Tast 6 for at lukke programmet");

            brugerValg = input.nextInt();

            switch (brugerValg) {

                case 1:
                    menu.printMenukort();
                    //Menukortet læses fra en txt-fil
                    break;

                case 2:
                    opretOrdre();
                    break;

                case 3:
                    System.out.println("Her er de aktive ordrer: " + aktiveOrdrer.toString());
                    break;

                case 4:
                    fjernOrdre();
                    break;

                case 5:
                    //Læser udførte ordrer fra txt-fil: 
                    udførteOrdrer.printUdførteOrdrer();
                    break;

                case 6:
                    //Afslutter programmet
                    break;

            }

        }
    }

    public void opretOrdre() {
        int brugerValg = 0;

        ArrayList<Pizza> valgtePizzaer = new ArrayList();
        while (brugerValg != -1) {
            System.out.println("Angiv den ønskede pizza, eller tast -1"
                    + "for at afslutte programmet");

            brugerValg = input.nextInt();

            if (brugerValg > 0) {

                System.out.println("Der er valgt pizza nummer " + brugerValg);

                valgtePizzaer.add(menu.getPizza(brugerValg));
            }

        }
        Ordre pizzaBestilling = new Ordre(valgtePizzaer);
        System.out.println("Der er bestilt: ");

        System.out.println(pizzaBestilling.printPizzaBestilling());

        aktiveOrdrer.tilføjOrdre(pizzaBestilling);

    }

    public void fjernOrdre() { //fjerner en ordre fra aktiv-listen til listen over de udførte,
        //og skriver de udførte ordrer til en txt-fil
        int brugerValg = 0;

        System.out.println("Her er de aktive ordrer: " + aktiveOrdrer.toString());
        while (brugerValg != -1) {
            System.out.println("Angiv ordrenr. for den, du ønsker at fjerne, eller tast"
                    + " -1 for at afslutte");
            brugerValg = input.nextInt();

            if (brugerValg > 0) {
                System.out.println("Der er valgt ordrenr. " + brugerValg);
                Ordre toBeRemoved = aktiveOrdrer.getAktiveOrdrer(brugerValg - 1);
                String orderInfo = toBeRemoved.toString();
                skrivOrdreTilFil(orderInfo);
                udførteOrdrer.tilføjOrdre(toBeRemoved);
                aktiveOrdrer.fjernOrdre(brugerValg - 1);

            }
        }

    }

    public void skrivOrdreTilFil(String order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("UdførteOrdrer.txt", true))) {
            writer.write(order);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
