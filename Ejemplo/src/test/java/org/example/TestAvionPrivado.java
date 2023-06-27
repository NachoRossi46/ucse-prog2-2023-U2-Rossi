package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAvionPrivado {

    @Test
    public void volar() {
        Avion avion = new AvionPrivado(100, 10);
        int distancia = 50;
        int combustibleNecesario = avion.volar(distancia);
        Assertions.assertEquals(550, combustibleNecesario);
    }
}
