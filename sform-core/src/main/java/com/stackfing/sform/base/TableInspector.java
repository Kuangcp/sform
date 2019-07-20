package com.stackfing.sform.base;


import com.stackfing.sform.exception.TableException;

import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午6:13 19-7-20
 */
public class TableInspector extends AbstractInspector<Table> {
	@Override
	protected void inspect(Table table) {
		if (isDigit(table.getTableName())) {
			throw new TableException("表名不能为纯数字");
		}
		List<Column> columns = table.getColumns();
		int size = 0;
		for (Column column : columns) {
			if (column.getIsPrimary() == true) {
				size++;
			}
		}
		if (size > 1) {
			throw new RuntimeException("不能存在两个组件！");
		}
	}

	private boolean isDigit(String str) {
		return str.matches("[0-9]+");
	}
}
