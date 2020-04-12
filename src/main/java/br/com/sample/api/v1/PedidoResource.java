package br.com.sample.api.v1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value="book", collectionRelation="pedidos")
class BookResource extends ResourceSupport {

    private String origem;
    private String destino;
    private Integer quilometro;
}
