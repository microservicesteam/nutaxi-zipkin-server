package com.microservicesteam.nutaxi.zipkin;

import kafka.server.KafkaConfig;
import kafka.server.KafkaServerStartable;

import java.util.Properties;

public class EmbeddedKafkaServer {

    private KafkaServerStartable kafka;

    private EmbeddedZooKeeperServer zookeeper;

    public EmbeddedKafkaServer(Properties kafkaProperties, Properties zkProperties) {
        zookeeper = new EmbeddedZooKeeperServer(zkProperties);
        kafka = new KafkaServerStartable(new KafkaConfig(kafkaProperties));
        kafka.startup();
    }

    public void stop() {
        kafka.shutdown();
        zookeeper.stop();
    }

}
