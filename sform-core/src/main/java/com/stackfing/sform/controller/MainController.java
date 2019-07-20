package com.stackfing.sform.controller;

import com.stackfing.sform.base.Column;
import com.stackfing.sform.base.Table;
import com.stackfing.sform.base.TableCreater;
import com.stackfing.sform.entity.Tables;
import com.stackfing.sform.mapper.TablesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午4:40 19-7-20
 */

@RestController
@RequestMapping("")
public class MainController {

	@Autowired
	private TablesMapper tableMapper;

	@Autowired
	private TableCreater tableCreater;

	@PostMapping("get")
	public Tables create(@RequestBody Table table) {
//		Column column = new Column("name", "varchar");
//		column.setLength(5);
//		Column c1 = new Column("age", "int");
//		c1.setComment("comment");
//		Table table = new Table("newTable");
//		c1.setIsPrimary(true);
//		table.addColumn(column);
//		table.addColumn(c1);
		tableCreater.createTable(table);
		return tableMapper.selectById(1);
	}
}
