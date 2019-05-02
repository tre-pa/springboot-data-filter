package br.jus.tre_pa.datafilter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.jus.tre_pa.datafilter.domain.Foo;
import br.jus.tre_pa.datafilter.jpa.JiiRepository;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long>, JiiRepository<Foo> {

}
