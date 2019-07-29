package com.stackfing.sform.beans.support;

import com.stackfing.sform.beans.BusinessObjectSource;
import com.stackfing.sform.beans.BusniessObjectSourceRegistry;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午7:58 19-7-22
 * @Since:
 */

@Component
public class SimpleBusniessObjectSourceRegistry implements BusniessObjectSourceRegistry {

	private final Map<String, BusinessObjectSource> registry = new ConcurrentHashMap<>(16);

	@Override
	public void registerBusniessObjectSource(BusinessObjectSource businessObjectSource) {
		registry.put(businessObjectSource.getTableName(), businessObjectSource);
	}

	@Override
	public void removeBusniessObjectSource(String tableName) {
		registry.remove(tableName);
	}

	@Override
	public List<BusinessObjectSource> getBusniessObjectSource() {
		List<BusinessObjectSource> list = new ArrayList<>();
		Set<String> strings = registry.keySet();
		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()) {
			list.add(registry.get(iterator.next()));
		}
		return list;
	}
}
