package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SaudacaoUtilTest {

    @Test
    void saudarBomDiaTest() {
        String mensagem = "Bom dia";
        String saudacao = SaudacaoUtil.saudar(9);

        assertEquals(saudacao, mensagem);
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
        String saudacao = SaudacaoUtil.saudar(50);

        assertEquals(saudacao, mensagem,"Hora invalida");
    }




}