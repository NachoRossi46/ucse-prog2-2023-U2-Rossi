package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalculadorCombustible {
    @Test
    public void calcularCombustible() {
        Avion avion = new AvionComercial(100, 10);
        int distancia = 50;
        int combustibleCalculado = CalculadorCombustible.getInstance().calcularCombustible(avion, distancia);
        Assertions.assertEquals(500, combustibleCalculado);
    }
}
