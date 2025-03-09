package com.randomdelta.mstack.examples.basics.secondService.messages.command;

import com.randomdelta.mstack.core.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SecondCommand extends Command {

	private String firstName;
	private String lastName;
	private int age;
	private String city;

}
