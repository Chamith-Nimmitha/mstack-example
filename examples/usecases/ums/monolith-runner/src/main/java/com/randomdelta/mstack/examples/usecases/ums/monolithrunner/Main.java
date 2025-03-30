package com.randomdelta.mstack.examples.usecases.ums.monolithrunner;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		String configFileName;
		if(args.length == 1) {
			configFileName = args[0];
		} else {
			configFileName = Main.class.getResource("/config.yaml").getFile();
		}

		AppStarter appStarter = new AppStarter(configFileName);
		appStarter.start();

		while (true) {
			Thread.sleep(10000);
		}
	}
}
