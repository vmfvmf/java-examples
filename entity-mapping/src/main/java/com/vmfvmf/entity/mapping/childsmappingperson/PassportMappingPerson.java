package com.vmfvmf.entity.mapping.childsmappingperson;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// this class does not requires that person should be set because of JsonIgnore
@Entity
public class PassportMappingPerson {
	
	@Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String number;
	
	@Column
	private LocalDate issueDate;	
	
    @JsonIgnore // this keeps a reference to person on entity but the dto will not have a person property
    // and prevents circular dependencies
    @OneToOne(mappedBy = "passport")
    private PersonCMP person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public PersonCMP getPerson() {
		return person;
	}

	public void setPerson(PersonCMP person) {
		this.person = person;
	}    
}
