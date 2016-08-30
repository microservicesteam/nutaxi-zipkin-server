package com.microservicesteam.nutaxi.zipkin;

import static com.google.common.base.Throwables.propagate;
import static org.apache.commons.io.FileUtils.deleteDirectory;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NutaxiZipkinServerApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	private static EmbeddedKafkaServer kafkaServer;

	@BeforeClass
	public static void init() {
		cleanup();
		kafkaServer = new EmbeddedKafkaServer(loadKafkaProperties(), loadZooKeeperProperties());
	}

	@Test
	public void contextLoads() {
		assertThat(applicationContext).isNotNull();
	}

	@AfterClass
	public static void tearDown() {
		kafkaServer.stop();
	}

	private static Properties loadZooKeeperProperties() {
		Properties zkProperties = new Properties();
		try {
			zkProperties.load(Class.class.getResourceAsStream("/zklocal.properties"));
		} catch (Exception e) {
			throw propagate(e);
		}
		return zkProperties;
	}

	private static Properties loadKafkaProperties() {
		Properties kafkaProperties = new Properties();

		try {
			kafkaProperties.load(Class.class.getResourceAsStream("/kafkalocal.properties"));
		} catch (Exception e) {
			throw propagate(e);
		}
		return kafkaProperties;
	}

	private static void cleanup() {
		try {
			File directory = new File("target/data");
			if (directory.exists()) {
				deleteDirectory(directory);
			}
		} catch (IOException e) {
			throw propagate(e);
		}
	}

}
