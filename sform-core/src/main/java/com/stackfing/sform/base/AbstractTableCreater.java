package com.stackfing.sform.base;

import javafx.scene.control.Tab;

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

	@Override
	public void createTable(Table table) {
		prepareCreateTable(table);
		create(table);
	}

	protected abstract void create(Table table);

	private void prepareCreateTable(Table table) {
		ColumnInspector columnInspector = new ColumnInspector();
		for (Column column : table.getColumns()) {
			columnInspector.inspect(column);
		}
		TableInspector tableInspector = new TableInspector();
		tableInspector.inspect(table);
	}
}
