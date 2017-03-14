/**
 * 
 */
package com.ss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author saurav
 *
 */
@RestController
public class EnvDetailsController {

	ThreadLocal<ObjectMapper> mapperThread = new ThreadLocal<ObjectMapper>() {

		@Override
		protected ObjectMapper initialValue() {
			ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT,
					true);
			mapper.writerWithDefaultPrettyPrinter();
			return mapper;
		}

	};

	@RequestMapping(value = "/env", method = RequestMethod.GET)
	public String getEnvDetails() {
		try {
			return mapperThread.get().writeValueAsString(System.getenv());
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
