package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SaudacaoUtilTest {

    @Test
    void saudarBomDiaTest() {
        String mensagem = "Bom dia";
        String saudacao = SaudacaoUtil.saudar(9);

        Assertions.assertTrue(saudacao.equals(mensagem));
    }

    @Test
    void saudarBoaTardeTest() {
        String mensagem = "Boa tarde";
        String saudacao = SaudacaoUtil.saudar(14);

        Assertions.assertTrue(saudacao.equals(mensagem));
    }

    @Test
    void saudarBoaNoiteTest() {
        String mensagem = "Boa noite";
        String saudacao = SaudacaoUtil.saudar(19);

        Assertions.assertTrue(saudacao.equals(mensagem));
    }




}