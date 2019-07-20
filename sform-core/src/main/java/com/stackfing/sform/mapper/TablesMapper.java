package com.stackfing.sform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stackfing.sform.base.Column;
import com.stackfing.sform.base.Table;
import com.stackfing.sform.entity.Tables;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午10:21 19-7-11
 */
public interface TablesMapper extends BaseMapper<Tables> {
	void createTable(@Param("newTableName") String newTableName, @Param("columns") List<Map<String, String>> columns);

	void createTableReView(@Param("newTableName") String newTableName, @Param("columns") List<Column> columns);

	void createTableNew(Table table);

	int tableIsExist(String tableName);

	void dropTable(@Param("tableName")String tableName);
}
