package com.stackfing.sform.beans.annotation;

import java.lang.annotation.*;

/**
 * @Author: fing
 * @Description: 不被扫描到的包名
 * @Date: 2019/7/23
 * @Since:
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface Exclude {
}
