package com.stackfing.sform.base;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午6:10 19-7-20
 */
public class ColumnInspector extends AbstractInspector<Column> {
	@Override
	protected void inspect(Column column) {
		if (column.getName().equals("table")) {
			throw new RuntimeException("敏感词汇！");
		}
	}
}
