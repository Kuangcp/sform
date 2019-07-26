package com.stackfing.sform.controller;

import com.stackfing.sform.base.Table;
import com.stackfing.sform.base.TableCreater;
import com.stackfing.sform.beans.BusniessObjectSource;
import com.stackfing.sform.beans.scan.BoScanner;
import com.stackfing.sform.beans.scan.ClasspathBoScanner;
import com.stackfing.sform.mapper.TablesMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

	@Autowired
	private TablesMapper tablesMapper;

	@GetMapping("customSql")
	public List<Map<Object, Object>> customSql(@RequestParam String sql) {
		return tablesMapper.selectByCustom(sql);
//		return tablesMapper.selectByCustom("SELECT MONTH(createtime) as x, names as y FROM books");
	}

	@PostMapping("createTable")
	public String create(@RequestBody Table table) {
		tableCreater.createTable(table);
		return "创建成功！";
	}

	@GetMapping("getBusniessObject")
	public List<BusniessObjectSource> getDatasources() {
		BoScanner boScanner = new ClasspathBoScanner("com.stackfing.sform.vo");
		boScanner.scanPackage();
		return null;
	}

	@GetMapping("get")
	public void send() {
		List<String> maps = tablesMapper.selectColumnsByTable();
		System.out.println(maps);
		List<Map<Object, Object>> maps1 = tablesMapper.selectColumns(maps);
		System.out.println(maps1);
	}

	@GetMapping("getAllOptions")
	public List<Options> alloptions() {
		Options options = new Options("1", "第一个");
		Options options1 = new Options("2", "第二个");
		List<Options> list = new ArrayList<>();
		list.add(options);
		list.add(options1);
		return list;
	}
	@Data
	@AllArgsConstructor
	class Options {
		private String value;
		private String label;
	}
}
