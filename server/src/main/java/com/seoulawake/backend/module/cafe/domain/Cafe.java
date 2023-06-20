package com.seoulawake.backend.module.cafe.domain;

import com.seoulawake.backend.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cafe extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafe_id")
    private Long id;
    private String name;
    private boolean isChecked;

    @Embedded
    private Location location;

    @Builder
    public Cafe(String name, Location location) {
        this.name = name;
        this.isChecked = false;
        this.location = location;
    }

    public void checked() {
        this.isChecked = true;
    }
}
