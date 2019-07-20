package com.stackfing.sform.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午5:59 19-7-20
 */
public abstract class AbstractTableCreater implements TableCreater {

	protected List<AbstractInspector> inspectableList = new ArrayList<>();

	public AbstractTableCreater() {
		inspectableList.add(new ColumnInspector());
		inspectableList.add(new TableInspector());
	}

	/**
	 * 子类重写此方法，用于真正的表创建逻辑
	 * @param table
	 */
	protected abstract void create(Table table);

	@Override
	public void createTable(Table table) {
		//建表前需要检查表是否按照规则创建
		prepareCreateTable(table);
		create(table);
	}


	/**
	 * 用于检测表中的列是否合规
	 * @param table
	 */
	private void prepareCreateTable(Table table) {
		ColumnInspector columnInspector = new ColumnInspector();
		for (Column column : table.getColumns()) {
			columnInspector.inspect(column);
		}
		TableInspector tableInspector = new TableInspector();
		tableInspector.inspect(table);
	}
}
