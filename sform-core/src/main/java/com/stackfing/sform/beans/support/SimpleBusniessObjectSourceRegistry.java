package com.stackfing.sform.beans.support;

import com.stackfing.sform.beans.BusniessObjectSource;
import com.stackfing.sform.beans.BusniessObjectSourceRegistry;
import com.stackfing.sform.beans.annotation.BusniessObject;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午7:58 19-7-22
 * @Since:
 */
public class SimpleBusniessObjectSourceRegistry implements BusniessObjectSourceRegistry {

	private final Map<String, BusniessObjectSource> registry = new ConcurrentHashMap<>(16);

	@Override
	public void registerBusniessObjectSource(BusniessObjectSource busniessObjectSource) {
		registry.put(busniessObjectSource.getTableName(), busniessObjectSource);
	}

	@Override
	public void removeBusniessObjectSource(String tableName) {
		registry.remove(tableName);
	}

	@Override
	public List<BusniessObjectSource> getBusniessObjectSource() {
		List<BusniessObjectSource> list = new ArrayList<>();
		Set<String> strings = registry.keySet();
		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()) {
			list.add(registry.get(iterator.next()));
		}
		return list;
	}
}
