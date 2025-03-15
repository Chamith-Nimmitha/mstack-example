package com.randomdelta.mstack.examples.basics.firstService;

import com.randomdelta.mstack.MicroServer;
import com.randomdelta.mstack.MicroServerConfig;
import com.randomdelta.mstack.commons.RequestHeaders;
import com.randomdelta.mstack.commons.TMessage;
import com.randomdelta.mstack.core.command.Command;
import com.randomdelta.mstack.core.server.ServerConfig;
import com.randomdelta.mstack.examples.basics.firstService.messages.command.FirstCommand;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class CommandExample {

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

		FirstCommand firstCommand = new FirstCommand("Chamith", "Kooragoda", 27, "Galle");

		TMessage command = TMessage.builder()
				.addAttr(RequestHeaders.MESSAGE_TYPE, Command.type)
				.addAttr(RequestHeaders.COMMAND, FirstCommand.class.getSimpleName())
				.withData(firstCommand)
				.build();

		microServer.request("FirstService", command).subscribe(s -> System.out.println(s));

		Thread.sleep(45000);
	}
}
