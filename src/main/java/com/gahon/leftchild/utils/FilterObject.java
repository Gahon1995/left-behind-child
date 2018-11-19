package com.gahon.leftchild.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

/**
 * 过滤输出类，需传入Object和不过滤显示的类
 *
 * @author Gahon
 */
public class FilterObject {
    public static Object genFilterObject(Object object, String... showName) {
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(showName);
        return JSON.parseArray(JSON.toJSONString(object, filter));
    }
}
