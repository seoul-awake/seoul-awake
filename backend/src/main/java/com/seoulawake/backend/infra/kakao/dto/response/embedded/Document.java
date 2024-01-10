package com.seoulawake.backend.infra.kakao.dto.response.embedded;

public record Document(
	String address_name,
	String address_type,
	String x,
	String y,
	Address address,
	RoadAddress road_address
) {
}
