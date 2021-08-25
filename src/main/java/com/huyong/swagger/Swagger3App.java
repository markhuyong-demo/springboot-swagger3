package com.huyong.swagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * swagger3集成演示及导出MarkDown格式文档
 *
 * @author zzs
 *
 */
@SpringBootApplication
public class Swagger3App {

	static Logger logger = LoggerFactory.getLogger(Swagger3App.class);

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application = SpringApplication.run(Swagger3App.class, args);
		Environment env = application.getEnvironment();
		String host = InetAddress.getLocalHost().getHostAddress();
		String port = env.getProperty("server.port");
		logger.info("\n----------------------------------------------------------\n\t"
				+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t\thttp://localhost:{}\n\t"
				+ "External: \t\thttp://{}:{}\n\t" + "Swagger 3 UI: \thttp://{}:{}/swagger-ui/index.html\n\t"
				+ "Knife4j Doc: \thttp://{}:{}/doc.html\n" + "----------------------------------------------------------",
				env.getProperty("spring.application.name"), port, host, port, host, port, host, port);
	}

}
