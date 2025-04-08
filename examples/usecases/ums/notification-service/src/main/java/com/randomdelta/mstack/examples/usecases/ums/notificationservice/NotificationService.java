package com.randomdelta.mstack.examples.usecases.ums.notificationservice;

import com.randomdelta.mstack.common.injector.Injector;
import com.randomdelta.mstack.core.ServiceProvider;
import com.randomdelta.mstack.examples.usecases.ums.notificationservice.messages.event.UserCreated;
import com.randomdelta.mstack.examples.usecases.ums.notificationservice.handlers.event.UserCreatedHandler;

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
