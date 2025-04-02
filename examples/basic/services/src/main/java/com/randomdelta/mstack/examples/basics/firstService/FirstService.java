package com.randomdelta.mstack.examples.basics.firstService;

import com.randomdelta.mstack.commons.injector.Injector;
import com.randomdelta.mstack.core.ServiceProvider;
import com.randomdelta.mstack.examples.basics.firstService.handlers.command.FirstCommandHandler;
import com.randomdelta.mstack.examples.basics.firstService.handlers.event.FirstEventHandler;
import com.randomdelta.mstack.examples.basics.firstService.handlers.query.FirstQueryHandler;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class FirstService extends ServiceProvider {

	public FirstService(Injector injector) {
		super(injector);
		injector.nameBind("fieldInjectNumber", 5);
		injector.nameBind("paramInjectNumber", 10);

		// register all command handlers
		registerCommandHandler(FirstCommandHandler.class);

		// register all event handlers
		registerEventHandler("SecondService", "SecondEvent", FirstEventHandler.class);

		// register all query handlers
		registerQueryHandler(FirstQueryHandler.class);
	}
}
