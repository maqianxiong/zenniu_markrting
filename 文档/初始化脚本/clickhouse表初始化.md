- 启动clickhouse服务
```shell
# 启动服务
[root@hdp03 ~]# sudo systemctl start clickhouse-server

# 查看状态
[root@hdp03 ~]# sudo systemctl status clickhouse-server

#客户端连接
[root@hdp03 ~]# sudo  clickhouse-client -h hadoop102 -m
```

```sql
-- 创建用户行为日志明细表   允许实验的特性 map
set allow_experimental_map_type = 1;
drop table if exists  default.zenniu_detail;
create table default.zenniu_detail
(
    account           String   ,
    appId             String   ,
    appVersion        String   ,
    carrier           String   ,
    deviceId          String   ,
    deviceType        String   ,
    eventId           String   ,
    ip                String   ,
    latitude          Float64  ,
    longitude         Float64  ,
    netType           String   ,
    osName            String   ,
    osVersion         String   ,
    properties        Map(String,String),
    releaseChannel    String,
    resolution        String,
    sessionId         String,
    timeStamp         Int64 ,
    INDEX u (deviceId) TYPE minmax GRANULARITY 3,
    INDEX t (timeStamp) TYPE minmax GRANULARITY 3
) ENGINE = MergeTree()
ORDER BY (deviceId,timeStamp)
;

-- 创建kafka引擎表
drop table if exists default.zenniu_detail_kafka;
create table default.zenniu_detail_kafka
(
    account           String   ,
    appId             String   ,
    appVersion        String   ,
    carrier           String   ,
    deviceId          String   ,
    deviceType        String   ,
    eventId           String   ,
    ip                String   ,
    latitude          Float64  ,
    longitude         Float64  ,
    netType           String   ,
    osName            String   ,
    osVersion         String   ,
    properties        Map(String,String),
    releaseChannel    String,
    resolution        String,
    sessionId         String,
    timeStamp         Int64
) ENGINE = Kafka('hadoop102:9092,hadoop103:9092,hadoop104:9092','zenniu_applog','group1','JSONEachRow')
;

show tables;
-- 创建物化视图（桥接kafka引擎表和事件明细表）
drop view zenniu_view;
create MATERIALIZED VIEW zenniu_view TO zenniu_detail
as
select
    account        ,
    appId          ,
    appVersion     ,
    carrier        ,
    deviceId       ,
    deviceType     ,
    eventId        ,
    ip             ,
    latitude       ,
    longitude      ,
    netType        ,
    osName         ,
    osVersion      ,
    properties     ,
    releaseChannel  ,
    resolution      ,
    sessionId       ,
    timeStamp
from zenniu_detail_kafka
;

select count(1) from zenniu_detail;

select * from zenniu_detail limit 10;

select distinct eventId from zenniu_detail ;

select eventId , properties from zenniu_detail where eventId='K' limit 10;


```