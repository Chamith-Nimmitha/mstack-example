package com.randomdelta.mstack.examples.usecases.microrunner.config;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */

@NoArgsConstructor
@Data
public class ConfigFile {
	private Server server;
	private Discovery discovery;
}
