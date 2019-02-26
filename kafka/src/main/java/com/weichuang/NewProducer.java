package com.weichuang;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class NewProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        // 等待所有副本节点的应答
        props.put(ProducerConfig.ACKS_CONFIG,"all");
        props.put("bootstrap.servers", "hadoop101:9092");

        // key序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer producer = new KafkaProducer(props);
        for(int i=0;i<10;i++){
            ProducerRecord record = new ProducerRecord("first", String.valueOf(i));
            producer.send(record);
        }
        producer.close();

    }
}
