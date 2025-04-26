package com.vmfvmf.entity.mapping.childsmappingperson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vmfvmf.entity.mapping.ContactType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ContactMappingPerson {
	@Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String contact;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ContactType type;
	
	@JsonIgnore // this keeps a reference to person on entity but the dto will not have a person property
	// and prevents circular dependencies
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonCMP person;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public ContactType getType() {
		return type;
	}

	public void setType(ContactType type) {
		this.type = type;
	}
}
