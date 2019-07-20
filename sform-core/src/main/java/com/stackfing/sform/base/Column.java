package com.stackfing.sform.base;

import lombok.Data;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午5:05 19-7-20
 */
@Data
public class Column implements Inspectable {

	private String name;

	private String type;

	private Integer length;

	private Boolean notNull = false;

	private Integer radix;

	private Boolean isPrimary = false;

	private Boolean isUnsigned = false;

	private String comment;

	public Column(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public void setLength(Integer length) {
		this.length = length;
		String type = this.type;
		type = type.concat("(" + length + ")");
		this.setType(type);
	}
}
