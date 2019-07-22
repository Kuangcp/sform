package com.stackfing.sform.beans.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BusniessObject {

	/**
	 * 业务对象名
	 * @return
	 */
	String value();
}
