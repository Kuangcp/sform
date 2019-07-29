package com.stackfing.sform.beans;

import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午7:19 19-7-22
 * @Since:
 */
public interface BusniessObjectSourceRegistry {

	void registerBusniessObjectSource(BusinessObjectSource businessObjectSource);

	void removeBusniessObjectSource(String tableName);

	List<BusinessObjectSource> getBusniessObjectSource();

}
