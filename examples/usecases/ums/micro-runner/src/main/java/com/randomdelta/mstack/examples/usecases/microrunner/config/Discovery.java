package com.randomdelta.mstack.examples.usecases.microrunner.config;

import com.randomdelta.mstack.commons.Endpoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discovery {
	private int membershipPort;
	private String[] seeders;
	private Map<String, String> meta;

}
