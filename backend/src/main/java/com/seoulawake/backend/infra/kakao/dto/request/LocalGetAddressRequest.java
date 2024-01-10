package com.seoulawake.backend.infra.kakao.dto.request;

import org.springframework.http.HttpMethod;

import com.seoulawake.backend.infra.kakao.KaKaoApiRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LocalGetAddressRequest implements KaKaoApiRequest {
	private static final String REQUEST_URI = "v2/local/search/address?query";

	private String query;

	@Override
	public String getUrl() {
		return BASE_URI + "/" + REQUEST_URI + "=" + query;
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.GET;
	}
}
