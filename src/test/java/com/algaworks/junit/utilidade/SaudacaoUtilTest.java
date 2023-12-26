package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SaudacaoUtilTest {

    @Test
    void deveRetornarBomDia() {
        String saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao, "Incorreto, deve retornar bom dia");
    }

    @Test
    void deveRetornarBoaTarde() {
        String saudacao = SaudacaoUtil.saudar(15);
        assertEquals("Boa tarde", saudacao, "Incorreto, deve retornar boa tarde");
    }

    @Test
    void deveRetornarBoaNoite() {
        String saudacao = SaudacaoUtil.saudar(23);
        assertEquals("Boa noite", saudacao, "Incorreto, deve retornar boa noite");
    }

    @Test
    void deveRetornarBoaNoiteDeMadrugada() {
        String saudacao = SaudacaoUtil.saudar(3);
        assertEquals("Boa noite", saudacao, "Incorreto, deve retornar noite");
    }

    @Test
    void deveRetornarException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> SaudacaoUtil.saudar(-24), "Deve retornar exceção");

        assertEquals("Hora inválida", exception.getMessage(), "Deve retornar mensagem de erro 'Hra inválida'");
    }

    @Test
    void naoDeveRetornarException() {
        String saudacao = SaudacaoUtil.saudar(23);
        assertEquals("Boa noite", saudacao, "Incorreto, deve retornar boa noite");
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8, 9, 10, 11})
    void deveRetornarBomDia(int hora) {
        String saudacao = SaudacaoUtil.saudar(hora);
        assertEquals("Bom dia", saudacao, "Incorreto, deve retornar bom dia");
    }


    // Exemplo de uso de @EnumSource
    //@ParameterizedTest
    //@EnumSource(value Multiplicador.class, names = {"DOIS", "TRES", "QUATRO"})
    //void deveRetornarMultiplicador(Multiplicador multiplicador) {
    //  assertNonNull(multiplicador.aplicar(2), "Deve retornar multiplicador não nulo");
    //}
}