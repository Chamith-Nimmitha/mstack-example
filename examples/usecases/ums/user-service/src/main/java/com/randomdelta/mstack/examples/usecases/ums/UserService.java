package com.randomdelta.mstack.examples.usecases.ums;

import com.randomdelta.mstack.commons.injector.Injector;
import com.randomdelta.mstack.core.ServiceProvider;
import com.randomdelta.mstack.examples.usecases.ums.handlers.command.CreateUserHandler;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class UserService extends ServiceProvider {

	public UserService(Injector injector) {
		super(injector);
		registerCommandHandler(CreateUserHandler.class);
	}
}
