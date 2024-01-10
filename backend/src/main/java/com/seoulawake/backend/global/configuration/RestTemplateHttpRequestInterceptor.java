package com.seoulawake.backend.global.configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestTemplateHttpRequestInterceptor implements ClientHttpRequestInterceptor {
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws
		IOException {
		ClientHttpResponse response = execution.execute(request, body);
		loggingResponse(response);
		//        loggingRequest(request, body);
		return execution.execute(request, body);
	}

	private void loggingRequest(HttpRequest request, byte[] body) {
		log.info("=====Request======");
		log.info("Headers: {}", request.getHeaders());
		log.info("Request Method: {}", request.getMethod());
		log.info("Request URI: {}", request.getURI());
		log.info("Request body: {}", body.length == 0 ? null : new String(body, StandardCharsets.UTF_8));
		log.info("=====Request======");
	}

	private void loggingResponse(ClientHttpResponse response) throws IOException {
		final String body = getBody(response);

		log.info("======Response=======");
		log.info("Headers: {}", response.getHeaders());
		log.info("Response Status : {}", response.getRawStatusCode());
		log.info("Request body: {}", body);
		log.info("======Response=======");
	}

	private String getBody(ClientHttpResponse response) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(response.getBody()))) {
			return br.readLine();
		}
	}
}
