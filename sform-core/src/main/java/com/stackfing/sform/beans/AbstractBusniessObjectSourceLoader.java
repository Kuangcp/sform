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

    private final Class[] annotationClass = {Exclude.class};

    protected boolean isExcludeAnnotationPresent(AnnotatedElement annotatedElement) {
        for (int i = 0; i < annotationClass.length; i++) {
            if (annotatedElement.isAnnotationPresent(annotationClass[i])) {
                return true;
            }
        }
        return false;
//        return annotatedElement.isAnnotationPresent(Exclude.class);
    }

}
