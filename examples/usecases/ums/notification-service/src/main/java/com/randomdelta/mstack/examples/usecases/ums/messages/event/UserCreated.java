package com.randomdelta.mstack.examples.usecases.ums.messages.event;

import com.randomdelta.mstack.core.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */

@Data
@AllArgsConstructor
public class UserCreated extends Event {

	private String username;
	private String email;
}
