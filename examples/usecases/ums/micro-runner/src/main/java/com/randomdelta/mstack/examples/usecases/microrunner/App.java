package com.randomdelta.mstack.examples.usecases.microrunner;

import com.randomdelta.mstack.MicroServer;
import com.randomdelta.mstack.commons.injector.Injector;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class App extends MicroServer {
	public App(MicroAppConfig appConfig, Injector injector) {
		super(appConfig.getMicroServerConfig(), injector);
	}
}
