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

	@Override
	protected void create(Table table) {
		tablesMapper.createTableNew(table);
	}
}
