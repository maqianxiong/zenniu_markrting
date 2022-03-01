```shell
# 启动zookeeper 
# 启动HDFS
# 启动hbase集群
[root@doit01 ~]# start-hbase.sh


# 启动客户端连接hbase
[root@hdp01 ~]# hbase shell
hbase> create 'zenniu_profile','f'

list
scan 'zenniu_profile'

count 'zenniu_profile'

scan 'zenniu_profile',{LIMIT=>10}


```

