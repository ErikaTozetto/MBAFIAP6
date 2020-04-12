package br.com.sample.service;

import br.com.sample.domain.orm.Pedido;
import br.com.sample.domain.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido getById(Integer id) {
        Pedido Pedido = pedidoRepository.findOne(id);
        if(isNull(pedido)) {
            throw new RuntimeException("Pedido não encontrado!");
        }
        return pedido;
    }

    @Override
    public Pedido save(Pedido pedido) {
        if (pedido.getQuilometro() < 1)
        {
          throw new RuntimeException("Vá a pé, exercite-se!!... viagens abaixo de 1 km não são realizadas!");
        }
       
        return pedidoRepository.save(pedido);
    }
}
