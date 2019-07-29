package com.stackfing.sform.autoconfigure;

import com.stackfing.sform.base.TableCreater;
import com.stackfing.sform.base.support.DefaultTableCreator;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**

/**
 *  @Author: fing
 *  @Description:
 *  @Date: 19-7-23
 *  @Since:
 */

@Configuration
@EnableConfigurationProperties(SformProperties.class)
public class SformAutoconfiguration {

	@Bean
	public TableCreater tableCreater() {
		return new DefaultTableCreator();
	}

}
