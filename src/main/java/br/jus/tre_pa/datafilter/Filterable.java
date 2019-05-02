package br.jus.tre_pa.datafilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.jus.tre_pa.datafilter.jpa.AttributePath;
import br.jus.tre_pa.datafilter.predicate.Expression;
import lombok.Getter;
import lombok.Setter;

public abstract class Filterable extends Expression {

	@Getter
	@Setter
	private List<Expression> predicates = new ArrayList<>();

	@Override
	public String toSql() {
		// @formatter:off
		return this.predicates
				.stream()
				.map(p -> p.toSql())
				.collect(Collectors.joining());
		// @formatter:on
	}

	@Override
	public String toJpql() {
		// @formatter:off
		return this.predicates
				.stream()
				.map(p -> p.toJpql())
				.collect(Collectors.joining());
		// @formatter:on
	}

	public static class EmptyFilterable extends Filterable {

		@Override
		public <T> Predicate toPredicate(Class<T> clazz, Root<T> root, CriteriaQuery<?> cq, CriteriaBuilder cb, Map<String, AttributePath> paths) {
			return null;
		}
	}

}
