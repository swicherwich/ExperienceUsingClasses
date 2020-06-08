package com.nix.homework.data;

public abstract class AbstractData<T extends AbstractData> {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
