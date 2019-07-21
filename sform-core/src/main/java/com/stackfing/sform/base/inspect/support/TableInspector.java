package com.stackfing.sform.base.inspect.support;


import com.stackfing.sform.base.Column;
import com.stackfing.sform.base.Table;
import com.stackfing.sform.base.inspect.AbstractInspector;
import com.stackfing.sform.exception.TableException;

import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午6:13 19-7-20
 */
public class TableInspector extends AbstractInspector<Table> {
	@Override
	public void inspect(Table table) {
		if (isDigit(table.getTableName())) {
			throw new TableException("表名不能为纯数字");
		}
		List<Column> columns = table.getColumns();
		int size = 0;
		for (Column column : columns) {
			if (column.getAutoIncrement() != null && column.getPrimary() != null) {
				if (column.getAutoIncrement() == true && column.getPrimary() == false) {
					throw new RuntimeException("列名：" + column.getName() + " 必须为 key！");
				}
			}
			if (column.getPrimary() == true) {
				size++;
			}
		}
		if (size > 1) {
			throw new RuntimeException("不能存在两个主键！");
		}
	}

	private boolean isDigit(String str) {
		return str.matches("[0-9]+");
	}
}
