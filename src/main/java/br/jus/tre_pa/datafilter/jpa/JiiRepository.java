package br.jus.tre_pa.datafilter.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.jus.tre_pa.datafilter.Aggregable;
import br.jus.tre_pa.datafilter.Aggregation;
import br.jus.tre_pa.datafilter.Page;
import br.jus.tre_pa.datafilter.Payload;
import br.jus.tre_pa.datafilter.Projectable;

/**
 * Interface de Repository com as funcionalidades de projeção, filtragem e agregação.
 * 
 * @author jcruz
 *
 * @param <T>
 */
public interface JiiRepository<T> {

	Page<T> findAll(Class<T> entityClass, Pageable pageable, Projectable projectable, Class<? extends AbstractSpecification<T>> specificationClass, Payload payload);

	List<Aggregation> aggregation(Class<T> entityClass, Specification<T> specification, Aggregable... aggregables);
}
