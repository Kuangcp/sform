package com.stackfing.sform.beans;

import com.baomidou.mybatisplus.annotation.TableName;
import com.stackfing.sform.beans.annotation.BusniessObject;
import com.stackfing.sform.beans.annotation.Exclude;
import com.stackfing.sform.beans.support.EntityObjectSourceLoader;
import com.stackfing.sform.beans.support.ViewObjetSourceLoader;
import io.swagger.annotations.ApiModelProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: fing
 * @Description: 所有子类公用代码
 * @Date: 下午7:18 19-7-22
 * @Since:
 */
public class DefaultBusniessObjectSourceLoader implements BusniessObjectSourceLoader {

    /**
     * 排除列表（有此标注的类、属性都不会被加载）
     */
    private static final Class[] annotationClass = {Exclude.class};

    /**
     * 用于不同类型类的加载器 注解:加载器
     */
    protected static final Map<Class<?>, Class<?>> map = new ConcurrentHashMap<>();

    {
        this.map.put(TableName.class, EntityObjectSourceLoader.class);
        this.map.put(BusniessObject.class, ViewObjetSourceLoader.class);
    }

    /**
     * 用于新的子类注册
     * @param clz
     */
    protected void registerLoader(Class<?> clz) {
        this.map.put(clz, this.getClass());
    }

    /**
     * 通过查表找到对应的加载器来加载类
     * @param clz
     * @return
     */
    @Override
    public BusniessObjectSource loadBusniessObjectSource(Class<?> clz) {
        Set<Class<?>> classes = map.keySet();
        Iterator<Class<?>> iterator = classes.iterator();
        while (iterator.hasNext()) {
            Class<?> key = iterator.next();
            Class<?> target = map.get(key);
            if (isExcludeAnnotationPresent(clz)) {
                continue;
            }
            //根据注解判断是否为map中存有的key  anno == key
            if (clz.isAnnotationPresent((Class<? extends Annotation>) key)) {
                try {
                    BusniessObjectSourceLoader bos = (BusniessObjectSourceLoader) target.newInstance();
                    return bos.loadBusniessObjectSource(clz);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

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
