package com.randomdelta.mstack.examples.basics.secondService;

import com.randomdelta.mstack.MicroServer;
import com.randomdelta.mstack.MicroServerConfig;
import com.randomdelta.mstack.commons.RequestHeaders;
import com.randomdelta.mstack.commons.TMessage;
import com.randomdelta.mstack.core.command.Command;
import com.randomdelta.mstack.core.server.ServerConfig;
import com.randomdelta.mstack.examples.basics.firstService.FirstService;
import com.randomdelta.mstack.examples.basics.secondService.messages.command.SecondCommand;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class EventExample {

	public static void main(String[] args) throws InterruptedException {
		MicroServer microServer = MicroServer.builder()
				.withMicroServerConfig(
						MicroServerConfig.builder()
								.withServerConfig(ServerConfig.builder()
										.withServerId("Server1")
										.withProvider("FirstService", FirstService.class)
										.withProvider("SecondService", SecondService.class)
										.build())
								.build()
				)
				.build();
		microServer.start();

		Thread.sleep(1000);

		SecondCommand secondCommand = new SecondCommand("Chamith", "Kooragoda", 27, "Galle");

		TMessage command = TMessage.builder()
				.addAttr(RequestHeaders.MESSAGE_TYPE, Command.type)
				.addAttr(RequestHeaders.COMMAND, SecondCommand.class.getSimpleName())
				.withData(secondCommand)
				.build();

		microServer.request("SecondService", command).subscribe(s -> System.out.println(s));

		Thread.sleep(45000);
	}
}
