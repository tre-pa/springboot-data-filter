package br.jus.tre_pa.datafilter;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author jcruz
 *
 * @param <T>
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class JiiPage<T> {

	/**
	 * 
	 */
	private Page<T> pagination;

	/**
	 * 
	 */
	private List<Aggregation> aggregations;

	public JiiPage(Page<T> pagination) {
		super();
		this.pagination = pagination;
	}

	public JiiPage(Page<T> pagination, List<Aggregation> aggregations) {
		super();
		this.pagination = pagination;
		this.aggregations = aggregations;
	}

}
