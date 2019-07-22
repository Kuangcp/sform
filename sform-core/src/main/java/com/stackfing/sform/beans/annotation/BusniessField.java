package com.stackfing.sform.beans.annotation;

import java.lang.annotation.*;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午8:27 19-7-22
 * @Since:
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BusniessField {

	/**
	 * 属性名
	 * @return
	 */
	String value();
}
