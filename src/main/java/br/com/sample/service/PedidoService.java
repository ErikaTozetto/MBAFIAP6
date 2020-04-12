package br.com.sample.service;

import br.com.sample.domain.orm.Pedido;

public interface PedidoService {

    Pedido getById(Integer id);
    Pedido save(Pedido pedido);
}
