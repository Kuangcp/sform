package com.stackfing.sform.base.inspect;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午6:08 19-7-20
 */
public abstract class AbstractInspector<T> {

	protected List<Inspectable> inspectableList = new ArrayList<>();


	public abstract void inspect(T t);

}
