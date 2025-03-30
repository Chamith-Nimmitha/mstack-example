package com.randomdelta.mstack.examples.usecases.ums;

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

		AppStarter posAppStarter = new AppStarter(configFileName);
		posAppStarter.start();

		while (true) {
			Thread.sleep(10000);
		}
	}
}
