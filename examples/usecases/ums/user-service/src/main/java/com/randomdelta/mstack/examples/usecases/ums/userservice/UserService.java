package com.randomdelta.mstack.examples.usecases.ums.userservice;

import com.randomdelta.mstack.common.injector.Injector;
import com.randomdelta.mstack.core.ServiceProvider;
import com.randomdelta.mstack.examples.usecases.ums.userservice.handlers.command.CreateUserHandler;

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
