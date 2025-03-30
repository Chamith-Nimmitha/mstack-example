package com.randomdelta.mstack.examples.usecases.ums.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */

@NoArgsConstructor
@Data
public class Server {

	private String serverId;
	private int servicePort;
	private List<RFunction> functions;
	private List<Provider> providers;
	private String authenticator;

	@Data
	@NoArgsConstructor
	public static class RFunction {
		private String name;
		private String type;
	}

	@Data
	@NoArgsConstructor
	public static class Provider {
		private String name;
		private String type;
	}

	@Data
	@NoArgsConstructor
	public static class WebApi {
		private int webServerPort;
		private int websocketServerPort;
	}
}
