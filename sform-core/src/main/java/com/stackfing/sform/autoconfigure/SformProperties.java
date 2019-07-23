package com.stackfing.sform.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: fing
 * @Description:
 * @Date: 19-7-23
 * @Since:
 */
@Data
@ConfigurationProperties(prefix = "spring.sform")
public class SformProperties {


}
