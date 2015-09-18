package com.ync365.seed.utils;

import org.apache.commons.beanutils.PropertyUtils;

public class CloneUtils {
    /**
     * 对象复制
     * 
     * @param from 原对象
     * @param to 目标对象
     */
    public static void cloneObject(Object from, Object to) {
        try {
            PropertyUtils.copyProperties(to, from);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("对象属性值复制时异常。" + e.getMessage());
        }
    }
}
