package com.stackfing.sform.beans;

import com.stackfing.sform.beans.annotation.Exclude;

import java.lang.reflect.AnnotatedElement;

/**
 * @Author: fing
 * @Description: 所有子类公用代码
 * @Date: 下午7:18 19-7-22
 * @Since:
 */
public abstract class AbstractBusniessObjectSourceLoader implements BusniessObjectSourceLoader {


    protected boolean isAnnotationPresent(AnnotatedElement annotatedElement) {
        return annotatedElement.isAnnotationPresent(Exclude.class);
    }

}
