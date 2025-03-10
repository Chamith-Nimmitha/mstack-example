package com.randomdelta.mstack.examples.basics.firstService.messages.query;

import com.randomdelta.mstack.core.query.Query;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FirstQuery extends Query {
	private String firstName;
}
