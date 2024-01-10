package com.seoulawake.backend.infra.kakao;

import org.springframework.http.HttpMethod;

public interface KaKaoApiRequest<T> {
	String BASE_URI = "https://dapi.kakao.com";

	String getUrl();

	HttpMethod getHttpMethod();

	default T getBody() {
		return null;
	}
}
