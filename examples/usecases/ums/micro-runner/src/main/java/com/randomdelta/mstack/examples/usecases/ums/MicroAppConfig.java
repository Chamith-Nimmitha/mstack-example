package com.randomdelta.mstack.examples.usecases.ums;

import com.randomdelta.mstack.core.server.ServerConfig;
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
	private ServerConfig serverConfig;
	private String deviceId;

	public MicroAppConfig(Builder builder) {
		this.serverConfig = builder.serverConfig;
		this.deviceId = builder.deviceId;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private ServerConfig serverConfig;
		private String deviceId;

		public Builder withDeviceId(String deviceId) {
			this.deviceId = deviceId;
			return this;
		}

		public Builder withServerConfig(ServerConfig serverConfig) {
			this.serverConfig = serverConfig;
			return this;
		}

		public MicroAppConfig build() {
			return new MicroAppConfig(this);
		}
	}
}
