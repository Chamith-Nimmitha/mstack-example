package com.randomdelta.mstack.examples.basics;

import com.randomdelta.mstack.commons.injector.Named;
import com.randomdelta.mstack.core.server.ServerHeaders;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Function;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class DataStreamFunction implements Function<String, Flux<String>> {
	private String functionName;

	public DataStreamFunction(@Named(name = ServerHeaders.FUNCTION_NAME) String functionName) {
		this.functionName = functionName;
	}

	@Override
	public Flux<String> apply(String s) {
		System.out.println(this.functionName + " received msg: " + s);
		return Flux.just("One", "Two", "Three").delayElements(Duration.ofSeconds(1));
	}
}
