package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AvionComercialTest {
    @Test
    public void testVolar(){
        Avion avion = new AvionComercial(100, 10);
        int distancia = 50;
        int combustibleNecesario = avion.volar(distancia);
        Assertions.assertEquals(500, combustibleNecesario);
    }
}
