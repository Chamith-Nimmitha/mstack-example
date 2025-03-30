package com.randomdelta.mstack.examples.usecases.ums.monolithrunner;

import com.randomdelta.mstack.commons.injector.Injector;
import com.randomdelta.mstack.core.server.BaseServer;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class App extends BaseServer {
	public App(MonolithAppConfig appConfig, Injector injector) {
		super(appConfig.getServerConfig(), injector);
	}
}
