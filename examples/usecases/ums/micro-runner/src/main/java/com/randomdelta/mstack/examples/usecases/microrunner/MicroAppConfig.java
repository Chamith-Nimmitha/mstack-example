package com.randomdelta.mstack.examples.usecases.microrunner;

import com.randomdelta.mstack.MicroServerConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class MicroAppConfig {
	private MicroServerConfig microServerConfig;

	public MicroAppConfig(Builder builder) {
		this.microServerConfig = builder.microServerConfig;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private MicroServerConfig microServerConfig;
		private String deviceId;

		public Builder withDeviceId(String deviceId) {
			this.deviceId = deviceId;
			return this;
		}

		public Builder withServerConfig(MicroServerConfig microServerConfig) {
			this.microServerConfig = microServerConfig;
			return this;
		}

		public MicroAppConfig build() {
			return new MicroAppConfig(this);
		}
	}
}
