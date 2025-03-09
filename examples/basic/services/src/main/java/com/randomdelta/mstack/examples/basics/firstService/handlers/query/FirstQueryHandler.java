package com.randomdelta.mstack.examples.basics.firstService.handlers.query;

import com.randomdelta.mstack.commons.RequestHeaders;
import com.randomdelta.mstack.core.GenericResponse;
import com.randomdelta.mstack.core.query.QueryContext;
import com.randomdelta.mstack.core.query.QueryHandler;
import com.randomdelta.mstack.examples.basics.firstService.messages.query.FirstQuery;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class FirstQueryHandler extends QueryHandler<FirstQuery, GenericResponse> {
	@Override
	public Publisher<GenericResponse> execute(QueryContext queryContext, FirstQuery firstQuery) {
		// retrieve data from the database
		return Mono.just(
				GenericResponse.builder()
						.success(true)
						.code(RequestHeaders.CODES.OK.getCode())
						.data("Data from DB.")
						.build());
	}
}
