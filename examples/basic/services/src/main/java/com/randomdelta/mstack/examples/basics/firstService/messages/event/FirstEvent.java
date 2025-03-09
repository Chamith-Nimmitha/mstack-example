package com.randomdelta.mstack.examples.basics.firstService.messages.event;

import com.randomdelta.mstack.core.event.Event;
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
public class FirstEvent extends Event {
	private String firstName;
}
