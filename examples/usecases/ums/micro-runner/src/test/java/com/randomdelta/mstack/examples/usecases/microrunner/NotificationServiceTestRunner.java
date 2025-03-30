package com.randomdelta.mstack.examples.usecases.microrunner;


import com.randomdelta.mstack.commons.RequestHeaders;
import com.randomdelta.mstack.commons.TMessage;
import com.randomdelta.mstack.examples.usecases.ums.userservice.messages.command.CreateUser;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
class NotificationServiceTestRunner {
	public static void main(String[] args) throws InterruptedException {
		AppStarter appStarter = new AppStarter(NotificationServiceTestRunner.class.getResource("/notifi-config.yaml").getFile());
		appStarter.start();

		while (true) {
			Thread.sleep(10000);
		}
	}
}