package com.stackfing.sform.beans.support;

import com.stackfing.sform.beans.BusniessObjectSource;
import com.stackfing.sform.beans.BusniessObjectSourceRegistry;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午7:58 19-7-22
 * @Since:
 */
public class SimpleBusniessObjectSourceRegistry implements BusniessObjectSourceRegistry {

	private final Map<String, String> registry = new ConcurrentHashMap<>(16);

	@Override
	public void registerBusniessObjectSource(Class<?> clz) {

	}

	@Override
	public void removeBusniessObjectSource(Class<?> clz) {

	}

	@Override
	public List<BusniessObjectSource> getBusniessObjectSource() {
		return null;
	}
}
