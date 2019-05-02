package br.jus.tre_pa.datafilter.sql;

import org.springframework.data.domain.Sort;

public interface SqlOrderByStep extends SqlFetchStep {
	SqlPaginationStep orderBy(String sortSql);

	SqlPaginationStep orderBy(Sort sort);
}
