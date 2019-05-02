package br.jus.tre_pa.datafilter.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import br.jus.tre_pa.datafilter.sql.SqlContext;
import br.jus.tre_pa.datafilter.sql.h2.H2ContextImpl;
import br.jus.tre_pa.datafilter.sql.oracle.OracleContextImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DataFilterConfiguration {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource datasource;

	@Bean
	public SqlContext qyContext() throws SQLException, IllegalAccessException {
		if (datasource.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("h2")) {
			log.info("Data Context definido para o H2.");
			return new H2ContextImpl(jdbcTemplate);
		} else if (datasource.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")) {
			log.info("Data Context definido para o Oracle.");
			return new OracleContextImpl(jdbcTemplate);
		}
		throw new IllegalAccessException("Nenhuma implementação de contexto de dados encontado.");
	}

}
