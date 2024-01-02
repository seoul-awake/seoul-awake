package com.seoulawake.backend.infra.kakao.dto.response;

import com.seoulawake.backend.infra.kakao.KakaoApiResponse;
import com.seoulawake.backend.infra.kakao.dto.response.embedded.Document;
import com.seoulawake.backend.infra.kakao.dto.response.embedded.Meta;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LocalGetAddressResponse implements KakaoApiResponse {
    private Meta meta;
    private Document[] documents;
}
