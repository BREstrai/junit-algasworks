package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

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
}