package com.randomdelta.mstack.examples.basics.firstService;

import com.randomdelta.mstack.MicroServer;
import com.randomdelta.mstack.MicroServerConfig;
import com.randomdelta.mstack.commons.RequestHeaders;
import com.randomdelta.mstack.commons.TMessage;
import com.randomdelta.mstack.core.query.Query;
import com.randomdelta.mstack.core.server.ServerConfig;
import com.randomdelta.mstack.examples.basics.firstService.messages.query.FirstQuery;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class QueryExample {
	public static void main(String[] args) throws InterruptedException {
		MicroServer microServer = MicroServer.builder()
				.withMicroServerConfig(
						MicroServerConfig.builder()
								.withServerConfig(ServerConfig.builder()
										.withServerId("Server1")
										.withProvider("FirstService", FirstService.class)
										.build())
								.build()
				)
				.build();
		microServer.start();

		FirstQuery firstQuery = new FirstQuery("Chamith");

		TMessage command = TMessage.builder()
				.addAttr(RequestHeaders.MESSAGE_TYPE, Query.type)
				.addAttr(RequestHeaders.QUERY, FirstQuery.class.getSimpleName())
				.withData(firstQuery)
				.build();

		microServer.request("FirstService", command).subscribe(s -> System.out.println(s));

		Thread.sleep(4000);
	}
}
