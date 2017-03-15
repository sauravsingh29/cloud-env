package com.ss.config;

import javax.sql.DataSource;

import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * @author saurav
 *
 */
@Configuration
@ServiceScan
@Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {

	@Bean
	public ApplicationInstanceInfo applicationInstanceInfo() {
		return cloud().getApplicationInstanceInfo();
	}
	
	@Bean(name = "clouddb")
	@Primary
	public DataSource dataSource(){
		return connectionFactory().dataSource();
	}

}
