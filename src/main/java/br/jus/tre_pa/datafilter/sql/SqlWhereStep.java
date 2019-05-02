package br.jus.tre_pa.datafilter.sql;

import br.jus.tre_pa.datafilter.Filterable;

public interface SqlWhereStep extends SqlFetchStep, SqlOrderByStep {
	SqlOrderByStep where(Filterable filter);
}
