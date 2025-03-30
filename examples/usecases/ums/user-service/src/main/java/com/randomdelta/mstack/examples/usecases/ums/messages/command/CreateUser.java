package com.randomdelta.mstack.examples.usecases.ums.messages.command;

import com.randomdelta.mstack.core.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser extends Command {

	private String username;
	private String password;
	private String email;
}
