package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AvionTest {
    @Test
    public void getConsumoCombustible() {
        Avion avion = new AvionComercial(100, 10);
        int consumoCombustible = avion.getConsumoCombustible();
        Assertions.assertEquals(10, consumoCombustible);
    }
}
