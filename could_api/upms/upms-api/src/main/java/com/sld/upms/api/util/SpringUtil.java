/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: sdf
 * Author:   xutong
 * Date:     2019-07-03 17:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sld.upms.api.util;

/**
 * 〈一句话功能简述〉<br>
 * 〈Spring IOC上下文工具类〉
 *
 * @author xutong
 * @create 2019-07-03
 * @since 1.0.0
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {

    /**
     * 当前IOC
     */
    private static ApplicationContext applicationContext;

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 从当前IOC获取bean
     *
     * @param id bean的id
     * @return
     */
    public static Object getObject(String id) {
        Object object = null;
        object = applicationContext.getBean(id);
        return object;
    }

    /**
     * 设置当前上下文环境，此方法由spring自动装配
     */
    @Override
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        applicationContext = arg0;
    }

}