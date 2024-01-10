package com.seoulawake.backend.infra.kakao;

public interface KakaoApiTemplate {
	<T extends KaKaoApiRequest, R extends KakaoApiResponse> R execute(T request, Class<R> response);
}
