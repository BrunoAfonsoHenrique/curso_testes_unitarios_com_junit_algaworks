package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FiltroNumerosTest {

    /*
            Give, When, Then
            Dado, Quando, Então
     */

    @Test
    void dado_uma_listas_de_numeros_quando_filtrar_por_pares_deve_retornar_apenas_numeros_pares() {
        List<Integer> numeros = Arrays.asList(1,2,3,4);
        List<Integer> numerosParesEsperados = Arrays.asList(2,4);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosPares(numeros);

        //Assertions.assertIterableEquals(numerosParesEsperados, resultadoFiltro);
        Assertions.assertIterableEquals(numerosParesEsperados, resultadoFiltro);
    }

    @Test
    void dado_uma_listas_de_numeros_quando_filtrar_por_impares_deve_retornar_apenas_numeros_impares() {
        List<Integer> numeros = Arrays.asList(1,2,3,4);
        List<Integer> numerosImparesEsperados = Arrays.asList(1,3);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosImpares(numeros);

        //Assertions.assertIterableEquals(numerosParesEsperados, resultadoFiltro);
        Assertions.assertIterableEquals(numerosImparesEsperados, resultadoFiltro);
    }

}