package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;
import com.algaworks.junit.blog.modelo.Ganhos;
import com.algaworks.junit.blog.modelo.Post;
import com.algaworks.junit.blog.utilidade.ProcessadorTextoSimples;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraGanhosTest {

    static CalculadoraGanhos calculadora;
    Editor autor;
    Post post;

    @BeforeAll
    static  void initAll() {
        // System.out.println("Antes de todos os testes");
        calculadora = new CalculadoraGanhos(new ProcessadorTextoSimples(), BigDecimal.TEN);

    }

    @BeforeEach
    void beforeEach() {
        // System.out.println("Antes de cada teste");
        autor = new Editor(1L, "Alex", "alex@gmail.com", new BigDecimal(5), true);

        post = new Post(1L, "Ecosistema Java", "O ecossistema do Java é muito maduro", autor,
                "ecossistema-java-abc123", null, false, false);

    }


    @Test
    void deveCalcularGanhos() {
        Ganhos ganhos = calculadora.calcular(post);

        assertEquals(new BigDecimal("45"), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());

    }

    @Test
    void deveCalcularGanhosSemPremium() {
        autor.setPremium(false);

        Ganhos ganhos = calculadora.calcular(post);

        assertEquals(new BigDecimal("35"), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());

    }
}