package com.seoulawake.backend.module.cafe.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seoulawake.backend.infra.kakao.KakaoApiTemplate;
import com.seoulawake.backend.infra.kakao.dto.request.LocalGetAddressRequest;
import com.seoulawake.backend.infra.kakao.dto.response.LocalGetAddressResponse;
import com.seoulawake.backend.module.cafe.domain.Cafe;
import com.seoulawake.backend.module.cafe.domain.repository.CafeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CafeService {
	private final CafeRepository cafeRepository;
	private final KakaoApiTemplate kakaoApiTemplate;

	@Transactional(readOnly = true)
	public List<Cafe> getCafes() {
		return cafeRepository.findAll();
	}

	public Cafe create(String address) {
		LocalGetAddressRequest request = new LocalGetAddressRequest(address);
		LocalGetAddressResponse response = kakaoApiTemplate.execute(request, LocalGetAddressResponse.class);

		Cafe cafe = new Cafe(null, null); // todo: apply api result
		return cafeRepository.save(cafe);
	}

	public boolean checked(Long id) {
		Cafe cafe = findById(id);
		cafe.checked();
		return true;
	}

	public Cafe getCafe(String name) {
		return cafeRepository.findByName(name)
			.orElseThrow(EntityNotFoundException::new);
	}

	private Cafe findById(Long id) {
		return cafeRepository.findById(id)
			.orElseThrow(EntityNotFoundException::new);
	}
}
