package cn.doitedu.rule.engine.utils;

/**
 * @program: zenniu_markrting
 * @author: Mr.Ma
 * @create: 2022-03-02 10:55
 * *adesc
 * 规则模拟器
 **/

import cn.doitedu.rule.engine.beans.EventParam;
import cn.doitedu.rule.engine.beans.RuleConditions;
import org.drools.core.rule.QueryArgument;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 规则系统第一版
 * 需求：
 *    获得用户事件，计算如下规则，输出结果
 *    规则：
 *         触发事件：  K事件，事件属性（ p2=v1 ）
 *         画像属性条件: tag87=v2, tag26=v1
 *         行为次数条件： 2021-06-18 ~ 当前 , 事件 C [p6=v8,p12=v5] 做过 >= 2次
 */

public class RuleMonitor {
     public static RuleConditions gerRule(){

         RuleConditions ruleConditions = new RuleConditions();
         ruleConditions.setRuleID("rule_001");
        //触发事件条件
         HashMap<String,String> map1 = new HashMap<>();
         map1.put(" p2","v1");
         EventParam eventParam = new EventParam("K",map1,0,-1,-1);
         ruleConditions.setTriggerEvent(eventParam);

        //画像属性条件
         HashMap<String,String> map2 = new HashMap<>();
         map2.put("tag87", "v2");
         map2.put( "tag26" , "v1");
         ruleConditions.setUserProfileConditions(map2);

        //行为次数条件列表
         HashMap<String,String> map3 = new HashMap<>();
         map3.put("p6", "v8");
         map3.put( "p12" , "v5");
         EventParam eventParam2 = new EventParam("C",map3,2,1623945600000L,Long.MAX_VALUE);

         ruleConditions.setActionSequenceCondition(Arrays.asList(eventParam2));

         return ruleConditions;



     }

}
