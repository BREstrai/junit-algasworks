package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaBancariaTest {

    @Test
    void deveRetornarSaldoNaoNull() {
        ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(100));

        assertEquals(100, contaBancaria.saldo().intValue(), "Deve retornar 100");
    }

    @Nested
    class depositar {
        @Test
        void deveAguardarExceptionSeAdicionarNull() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(100));
                contaBancaria.deposito(null);
            });

            assertEquals("Valor inválido", exception.getMessage(), "Deve retornar 'Valor inválido'");
        }

        @Test
        void deveAguardarExceptionSeAdicionarMenosQueZero() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(100));
                contaBancaria.deposito(BigDecimal.ZERO);
            });

            assertEquals("Valor inválido", exception.getMessage(), "Deve retornar 'Valor inválido'");
        }

        @Test
        void deveAdicionarValorAoSaldo() {
            ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(100));

            contaBancaria.deposito(new BigDecimal(50));

            assertEquals(150, contaBancaria.saldo().intValue(), "Deve retornar 150");
        }
    }

    @Nested
    class saque {
        @Test
        void deveAguardarExceptionSeSacarNull() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(100));
                contaBancaria.saque(null);
            });

            assertEquals("Valor inválido", exception.getMessage(), "Deve retornar 'Valor inválido'");
        }

        @Test
        void deveAguardarExceptionSeSacarMenosQueZero() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(100));
                contaBancaria.saque(BigDecimal.ZERO);
            });

            assertEquals("Valor inválido", exception.getMessage(), "Deve retornar 'Valor inválido'");
        }

        @Test
        void deveAguardarExceptionSeSacarMaisQueSaldo() {
            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(100));
                contaBancaria.saque(new BigDecimal(150));
            });

            assertEquals("Saldo insuficiente", exception.getMessage(), "Deve retornar 'Saldo insuficiente'");
        }
    }

}