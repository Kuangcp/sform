package com.stackfing.sform.beans;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午7:16 19-7-22
 * @Since:
 */

@Data
public class BusniessObjectSource {

	private String tableName;

	/**
	 * 键：属性名称   值：注解属性
	 */
	private Map<String, String> fields;

	/**
	 * 不同种类的对象，vo/entity
	 */
	private int type;

	public void addField(String fieldName, String annotationName) {
		if (fields == null) {
			this.fields = new HashMap<>();
		}
		this.fields.put(fieldName, annotationName);
		this.type = type;
	}

}
