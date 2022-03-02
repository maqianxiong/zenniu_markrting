package cn.doitedu.rule.engine.beans;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @program: zenniu_markrting
 * @author: Mr.Ma
 * @create: 2022-03-02 10:38
 * @desc规则条件封装对象，封装一个规则中的所有判断条件
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
public class RuleConditions {

    //规则ID
    private String ruleID;
    //触发事件
    private  EventParam triggerEvent;

    //画像属性条件
    private Map<String,String> userProfileConditions;

    //行为次数条件
    private List<EventParam> actionCountConditions;

    //行为序列条件
    private List<EventParam> actionSequenceCondition;

}
