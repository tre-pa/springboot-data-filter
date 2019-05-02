package br.jus.tre_pa.datafilter.rest;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonView;

import br.jus.tre_pa.datafilter.jpa.AbstractSpecification;
import br.jus.tre_pa.datafilter.jpa.DataFilterRepository;

public abstract class AbstractCrudRest<T, ID, R extends JpaRepository<T, ID> & DataFilterRepository<T>> extends AbstractDataFilterRest<T, ID, AbstractSpecification<T>, R> {
	/**
	 * Retorna a listagem paginada de recursos
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<T>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(getRepository().findAll(pageable));
	}

	/**
	 * Retorna um recurso específico.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/{id}")
	@JsonView(Views.Default.class)
	public T findById(@PathVariable ID id) {
		return getRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada."));
	}

	/**
	 * Retorna um recurso específico detalhado.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/{id}/detail")
	@JsonView(Views.Detail.class)
	public T findDetailById(@PathVariable ID id) {
		return getRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada."));
	}

	/**
	 * Cria um novo recurso
	 *
	 * @param recurso
	 * @return Entidade gerenciada.
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public T insert(@RequestBody @Valid T entity) {
		return getRepository().save(entity);
	}

	/**
	 * Atualiza um recurso
	 *
	 * @param recurso
	 * @return Entidade gerenciada.
	 */
	@PutMapping(path = "/{id}")
	public T update(@PathVariable ID id, @RequestBody T entity) {
		if (!getRepository().existsById(id)) throw new EntityNotFoundException("Entidade não encontrada.");
		return getRepository().save(entity);
	}

	/**
	 * Deleta umn recurso
	 *
	 * @param id
	 */
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable ID id) {
		if (!getRepository().existsById(id)) throw new EntityNotFoundException("Entidade não encontrada.");
		getRepository().deleteById(id);
	}
}
