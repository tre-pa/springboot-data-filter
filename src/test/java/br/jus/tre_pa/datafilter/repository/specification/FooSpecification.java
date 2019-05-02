package br.jus.tre_pa.datafilter.repository.specification;

import javax.persistence.criteria.JoinType;

import org.springframework.stereotype.Component;

import br.jus.tre_pa.datafilter.domain.Foo;
import br.jus.tre_pa.datafilter.jpa.AbstractSpecification;

@Component
public class FooSpecification extends AbstractSpecification<Foo> {

	@Override
	protected void configure() {
		map("bar.name", String.class, root -> root.join("bar", JoinType.LEFT).get("name"));
	}

}
