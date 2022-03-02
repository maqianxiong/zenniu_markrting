package cn.doitedu.rule.engine.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 涛哥
 * @nick_name "deep as the sea"
 * @contact qq:657270652 wx:doit_edu
 * @site www.doitedu.cn
 * @date 2021-07-23
 * @desc 规则匹配计算结果
 */
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
public class RuleMatchResult {
    String deviceId;
    String ruleId;
    long trigEventTimestamp;
    long matchTimestamp;
}
