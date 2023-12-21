package com.algaworks.junit.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo;

    public ContaBancaria(BigDecimal saldo) {
        if (saldo == null) {

            throw new IllegalArgumentException("Saldo não pode ser nulo");
        }

        this.saldo = saldo;
    }

    public void saque(BigDecimal valor) {

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException("Valor inválido");
        }

        if (valor.compareTo(saldo) > 0) {

            throw new RuntimeException("Saldo insuficiente");
        }

        this.saldo = getSaldo().subtract(valor);
    }

    public void deposito(BigDecimal valor) {

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException("Valor inválido");
        }

        this.saldo = this.saldo.add(valor);
    }

    public BigDecimal saldo() {

        return getSaldo();
    }

    private BigDecimal getSaldo() {

        return this.saldo;
    }
}
