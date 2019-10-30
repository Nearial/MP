package mario;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrdreTest {

    //Denne test undersøger, som totalprisen på én pizza udregnes korrekt
    @Test
    public void beregnTotalPris() {
        //Arrange
        ArrayList<Pizza> valgtePizzaer = new ArrayList();
        valgtePizzaer.add(new Pizza(3, "Cacciatore", 57.0, "tomatsauce, ost, pepperoni, oregano"));
        Ordre ordre = new Ordre(valgtePizzaer);
        double expectedTotal = 57.0;

        //Act
        double actualTotal = ordre.udregnPrisTotal();

        //Assert
        assertEquals(expectedTotal, actualTotal, 0);

    }
    //Tester, om totalprisen for flere pizzaer er korrekt
    @Test
    public void beregnPrisFlerePizzaer() {
        //Arrange        
        ArrayList<Pizza> valgtePizzaer = new ArrayList();
        valgtePizzaer.add(new Pizza(3, "Cacciatore", 57.0, "tomatsauce, ost, pepperoni, oregano"));
        valgtePizzaer.add(new Pizza(3, "Cacciatore", 57.0, "tomatsauce, ost, pepperoni, oregano"));
        Ordre ordre = new Ordre(valgtePizzaer);
        double expectedTotal = 114.0;

        //Act
        double actualTotal = ordre.udregnPrisTotal();

        //Assert
        assertEquals(expectedTotal, actualTotal, 0);

    }

}
