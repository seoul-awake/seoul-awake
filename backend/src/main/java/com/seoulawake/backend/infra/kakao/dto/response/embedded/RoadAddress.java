package com.seoulawake.backend.infra.kakao.dto.response.embedded;

public record RoadAddress(
	String address_name,
	String region_1depth_name,
	String region_2depth_name,
	String region_3depth_name,
	String road_name,
	String underground_yn,
	String mainBuilding_no,
	String subBuilding_no,
	String building_name,
	String zone_no,
	String x,
	String y
) {
}
