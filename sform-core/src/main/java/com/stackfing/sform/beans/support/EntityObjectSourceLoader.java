package com.stackfing.sform.beans.support;

import com.baomidou.mybatisplus.annotation.TableName;
import com.stackfing.sform.beans.DefaultBusniessObjectSourceLoader;
import com.stackfing.sform.beans.BusniessObjectSource;
import com.stackfing.sform.beans.enums.BoType;
import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午7:52 19-7-22
 * @Since:
 */
public class EntityObjectSourceLoader extends DefaultBusniessObjectSourceLoader {


	@Override
	public BusniessObjectSource loadBusniessObjectSource(Class<?> clz) {
		BusniessObjectSource bos = new BusniessObjectSource();
		if (clz.isAnnotationPresent(TableName.class)) {
			TableName annotation = clz.getAnnotation(TableName.class);
			//设置业务对象名称
			bos.setTableName(annotation.value());
            bos.setType(BoType.ENTITY.getType());
			Field[] declaredFields = clz.getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
                ApiModelProperty fieldAnnotation = field.getAnnotation(ApiModelProperty.class);
				if (fieldAnnotation != null && fieldAnnotation.value() != null && ! isExcludeAnnotationPresent(field)) {
					bos.addField(field.getName(), fieldAnnotation.value());
				}
			}
		}
		return bos;
	}

}