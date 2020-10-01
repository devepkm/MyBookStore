package com.devepkm.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Auther: dev
 * @Date: 1/10/2020 09:26
 * @Description: Web layer utils
 */
public class WebUtils {


    /**
     *  inject paras to bean obj
     * @param bean bean empty bean obj
     * @param map params need to be injected
     * @param <T> bean obj
     * @return
     */
    public static <T> T injectBean(T bean, Map map) {

        try {
            BeanUtils.populate(bean, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return bean;

    }


}
