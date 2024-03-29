package com.stackfing.sform.base.support;

import com.stackfing.sform.base.AbstractTableCreator;
import com.stackfing.sform.base.Table;
import com.stackfing.sform.mapper.TablesMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午5:54 19-7-20
 */
public class DefaultTableCreator extends AbstractTableCreator {

	@Autowired
	private TablesMapper tablesMapper;

	/**
	 * 真正的建表逻辑
	 * @param table
	 */
	@Override
	protected void create(Table table) {
		int i = tablesMapper.tableIsExist(table.getTableName());
		if (i == 1) {
			//存在表，drop
			tablesMapper.dropTable(table.getTableName());
		}
		tablesMapper.createTableNew(table);
	}
}
