package com.stackfing.sform.base;

import com.stackfing.sform.base.inspect.AbstractInspector;
import com.stackfing.sform.base.inspect.support.ColumnInspector;
import com.stackfing.sform.base.inspect.support.TableInspector;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午5:59 19-7-20
 */
public abstract class AbstractTableCreator implements TableCreater {

	protected List<AbstractInspector> inspectAbleList = new ArrayList<>();

	public AbstractTableCreator() {
		inspectAbleList.add(new ColumnInspector());
		inspectAbleList.add(new TableInspector());
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
		AbstractInspector<Column> columnInspector = new ColumnInspector();
		for (Column column : table.getColumns()) {
			columnInspector.inspect(column);
		}
		AbstractInspector<Table> tableInspector = new TableInspector();
		tableInspector.inspect(table);
	}
}
