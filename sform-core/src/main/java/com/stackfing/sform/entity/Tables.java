package com.stackfing.sform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午10:21 19-7-11
 */
@Data
@TableName("tables")
public class Tables {

	@TableId
	@ApiModelProperty("id")
	private Integer id;

	@TableField
	@ApiModelProperty("名称")
	private String name;

}
