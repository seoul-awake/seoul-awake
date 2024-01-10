package com.seoulawake.backend.module.cafe.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
	@Column
	private String normalAddress;
	private String roadAddress;

	public Address(String normalAddress, String roadAddress) {
		this.normalAddress = normalAddress;
		this.roadAddress = roadAddress;
	}
}
