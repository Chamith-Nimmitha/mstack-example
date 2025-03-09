package com.randomdelta.mstack.examples.basics;

import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class MyFirstFunc implements Function<String, Mono<String>> {


	@Override
	public Mono<String> apply(String s) {
		System.out.println("Function received msg: " + s);
		return Mono.just("Hello " + s);
	}
}
