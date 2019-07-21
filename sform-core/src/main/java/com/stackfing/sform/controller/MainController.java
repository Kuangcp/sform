package com.stackfing.sform.controller;

import com.stackfing.sform.base.Table;
import com.stackfing.sform.base.TableCreater;
import com.stackfing.sform.mapper.TablesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午4:40 19-7-20
 */

@RestController
@RequestMapping("")
public class MainController {

	@Autowired
	private TableCreater tableCreater;

	@PostMapping("createTable")
	public String create(@RequestBody Table table) {
		tableCreater.createTable(table);
		return "创建成功！";
	}
}
