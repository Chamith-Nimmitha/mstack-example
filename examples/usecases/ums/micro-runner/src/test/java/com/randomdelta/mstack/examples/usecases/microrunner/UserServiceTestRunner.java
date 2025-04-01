package com.randomdelta.mstack.examples.usecases.microrunner;


import com.randomdelta.mstack.commons.RequestHeaders;
import com.randomdelta.mstack.commons.TMessage;
import com.randomdelta.mstack.examples.usecases.ums.userservice.messages.command.CreateUser;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
class UserServiceTestRunner {
	public static void main(String[] args) throws InterruptedException {
		AppStarter appStarter = new AppStarter(UserServiceTestRunner.class.getResource("/user-config.yaml").getFile());
		appStarter.start();
		App app = appStarter.getApp();

		Thread.sleep(20000);

		while (true) {
			Thread.sleep(10000);
		}
	}
}