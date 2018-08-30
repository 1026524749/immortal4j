package com.immortal.immortal4j.other;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.immortal.immortal4j.utils.InstanceUtil;

import java.util.List;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/30 2:34
 */
public class TestMain {
    public static  void main(String [] args){
        List<Children> childrenList = InstanceUtil.newArrayList();
        childrenList.add(new Children("111"));
        childrenList.add(new Children("222"));
        childrenList.add(new Children("444"));
        change(childrenList);
        System.out.println(JSON.toJSONString(childrenList));
    }
    public static void change(List parents){
        for (Object parent:parents){
            Parent parent1 = (Parent) parent;
            parent1.setName("1123");
        }
    }
}
