package com.github.dgt79;

import com.github.dgt79.config.AppConfig;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class App {
	public static void main(String[] args) throws Exception {
		final ServletHolder servletHolder = new ServletHolder(new CXFServlet());

		final ServletContextHandler context = new ServletContextHandler();
		context.setContextPath("/");
		context.addServlet(servletHolder, "/rest/*");
		context.addEventListener(new ContextLoaderListener());
		context.setInitParameter( "contextClass", AnnotationConfigWebApplicationContext.class.getName() );
		context.setInitParameter( "contextConfigLocation", AppConfig.class.getName() );

		final Server server = new Server(8080);
		server.setHandler(context);
		server.start();
		server.join();
	}
}
