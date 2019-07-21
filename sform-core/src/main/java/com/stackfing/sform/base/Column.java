package com.stackfing.sform.base;

import com.stackfing.sform.base.inspect.Inspectable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午5:05 19-7-20
 */
@Data
@NoArgsConstructor
public class Column implements Inspectable {

	//列名
	private String name;

	//类型
	private String type;

	//长度
	private Integer length;

	//是否为空
	private Boolean notnull = false;

	//小数点位数
	private Integer radix;

	//是否为主键
	private Boolean primary = false;

	//是否为无符号
	private Boolean unsigned = false;

	//注释
	private String comment;

	//默认值
	private String defaults;

	private Boolean autoIncrement;

}
