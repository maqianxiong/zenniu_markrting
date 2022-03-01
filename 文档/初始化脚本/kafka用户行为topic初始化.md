- 行为日志topic创建
```shell
[root@hdp01 kafka_2.11-2.0.0]# bin/kafka-topics.sh --create   \
--topic zenniu_applog  \
--partitions 2     \
--replication-factor 1    \
--zookeeper hadoop102:2181,hadoop103:2181,hadoop104:2181
```

- 查看topic
```
[root@hdp01 kafka_2.11-2.0.0]# bin/kafka-topics.sh --list --zookeeper hadoop102:2181
```

- 消费测试
```shell
[root@hdp01 kafka_2.11-2.0.0]# bin/kafka-console-consumer.sh --topic zenniu_applog --bootstrap-server hadoop102:9092
```