package com.github.dgt79.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.github.dgt79.rs.JaxRsApiApplication;
import com.github.dgt79.rs.UserRESTService;
import com.github.dgt79.service.UserService;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

@Configuration
public class AppConfig {
	@Bean (destroyMethod = "shutdown")
	public SpringBus cxf() {
		return new SpringBus();
	}

	@Bean
	public Server jaxRsServer() {
		JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(jaxRsApiApplication(), JAXRSServerFactoryBean.class);
		factory.setServiceBean(Arrays.asList(userRESTService()));
		factory.setAddress(factory.getAddress());
		factory.setProviders(Arrays.asList(jsonProvider()));
		return factory.create();
	}

	@Bean
	public JaxRsApiApplication jaxRsApiApplication() {
		return new JaxRsApiApplication();
	}

	@Bean
	public UserRESTService userRESTService() {
		return new UserRESTService();
	}

	@Bean
	public UserService userService() {
		return new UserService();
	}

	@Bean
	public JacksonJsonProvider jsonProvider() {
		return new JacksonJsonProvider();
	}
}
