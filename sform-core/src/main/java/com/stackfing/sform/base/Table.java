package com.stackfing.sform.base;

import javafx.scene.control.Tab;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午5:15 19-7-20
 */
@Data
public class Table implements Inspectable {

	private List<Column> columns = new ArrayList<>();

	private String tableName;

	public Table() {

	}

	public Table(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 加入一列
	 * @param column
	 */
	public void addColumn(Column column) {
		this.columns.add(column);
	}

	/**
	 * 加入多列
	 * @param columns
	 */
	public void addColumns(List<Column> columns) {
		this.columns.addAll(columns);
	}
}
