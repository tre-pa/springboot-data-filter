package br.jus.tre_pa.datafilter.sql;

import org.springframework.data.domain.Pageable;

public interface SqlPaginationStep extends SqlFetchStep {
	SqlPageableSelectStep limit(Pageable pageable);
}
