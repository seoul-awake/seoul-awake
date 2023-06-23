package com.seoulawake.backend.infra.kakao.dto.response.embedded;

public record Meta(
        int total_count,
        int pageable_count,
        boolean is_end) {
}
