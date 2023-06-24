package com.seoulawake.backend.module.cafe.presentation;

import com.seoulawake.backend.module.cafe.application.CafeService;
import com.seoulawake.backend.module.cafe.domain.Cafe;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @QueryMapping
    public Cafe getCafe(@Argument String name) {
        return cafeService.getCafe(name);
    }

    @QueryMapping
    public List<Cafe> getCafes() {
        return cafeService.getCafes();
    }

    @MutationMapping
    public Cafe createCafe(@Argument String name) {
        return cafeService.create(name);
    }

    @MutationMapping
    public Boolean checkCafe(@Argument Long id) {
        return cafeService.checked(id);
    }
}
