package com.randomdelta.mstack.examples.usecases.ums;

import com.randomdelta.authenticator.Authenticator;
import com.randomdelta.logger.LoggerFactory;
import com.randomdelta.mstack.commons.exception.ClassUtilException;
import com.randomdelta.mstack.commons.injector.InjectorImpl;
import com.randomdelta.mstack.commons.utils.ClassUtils;
import com.randomdelta.mstack.commons.utils.YamlUtils;
import com.randomdelta.mstack.core.server.ServerConfig;
import com.randomdelta.mstack.examples.usecases.ums.config.AppConfigException;
import com.randomdelta.mstack.examples.usecases.ums.config.ConfigFile;
import com.randomdelta.mstack.examples.usecases.ums.config.Server;
import com.randomdelta.service.discovery.core.RFunction;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * @author Chamith_Nimmitha
 * @created 30/Mar/2025
 */
public class AppStarter {
	private static final Logger logger = LoggerFactory.getLogger(AppStarter.class);
	private App app;


	public AppStarter(String configFileName) {
		ConfigFile configFile = null;
		try {
			configFile = YamlUtils.readFromFile(new File(configFileName), ConfigFile.class);
		} catch (IOException e) {
			logger.error("Pos app configuration failed. FileName: {}, Exception: {}", configFileName, e);
			System.exit(1);
		}

		MicroAppConfig.Builder finalConfigBuilder = MicroAppConfig.builder();

		ServerConfig serverConfig = createServerConfig(configFile.getServer());
		finalConfigBuilder.withServerConfig(serverConfig);

		MicroAppConfig posAppConfig = finalConfigBuilder.build();
		InjectorImpl injector = new InjectorImpl();


		this.app = new App(posAppConfig, injector);
	}

	public void start() {
		app.start();
	}

	private static ServerConfig createServerConfig(Server serverConfig) {
		ServerConfig.Builder serverCondifBuilder = ServerConfig.builder();

		if {
			serverCondifBuilder.withServerId(serverConfig.getServerId());
		}

		if(serverConfig.getServicePort() != 0) {
			serverCondifBuilder.withServicePort(serverConfig.getServicePort());
		}

		if(serverConfig.getFunctions() != null && serverConfig.getFunctions().size() >0) {
			serverConfig.getFunctions().forEach(rFunction -> {
				try {
					serverCondifBuilder.withFunction(RFunction.builder()
							.withName(rFunction.getName())
							.withFuncType(ClassUtils.forName(rFunction.getType()))
							.build());
				} catch (ClassUtilException e) {
					logger.error("Function not found. Name: {}, Type: {}", rFunction.getName(), rFunction.getType());
					throw new AppConfigException("Function not found. Name:" + rFunction.getName() +
							", Type: " + rFunction.getType());
				}
			});
		}

		if(serverConfig.getProviders() != null && serverConfig.getProviders().size() >0) {
			serverConfig.getProviders().forEach(rFunction -> {
				try {
					serverCondifBuilder.withProvider(RFunction.builder()
							.withName(rFunction.getName())
							.withFuncType(ClassUtils.forName(rFunction.getType()))
							.build());
				} catch (ClassUtilException e) {
					logger.error("Provider not found. Name: {}, Type: {}", rFunction.getName(), rFunction.getType());
					throw new AppConfigException("Provider not found. Name:" + rFunction.getName() +
							", Type: " + rFunction.getType());
				}
			});
		}

		if(serverConfig.getAuthenticator() != null) {
			Class<Object> authClass = ClassUtils.forName(serverConfig.getAuthenticator());
			try {
				Authenticator authenticator = (Authenticator)authClass.newInstance();
				serverCondifBuilder.withAuthenticator(authenticator);
			} catch (InstantiationException e) {
				logger.error("Failed to create Authenticator instance. ClassName: {}, Exception: {}",
						serverConfig.getAuthenticator(), e);
				throw new PosAppConfigException("Failed to create Authenticator instance. ClassName: " +
						serverConfig.getAuthenticator()+ " , Exception: " + e);
			} catch (IllegalAccessException e) {
				logger.error("Failed to create Authenticator instance. ClassName: {}, Exception: {}",
						serverConfig.getAuthenticator(), e);
				throw new PosAppConfigException("Failed to create Authenticator instance. ClassName: " +
						serverConfig.getAuthenticator()+ " , Exception: " + e);
			}
		}
		return serverCondifBuilder.build();
	}

	public PosApp getPosApp() {
		return posApp;
	}
}