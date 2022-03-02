package cn.doitedu.rule.engine.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * @program: zenniu_markrting
 * @author: Mr.Ma
 * @create: 2022-03-02 10:3
 *
 * 规则条件中的表示一个事件条件的封装类
 **/
/**
 * 规则系统第一版
 * 需求：
 *    获得用户事件，计算如下规则，输出结果
 *    规则：
 *         触发事件：  K事件，事件属性（ p2=v1 ）
 *         画像属性条件: tag87=v2, tag26=v1
 *         行为次数条件： 2021-06-18 ~ 当前 , 事件 C [p6=v8,p12=v5] 做过 >= 2次
 */
@Data
@AllArgsConstructor
public class EventParam {
    private String eventID;
    private Map<String,String> eventProperties;
    private int countThreshHold;
    private long timeRangeStart;
    private long timeRangEnd;


}
