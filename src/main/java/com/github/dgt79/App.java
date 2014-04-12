package com.github.dgt79;

import org.eclipse.jetty.server.Server;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

public class App {
	final static String PORT = "port";

	public static void main(String... args) throws Exception {
		Yaml yamlConfig = new Yaml();
		final Map config = (Map<String, String>) yamlConfig.load(new FileInputStream(new File(".config.yml")));


		Server server = new Server((Integer) config.get(PORT));


		server.start();

	}
}
