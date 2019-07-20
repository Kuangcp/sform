package com.stackfing.sform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午10:21 19-7-11
 */
@Data
public class Tables {

	@TableId
	private Integer id;

	@TableField
	private String name;

}
