package com.randomdelta.mstack.examples.usecases.ums.userservice.handlers.command;

import com.randomdelta.mstack.core.GenericResponse;
import com.randomdelta.mstack.core.command.CommandContext;
import com.randomdelta.mstack.core.command.CommandHandler;
import com.randomdelta.mstack.examples.usecases.ums.userservice.messages.command.CreateUser;
import com.randomdelta.mstack.examples.usecases.ums.userservice.messages.event.UserCreated;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class CreateUserHandler extends CommandHandler<CreateUser, GenericResponse> {

	@Override
	public GenericResponse execute(CommandContext commandContext, CreateUser createUser) {

		System.out.println("Command received: " + createUser);
		// validate and save user in DB

		// Emit event
		UserCreated userCreated = new UserCreated(createUser.getUsername(), createUser.getEmail());
		commandContext.applyEvent(userCreated);

		return GenericResponse.builder()
				.code(200)
				.success(true)
				.message("User created successfully")
				.build();
	}
}
