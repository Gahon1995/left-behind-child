package com.gahon.leftchild.utils;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Collections;

/**
 * @author Gahon
 */
public class SimplePropertyPreFilterEx extends SimplePropertyPreFilter {
    public SimplePropertyPreFilterEx(String... includeProperties) {
        super(null, includeProperties);
    }

    public SimplePropertyPreFilterEx(Class<?> clazz, String... includeProperties) {
        super(clazz, includeProperties);
    }

    public SimplePropertyPreFilterEx(Class<?> clazz, String[] includeProperties, String[] excludeProperties) {
        super(clazz, includeProperties == null ? new String[0] : includeProperties);
        if (excludeProperties != null && excludeProperties.length > 0) {
            Collections.addAll(getExcludes(), excludeProperties);
        }
    }
}