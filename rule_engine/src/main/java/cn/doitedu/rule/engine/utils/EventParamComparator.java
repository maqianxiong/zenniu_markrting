package cn.doitedu.rule.engine.utils;

import cn.doitedu.rule.engine.beans.EventBean;
import cn.doitedu.rule.engine.beans.EventParam;

import java.util.Set;

/**
 * @program: zenniu_markrting
 * @author: Mr.Ma大:
 * 比较规则条件中的事件条件和实时事件是否匹配
 * @create: 2022-03-02 11:28
 **/
public class EventParamComparator {

    public static boolean compare(EventParam param1,EventParam target){
        if(param1.getEventID().equals(target.getEventID())){
            Set<String> keys = param1.getEventProperties().keySet();
            for (String key : keys) {
                String targetValue = target.getEventProperties().get(key);
                if(!param1.getEventProperties().get(key).equals(targetValue)) return false;
            }
            return true;
        }
        return false;
    }

    public static boolean compare(EventParam param1, EventBean target){
        if(param1.getEventID().equals(target.getEventId())){
            Set<String> keys = param1.getEventProperties().keySet();
            for (String key : keys) {
                String targetValue = target.getProperties().get(key);
                if(!param1.getEventProperties().get(key).equals(targetValue)) return false;
            }
            return true;
        }
        return false;
    }




}
