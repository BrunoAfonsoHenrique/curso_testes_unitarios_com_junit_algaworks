package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SaudacaoUtilTest {

    @Test
    void saudarBomDiaTest() {
        String mensagem = "Bom dia";
        String saudacao = SaudacaoUtil.saudar(9);

        assertEquals(saudacao, mensagem, "Saudacao incorreta");
    }

    @Test
    void saudarBoaTardeTest() {
        String mensagem = "Boa tarde";
        String saudacao = SaudacaoUtil.saudar(14);

        assertEquals(saudacao, mensagem);
    }

    @Test
    void saudarBoaNoiteTest() {
        String mensagem = "Boa noite";
        String saudacao = SaudacaoUtil.saudar(19);

        assertEquals(saudacao, mensagem);
    }

    @Test
    void deveLancaException() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> SaudacaoUtil.saudar(-10));

        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    void naoDeveLancarException() {
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
    }





}