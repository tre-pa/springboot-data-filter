package br.jus.tre_pa.datafilter.sql;

import java.util.List;
import java.util.Map;

public interface SqlFetchStep {
	List<Map<String, Object>> fetchMaps();
}
