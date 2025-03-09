package com.randomdelta.mstack.examples.basics.firstService.handlers.event;

import com.randomdelta.mstack.core.event.Event;
import com.randomdelta.mstack.core.event.EventContext;
import com.randomdelta.mstack.core.event.EventHandler;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class FirstEventHandler extends EventHandler {


	@Override
	public void onEvent(EventContext eventContext, Event event) {
		// do something when event received.
		System.out.println("Event: " + eventContext);
	}
}
