package cn.doitedu.rule.engine.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data               //所有的get和set
@NoArgsConstructor  //空参构造
@AllArgsConstructor //所有参数的构造
@ToString           //
public class EventBean {

    private String account        ;
    private String appId          ;
    private String appVersion     ;
    private String carrier        ;
    private String deviceId       ;
    private String deviceType     ;
    private String ip             ;
    private double latitude       ;
    private double longitude      ;
    private String netType        ;
    private String osName         ;
    private String osVersion      ;
    private String releaseChannel ;
    private String resolution     ;
    private String sessionId      ;
    private long timeStamp        ;
    private String EventId        ;
    private Map<String,String> properties;

    // 在添加动态keyby后添加的一个功能字段
    private String keyByValue;

}
