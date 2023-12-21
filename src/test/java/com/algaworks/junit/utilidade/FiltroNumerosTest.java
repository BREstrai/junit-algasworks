package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FiltroNumerosTest {

    @Test
    void deveRetornarNumerosPares() {
        var numeros = FiltroNumeros.numerosPares(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        assertEquals(List.of(2, 4, 6, 8), numeros);
    }

    @Test
    void deveRetornarNumerosImpares() {
        var numeros = FiltroNumeros.numerosImpares(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        assertEquals(List.of(1, 3, 5, 7, 9), numeros);
    }

}