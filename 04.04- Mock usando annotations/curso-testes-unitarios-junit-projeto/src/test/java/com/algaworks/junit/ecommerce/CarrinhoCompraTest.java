package com.algaworks.junit.ecommerce;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoCompraTest {

    @Test
    void deveTestarConstrutorComUmParametroOk() {
        long id = 136L;
        Cliente cliente = new Cliente(id, "Alex da Silva");

        CarrinhoCompra carrinhoCompra = new CarrinhoCompra(cliente);

        Assertions.assertNotNull(carrinhoCompra.getCliente());

    }

    @Test
    void deveLancarExceptionNoConstrutor() {
        Assertions.assertThrows(NullPointerException.class, () -> new CarrinhoCompra(null, null));

    }

    @Test
    void deveTestarConstrutorOk() {
        long id = 136L;
        Cliente cliente = new Cliente(id, "Alex da Silva");

        Produto produto = new Produto(16L, "Iphone", "Smartphone", BigDecimal.valueOf(3000));
        ItemCarrinhoCompra itemCarrinhoCompra = new ItemCarrinhoCompra(produto, 3);
        List<ItemCarrinhoCompra> itens = new ArrayList<>();
        itens.add(itemCarrinhoCompra);

        CarrinhoCompra carrinhoCompra = new CarrinhoCompra(cliente, itens);

        Assertions.assertNotNull(carrinhoCompra.getCliente());
        Assertions.assertNotNull(carrinhoCompra.getItens());

    }

    @Test
    void deveTestarGetItens() {
        long id = 136L;
        Cliente cliente = new Cliente(id, "Alex da Silva");

        Produto produto = new Produto(16L, "Iphone", "Smartphone", BigDecimal.valueOf(3000));
        ItemCarrinhoCompra itemCarrinhoCompra = new ItemCarrinhoCompra(produto, 3);
        List<ItemCarrinhoCompra> itens = new ArrayList<>();
        itens.add(itemCarrinhoCompra);

        CarrinhoCompra carrinhoCompra = new CarrinhoCompra(cliente, itens);

        Assertions.assertNotNull(carrinhoCompra.getItens());
    }

    @Test
    void deveTestarGetCliente() {

        long id = 136L;
        Cliente cliente = new Cliente(id, "Alex da Silva");

        CarrinhoCompra carrinhoCompra = new CarrinhoCompra(cliente);

        Assertions.assertEquals(carrinhoCompra.getCliente(), cliente);

    }



}