package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    //TODO - Testar o construtor com saldo igual a null OK
    //TODO - Testar o saque com sucesso OK
    //TODO - Testar o saque com valor igual a null OK
    //TODO - Testar o saque com valor menor que zero OK
    //TODO - Testar o saque com valor igual zero Ok

    //TODO - Testar o deposito com sucesso OK
    //TODO - Testar o deposito com valor igual a null OK
    //TODO - Testar o deposito com valor menor que zero OK
    //TODO - Testar o deposito com valor igual zero OK

    //TODO - Testar retorno do valor do saldo OK

    @Test
    void deveLancarExcecaoSaldoNull() {

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new ContaBancaria(null));

        assertEquals("Saldo esta nulo", illegalArgumentException.getMessage());

    }

    @Test
    void saqueComSucesso() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(50));
        contaBancaria.saque(BigDecimal.valueOf(25));

        assertEquals(new BigDecimal("25"), contaBancaria.saldo());
    }

    @Test
    void saqueValorNuloTest() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(50));
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> contaBancaria.saque(null));

        assertEquals("Valor informado nao é valido", illegalArgumentException.getMessage());
    }

    @Test
    void saqueValorIgualAZeroTest() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(50));
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> contaBancaria.saque(BigDecimal.ZERO));

        assertEquals("Valor informado nao é valido", illegalArgumentException.getMessage());
    }

    @Test
    void saqueValorMenorQueZeroTest() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(50));
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> contaBancaria.saque(BigDecimal.valueOf(-1)));

        assertEquals("Valor informado nao é valido", illegalArgumentException.getMessage());
    }

    @Test
    void depositoComSucessoTest() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(50));
        contaBancaria.deposito(BigDecimal.TEN);

        assertEquals(BigDecimal.valueOf(60), contaBancaria.saldo());
    }

    @Test
    void depositoValorNuloTest() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(50));
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> contaBancaria.deposito(null));

        assertEquals("Valor informado nao é valido",  illegalArgumentException.getMessage());
    }

    @Test
    void depositoValorIgualAZeroTest() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(50));
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> contaBancaria.deposito(BigDecimal.ZERO));

        assertEquals("Valor informado nao é valido",  illegalArgumentException.getMessage());
    }

    @Test
    void depositoValorMenorQueZeroTest() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(50));
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> contaBancaria.deposito(BigDecimal.valueOf(-1)));

        assertEquals("Valor informado nao é valido",  illegalArgumentException.getMessage());
    }

    @Test
    void deveRetornarSaldoTest() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(50), contaBancaria.saldo());
    }

}