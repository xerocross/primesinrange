package com.adamfgcross.primesinrange;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adamfgcross.primesinrange.service.TaskStoreService;

@Configuration
public class BeanConfiguration {

	@Bean
	public TaskStoreService<List<String>> primesInRangeTaskStoreService() {
		return new TaskStoreService<List<String>>();
	}
	
	@Bean
	public TaskStoreService<Void> dbUpdateTaskStoreService() {
		return new TaskStoreService<Void>();
	}
	
}
