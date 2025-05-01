package com.vmfvmf.controllerservicestrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyEntity {
	@Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String something;
	
	public MyEntity() {
		super();
	}
	public MyEntity(Long id, String something) {
		super();
		this.id = id;
		this.something = something;
	}
	
	public MyEntity(String something) {
		this(null, something);
	}

	public String getSomething() {
		return something;
	}

	public void setSomething(String something) {
		this.something = something;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
