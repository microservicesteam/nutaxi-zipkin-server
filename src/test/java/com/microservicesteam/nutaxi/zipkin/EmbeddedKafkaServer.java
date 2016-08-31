package com.microservicesteam.nutaxi.zipkin;

import kafka.server.KafkaConfig;
import kafka.server.KafkaServerStartable;

import java.util.Properties;

public class EmbeddedKafkaServer {

    private KafkaServerStartable kafka;

    private EmbeddedZooKeeperServer zookeeper;

    public EmbeddedKafkaServer(Properties kafkaProperties, Properties zkProperties) {
        zookeeper = new EmbeddedZooKeeperServer(zkProperties);
        sleep();
        kafka = new KafkaServerStartable(new KafkaConfig(kafkaProperties));
        kafka.startup();
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        kafka.shutdown();
        zookeeper.stop();
    }

}
