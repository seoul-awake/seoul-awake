package com.seoulawake.backend.infra.kakao.dto.response.embedded;

public record Address(
	String address_name,
	String region_1depth_name,
	String region_2depth_name,
	String region_3depth_name,
	String region_3depth_h_name,
	String h_code,
	String b_code,
	String mountain_yn,
	String mail_address_no,
	String sub_address_no,
	String x, String y
) {
}
