package com.randomdelta.mstack.examples.usecases.ums.userservice.messages.event;

import com.randomdelta.mstack.core.event.Event;
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
public class UserCreated extends Event {

	private String username;
	private String email;

}
