package com.stackfing.sform.base;

import lombok.Data;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午5:05 19-7-20
 */
@Data
public class Column implements Inspectable {

	//列名
	private String name;

	//类型
	private String type;

	//长度
	private Integer length;

	//是否为空
	private Boolean notNull = false;

	//小数点位数
	private Integer radix;

	//是否为主键
	private Boolean isPrimary = false;

	//是否为无符号
	private Boolean isUnsigned = false;

	//注释
	private String comment;

	//默认值
	private String columnDefault;

	public Column(String name, String type, Integer length) {
		this.name = name;
		this.type = type;
		this.length = length;
	}

	public Column() {

	}
}
