package com.randomdelta.mstack.examples.basics;

import com.randomdelta.mstack.commons.TMessage;
import com.randomdelta.mstack.core.server.BaseServer;
import com.randomdelta.mstack.core.server.ServerConfig;
import com.randomdelta.service.discovery.core.RFunction;

/**
 * @author Chamith_Nimmitha
 * @created 09/Mar/2025
 */
public class MultipleFunctions {

	public static void main(String[] args) throws InterruptedException {
		BaseServer baseServer = new BaseServer(ServerConfig.builder()
				.withServerId("Server1")
				.withFunction(RFunction.builder()
						.withName("MyFirstFunction")
						.withFuncType(MyFirstFunc.class).build())
				.withFunction(RFunction.builder()
						.withName("MySecondFunction")
						.withFuncType(MySecondFunction.class).build())
				.build());
		baseServer.start();

		baseServer.request("MySecondFunction", TMessage.builder().withData("Chamith").build()).subscribe(s -> System.out.println(s));

		Thread.sleep(1000);
	}
}
