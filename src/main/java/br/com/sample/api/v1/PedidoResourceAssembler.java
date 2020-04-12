package br.com.sample.api.v1;

import br.com.sample.domain.orm.Pedido;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class BookResourceAssembler extends ResourceAssemblerSupport<Pedido, PedidoResource> {

    public PedidoResourceAssembler() {
        super(PedidoRestService.class, PedidoResource.class);
    }

    @Override
    public PedidoResource toResource(Pedido pedido) {
        PedidoResource pedidoResource = createResourceWithId(pedido.getId(), pedido);
        pedidoResource.setOrigem(pedido.getOrigem());
        pedidoResource.setDestino(pedido.getDestino());
        pedidoResource.setQuilometro(pedido.getQuilometro());
        addLinks(pedidoResource);
        return pedidoResource;
    }

    public Pedido toDomain(PedidoResource pedidoResource) {
        return Pedido.builder()
                .origem(pedidoResource.getOrigem())
                .destino(pedidoResource.getDestino())
                .quilometro(pedidoResource.getQuilometro())
                .build();
    }

    private void addLinks(PedidoResource pedidoResource) {
         pedidoResource.add(new Link("http://localhost:8080/v1/foo", "foo"));
         pedidoResource.add(new Link("http://localhost:8080/v1/bar", "bar"));
    }
}
