package com.randomdelta.mstack.examples.usecases.ums;

import com.randomdelta.mstack.commons.injector.Injector;
import com.randomdelta.mstack.core.ServiceProvider;
import com.randomdelta.mstack.examples.usecases.ums.handlers.event.UserCreatedHandler;
import com.randomdelta.mstack.examples.usecases.ums.messages.event.UserCreated;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class NotificationService extends ServiceProvider {

	public NotificationService(Injector injector) {
		super(injector);
		registerEventHandler("UserService", UserCreated.class.getSimpleName(), UserCreatedHandler.class);
	}
}
