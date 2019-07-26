package com.stackfing.sform.controller;

import com.stackfing.sform.base.Table;
import com.stackfing.sform.base.TableCreater;
import com.stackfing.sform.beans.BusniessObjectSource;
import com.stackfing.sform.beans.scan.BoScanner;
import com.stackfing.sform.beans.scan.ClasspathBoScanner;
import com.stackfing.sform.mapper.FormMapper;
import com.stackfing.sform.mapper.TablesMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
		Options options = new Options("1", "男生");
		Options options1 = new Options("2", "女生");
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

	@Autowired
	private FormMapper formMapper;

	@GetMapping("getFormByName/{name}")
	public String getForm(@PathVariable String name) {
		String s = formMapper.selectFormByName(name);
		return s;
//		String result = "{\"list\":[{\"type\":\"select\",\"name\":\"sex\",\"defaultValue\":\"\",\"disable\":true,\"placeholder\":\"请选择数据哦\",\"options\":{\"remote\":true,\"remoteUrl\":\"http://localhost:8080/getAllOptions\",\"label\":\"label\",\"value\":\"value\",\"remoteOption\":[],\"option\":[{\"label\":\"选项二\",\"value\":\"2\"},{\"label\":\"选项一\",\"value\":\"1\"}]}},{\"type\":\"input\",\"name\":\"age\",\"defaultValue\":\"\",\"disable\":false,\"placeholder\":\"\",\"options\":{}},{\"type\":\"button\",\"name\":\"按钮\",\"defaultValue\":\"asdd\",\"disable\":false,\"placeholder\":\"\",\"post\":false,\"options\":{\"callback\":\"alert(\\\"asdf\\\")\"}}],\"config\":{\"labelWidth\":100,\"labelPosition\":\"right\",\"size\":\"small\",\"customClass\":\"\"}}";
//		if (name.equals("buttonForm")) {
//			return result;
//		} else return null;
	}

	@GetMapping("getAllForm")
	public List<String> getAllForm() {
		return formMapper.selectAllForm();
	}
}
