package com.randomdelta.mstack.examples.basics;

import com.randomdelta.mstack.commons.injector.Named;
import com.randomdelta.mstack.core.server.ServerHeaders;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class MySecondFunction implements Function<String, Mono<String>> {
	private String functionName;

	public MySecondFunction(@Named(name = ServerHeaders.FUNCTION_NAME) String functionName) {
		this.functionName = functionName;
	}

	@Override
	public Mono<String> apply(String s) {
		System.out.println(this.functionName + " received msg: " + s);
		return Mono.just("Hello " + s);
	}
}
