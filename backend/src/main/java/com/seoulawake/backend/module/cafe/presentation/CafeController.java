package com.seoulawake.backend.module.cafe.presentation;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.seoulawake.backend.module.cafe.application.CafeService;
import com.seoulawake.backend.module.cafe.domain.Cafe;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CafeController {
	private final CafeService cafeService;

	public Cafe getCafe(String name) {
		return cafeService.getCafe(name);
	}

	public List<Cafe> getCafes() {
		return cafeService.getCafes();
	}

	public Cafe createCafe(String name) {
		return cafeService.create(name);
	}

	public Boolean checkCafe(Long id) {
		return cafeService.checked(id);
	}
}
