package com.randomdelta.mstack.examples.usecases.ums.monolithrunner;

import com.randomdelta.mstack.commons.RequestHeaders;
import com.randomdelta.mstack.commons.TMessage;
import com.randomdelta.mstack.examples.usecases.ums.userservice.messages.command.CreateUser;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		AppStarter appStarter = new AppStarter(TestApp.class.getResource("/config.yaml").getFile());
		appStarter.start();
		App app = appStarter.getApp();

		CreateUser createUser = new CreateUser("chamith", "123", "chamith@gmail.com");
		TMessage message = TMessage.builder()
				.addAttr(RequestHeaders.MESSAGE_TYPE, "COMMAND")
				.addAttr(RequestHeaders.COMMAND, CreateUser.class.getSimpleName())
				.withData(createUser).build();

		app.request("UserService", message)
				.subscribe(r -> System.out.println("Incoming response: " + r));


		while (true) {
			Thread.sleep(10000);
		}
	}
}
