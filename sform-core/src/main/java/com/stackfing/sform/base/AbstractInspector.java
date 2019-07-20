package com.stackfing.sform.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午6:08 19-7-20
 */
public abstract class AbstractInspector<T> {

	protected List<Inspectable> inspectableList = new ArrayList<>();


	protected abstract void inspect(T t);

}
