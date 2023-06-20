package com.seoulawake.backend.module.cafe.application;

import com.seoulawake.backend.module.cafe.domain.Cafe;
import com.seoulawake.backend.module.cafe.domain.Location;
import com.seoulawake.backend.module.cafe.domain.repository.CafeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;

    @Transactional(readOnly = true)
    public List<Cafe> getCafes() {
        return cafeRepository.findAll();
    }

    public Long create(String name) {
        Cafe cafe = new Cafe(name, new Location(1L, 1L)); // todo: kakao api
        return cafeRepository.save(cafe).getId();
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
