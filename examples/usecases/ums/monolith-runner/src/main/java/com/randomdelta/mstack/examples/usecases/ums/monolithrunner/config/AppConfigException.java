package com.randomdelta.mstack.examples.usecases.ums.monolithrunner.config;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class AppConfigException extends RuntimeException {
	public AppConfigException(String message) {
		super(message);
	}

	public AppConfigException(String message, Throwable cause) {
		super(message, cause);
	}
}
