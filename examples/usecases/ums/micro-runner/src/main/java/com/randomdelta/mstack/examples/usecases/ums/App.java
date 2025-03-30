package com.randomdelta.mstack.examples.usecases.ums;

import com.randomdelta.mstack.commons.injector.Injector;
import com.randomdelta.mstack.core.server.BaseServer;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class App extends BaseServer {
	public App(MicroAppConfig appConfig, Injector injector) {
		super(appConfig.getServerConfig(), injector);
	}
}
