package com.stackfing.sform.base;

import com.stackfing.sform.mapper.TablesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午5:54 19-7-20
 */

@Component
public class DefaultTableCreater extends AbstractTableCreater {

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
