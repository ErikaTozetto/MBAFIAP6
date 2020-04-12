package br.com.sample;

import br.com.sample.domain.orm.Pedido;
import br.com.sample.domain.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitDb implements CommandLineRunner {

    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... strings) throws Exception {
        pedidoRepository.save(Pedido.builder().origem("Av Prof Syllas Mattos").quilometros(15).destino("Av dos Estados").build());
    }
}
