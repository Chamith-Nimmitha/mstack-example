package com.randomdelta.mstack.examples.basics.secondService.handlers.command;

import com.randomdelta.mstack.commons.RequestHeaders;
import com.randomdelta.mstack.core.GenericResponse;
import com.randomdelta.mstack.core.command.CommandContext;
import com.randomdelta.mstack.core.command.CommandHandler;
import com.randomdelta.mstack.examples.basics.secondService.messages.command.SecondCommand;
import com.randomdelta.mstack.examples.basics.secondService.messages.event.SecondEvent;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class SecondCommandHandler extends CommandHandler<SecondCommand, GenericResponse> {

	@Override
	public GenericResponse execute(CommandContext commandContext, SecondCommand secondCommand) {

		System.out.println("SecondCommandHandler: " + secondCommand);
		// persist user in the database
		SecondEvent firstEvent = new SecondEvent(secondCommand.getFirstName());
		commandContext.applyEvent(firstEvent);

		return GenericResponse.builder()
				.success(true)
				.code(RequestHeaders.CODES.OK.getCode())
				.data("Success.")
				.build();
	}
}