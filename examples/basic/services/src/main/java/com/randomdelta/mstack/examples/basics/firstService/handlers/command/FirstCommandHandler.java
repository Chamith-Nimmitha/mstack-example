package com.randomdelta.mstack.examples.basics.firstService.handlers.command;

import com.randomdelta.mstack.commons.RequestHeaders;
import com.randomdelta.mstack.commons.injector.Named;
import com.randomdelta.mstack.core.GenericResponse;
import com.randomdelta.mstack.core.command.CommandContext;
import com.randomdelta.mstack.core.command.CommandHandler;
import com.randomdelta.mstack.examples.basics.firstService.messages.command.FirstCommand;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class FirstCommandHandler extends CommandHandler<FirstCommand, GenericResponse> {


	public FirstCommandHandler(@Named(name ="paramInjectNumber") int paramInjectNumber) {
		System.out.println("paramInjectNumber: " + paramInjectNumber);
	}

	@Override
	public GenericResponse execute(CommandContext commandContext, FirstCommand firstCommand) {

		System.out.println("Command Received: " + firstCommand);
		// persist user in the database

		return GenericResponse.builder()
				.success(true)
				.code(RequestHeaders.CODES.OK.getCode())
				.data("Success.")
				.build();
	}
}
