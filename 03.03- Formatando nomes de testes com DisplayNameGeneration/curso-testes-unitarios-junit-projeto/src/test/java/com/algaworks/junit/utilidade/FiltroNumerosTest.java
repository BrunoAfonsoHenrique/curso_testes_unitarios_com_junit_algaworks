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

    @Test
    void deve_Retornar_Numeros_Pares_() {
        List<Integer> numeros = Arrays.asList(1,2,3,4);
        List<Integer> numerosParesEsperados = Arrays.asList(2,4);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosPares(numeros);

        //Assertions.assertIterableEquals(numerosParesEsperados, resultadoFiltro);
        Assertions.assertIterableEquals(numerosParesEsperados, resultadoFiltro);
    }

}