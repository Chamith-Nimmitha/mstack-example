package com.randomdelta.mstack.examples.usecases.microrunner;


import com.randomdelta.mstack.common.Message;
import com.randomdelta.mstack.common.RequestHeaders;
import com.randomdelta.mstack.core.app.App;
import com.randomdelta.mstack.core.server.Server;
import com.randomdelta.mstack.examples.usecases.ums.userservice.messages.command.CreateUser;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
class MainTest {
	public static void main(String[] args) throws InterruptedException {
		App app = App.APP;
		app.createAppInstance(App.getConfigFileName(args));
		app.start();

		Server server = app.getServer();

		CreateUser createUser = new CreateUser("chamith", "123", "chamith@gmail.com");
		Message message = Message.builder()
				.addAttr(RequestHeaders.MESSAGE_TYPE.value(), "COMMAND")
				.addAttr(RequestHeaders.COMMAND.value(), CreateUser.class.getSimpleName())
				.withData(createUser).build();

		server.request("UserService", message)
				.subscribe(r -> System.out.println("Incoming response: " + r));


		Thread.sleep(2000);
	}
}