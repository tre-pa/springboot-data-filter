package br.jus.tre_pa.datafilter.sql;

import java.util.List;

import br.jus.tre_pa.datafilter.Aggregation;
import br.jus.tre_pa.datafilter.Payload;

public interface SqlContext {
	SqlWhereStep selectFrom(String sql);

	List<Aggregation> aggregation(String sql, Payload payload);

	void clear();
}
