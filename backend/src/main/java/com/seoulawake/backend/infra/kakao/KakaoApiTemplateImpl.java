package com.seoulawake.backend.infra.kakao;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.MediaType.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KakaoApiTemplateImpl implements KakaoApiTemplate {
	private static final String KAKAO_AUTHORIZATION_PREFIX = "KakaoAK ";
	private final RestTemplate kakaoTemplate;

	@Value("${kakao.key}")
	private String key;

	@Override
	public <T extends KaKaoApiRequest, R extends KakaoApiResponse> R execute(T request, Class<R> response) {
		try {
			// todo: 유효성 검증
			HttpEntity<T> httpEntity = createHttpEntity(request);
			return kakaoTemplate.exchange(request.getUrl(), request.getHttpMethod(), httpEntity, response).getBody();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("translate faild");
		}
	}

	private <T extends KaKaoApiRequest> HttpEntity<T> createHttpEntity(T request) {
		HttpHeaders httpHeaders = kakaoHeaders();
		if (isEmptyBody(request)) {
			return new HttpEntity<>(httpHeaders);
		}
		return new HttpEntity<>(request, httpHeaders);
	}

	private HttpHeaders kakaoHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(AUTHORIZATION, KAKAO_AUTHORIZATION_PREFIX + key);
		httpHeaders.add(CONTENT_TYPE, APPLICATION_JSON_VALUE);
		return httpHeaders;
	}

	private <T extends KaKaoApiRequest> boolean isEmptyBody(T request) {
		return request.getBody() == null;
	}
}
