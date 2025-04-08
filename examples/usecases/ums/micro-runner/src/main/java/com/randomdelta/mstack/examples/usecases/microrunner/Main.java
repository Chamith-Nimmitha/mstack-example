package com.randomdelta.mstack.examples.usecases.microrunner;

import com.randomdelta.mstack.core.app.App;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		App app = App.APP;
		app.createAppInstance(App.getConfigFileName(args));
		app.start();

		Thread.sleep(2000);
	}
}
