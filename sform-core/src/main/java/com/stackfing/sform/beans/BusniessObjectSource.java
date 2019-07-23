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
	 * 键：属性注解名称   值：属性名称
	 */
	private Map<String, String> fields;

	public void addField(String annotationName, String fieldName) {
		if (fields == null) {
			this.fields = new HashMap<>();
		}
		this.fields.put(annotationName, fieldName);
	}

}
