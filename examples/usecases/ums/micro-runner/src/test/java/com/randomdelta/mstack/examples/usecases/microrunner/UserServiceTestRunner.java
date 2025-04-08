package com.randomdelta.mstack.examples.usecases.microrunner;


import com.randomdelta.mstack.core.app.App;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
class UserServiceTestRunner {
	public static void main(String[] args) throws InterruptedException {
		App app = App.APP;
		app.createAppInstance(UserServiceTestRunner.class.getResource("/user-config.yaml").getPath());
		app.start();

		while (true) {
			Thread.sleep(10000);
		}
	}
}