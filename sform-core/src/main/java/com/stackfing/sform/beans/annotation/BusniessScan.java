package com.stackfing.sform.beans.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BusniessScan {
	String[] value();
}
