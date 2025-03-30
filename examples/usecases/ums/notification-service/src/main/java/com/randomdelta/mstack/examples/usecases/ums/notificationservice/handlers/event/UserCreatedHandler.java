package com.randomdelta.mstack.examples.usecases.ums.notificationservice.handlers.event;

import com.randomdelta.mstack.core.event.EventContext;
import com.randomdelta.mstack.core.event.EventHandler;
import com.randomdelta.mstack.examples.usecases.ums.notificationservice.messages.event.UserCreated;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class UserCreatedHandler extends EventHandler<UserCreated> {


	@Override
	public void onEvent(EventContext eventContext, UserCreated userCreated) {
		System.out.println("Notification service -> Event received: " + userCreated);
	}
}
