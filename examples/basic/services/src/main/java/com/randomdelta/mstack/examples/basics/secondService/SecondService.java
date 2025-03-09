package com.randomdelta.mstack.examples.basics.secondService;

import com.randomdelta.mstack.commons.injector.Injector;
import com.randomdelta.mstack.core.ServiceProvider;
import com.randomdelta.mstack.examples.basics.secondService.handlers.command.SecondCommandHandler;


/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class SecondService extends ServiceProvider {

	public SecondService(Injector injector) {
		super(injector);

		// register all command handlers
		registerCommandHandler(SecondCommandHandler.class);
	}
}
