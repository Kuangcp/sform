package com.stackfing.sform.base;


import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午6:13 19-7-20
 */
public class TableInspector extends AbstractInspector<Table> {
	@Override
	protected void inspect(Table table) {
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
//		int size = columns.stream().filter(item -> item.getIsPrimary() == true).collect(Collectors.toList()).size();
//		if (size > 1) {
//			//继续
//			throw new RuntimeException("不能存在两个主键！");
//		}
	}
}
