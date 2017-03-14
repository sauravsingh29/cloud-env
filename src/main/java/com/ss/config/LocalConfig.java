package com.ss.config;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author saurav
 *
 */
@Configuration
@Profile("local")
public class LocalConfig extends AbstractCloudConfig {

}
