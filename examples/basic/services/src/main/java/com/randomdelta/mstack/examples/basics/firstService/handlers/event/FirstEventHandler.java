package com.randomdelta.mstack.examples.basics.firstService.handlers.event;

import com.randomdelta.mstack.core.event.EventContext;
import com.randomdelta.mstack.core.event.EventHandler;
import com.randomdelta.mstack.examples.basics.firstService.messages.event.FirstEvent;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class FirstEventHandler extends EventHandler<FirstEvent> {

	@Override
	public void onEvent(EventContext eventContext, FirstEvent firstEvent) {
		// do something when event received.
		System.out.println("FirstEventHandler: " + firstEvent);
	}
}
