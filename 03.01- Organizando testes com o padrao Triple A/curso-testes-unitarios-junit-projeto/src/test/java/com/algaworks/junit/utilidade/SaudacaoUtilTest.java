package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;


class SaudacaoUtilTest {

    @Test
    void saudarBomDiaTest() {
        // Arrange -> Preparação do cenário: Variaveis que temos que declarar
        String mensagem = "Bom dia";

        // Act
        String saudacao = SaudacaoUtil.saudar(9);

        // Assert
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
        String saudacao = SaudacaoUtil.saudar(4);

        assertEquals(saudacao, mensagem);
    }

    @Test
    void saudarBomDiaAPartir5HTest() {
        String mensagem = "Bom dia";
        String saudacao = SaudacaoUtil.saudar(5);

        assertEquals(saudacao, mensagem, "Saudacao incorreta");
    }

    @Test
    void saudarBoaNoiteAs4HTest() {
        String mensagem = "Boa noite";
        String saudacao = SaudacaoUtil.saudar(4);

        assertEquals(saudacao, mensagem);
    }

    @Test
    void deveLancaException() {
        int horaInvalida = -10;

        Executable chamadaDeMetodoValida = () -> SaudacaoUtil.saudar(horaInvalida);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, chamadaDeMetodoValida);

        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    void naoDeveLancarException() {
        int horaIgalAZero = 0;
        Executable chamadaaoMetodo = () -> SaudacaoUtil.saudar(horaIgalAZero);
        assertDoesNotThrow(chamadaaoMetodo);
    }

}