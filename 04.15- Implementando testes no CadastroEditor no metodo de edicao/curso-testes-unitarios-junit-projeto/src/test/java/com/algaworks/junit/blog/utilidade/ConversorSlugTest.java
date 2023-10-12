package com.algaworks.junit.blog.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ConversorSlugTest {

    @Test
    void Deve_converter_junto_com_codigo() {
        try (MockedStatic<GeradorCodigo> mockedStatic = Mockito.mockStatic(GeradorCodigo.class)) {
            mockedStatic.when(GeradorCodigo::gerar).thenReturn("123456");

            String slug = ConversorSlug.converterJuntoComCodigo("olá mundo java");

            Assertions.assertEquals("ola-mundo-java-123456", slug);

        }
    }

    // só utilize quando for realmente necessario fazer um testes de um método estatico
    // não é muito estavel

}