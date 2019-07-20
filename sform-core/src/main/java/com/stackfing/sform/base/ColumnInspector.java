package com.stackfing.sform.base;

import com.stackfing.sform.exception.ColumnException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午6:10 19-7-20
 */
public class ColumnInspector extends AbstractInspector<Column> {

	private List<String> excludeColumnName = new ArrayList<>(Arrays.asList(new String[]{"table", "name"}));

	private List<String> types = new ArrayList<>(Arrays.asList(new String[]{"varchar", "int", "bigint"}));

	/**
	 * 检查列是否正常
	 * @param column
	 */
	@Override
	protected void inspect(Column column) {
		excludeColumnName(column);
		inspectType(column);
	}

	/**
	 * 检查类型
	 * @param column
	 */
	private void inspectType(Column column) {
		if (!types.contains(column.getType())) {
			throw new ColumnException("类型错误！");
		}
	}

	/**
	 * 检查名称
	 * @param column
	 */
	private void excludeColumnName(Column column) {
		if (column.getName() == null || column.getName().equals("")) {
			throw new ColumnException("列名不能为空！");
		}
		for (String name : excludeColumnName) {
			if (name.equalsIgnoreCase(column.getName())) {
				throw new ColumnException("列名" + column.getName() + "不能为敏感名称！");
			}
		}
	}
}
