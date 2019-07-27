package com.stackfing.sform.beans.support;

import com.stackfing.sform.beans.DefaultBusniessObjectSourceLoader;
import com.stackfing.sform.beans.BusniessObjectSource;
import com.stackfing.sform.beans.annotation.BusniessField;
import com.stackfing.sform.beans.annotation.BusniessObject;
import com.stackfing.sform.beans.enums.BoType;

import java.lang.reflect.Field;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午7:51 19-7-22
 * @Since:
 */
public class ViewObjetSourceLoader extends DefaultBusniessObjectSourceLoader {

    @Override
    public BusniessObjectSource loadBusniessObjectSource(Class<?> clz) {
        BusniessObjectSource bos = new BusniessObjectSource();
        if (clz.isAnnotationPresent(BusniessObject.class)) {
            BusniessObject annotation = clz.getAnnotation(BusniessObject.class);
            //设置业务对象名称
            bos.setTableName(annotation.value());
            bos.setType(BoType.VO.getType());
            Field[] declaredFields = clz.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                BusniessField fieldAnnotation = field.getAnnotation(BusniessField.class);
                if (fieldAnnotation != null && fieldAnnotation.value() != null && ! isExcludeAnnotationPresent(field)) {
                    bos.addField(field.getName(), fieldAnnotation.value());
                }
            }
        }
        return bos;
    }
}
