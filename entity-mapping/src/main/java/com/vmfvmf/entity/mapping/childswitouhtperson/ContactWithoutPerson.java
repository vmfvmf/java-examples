package com.vmfvmf.entity.mapping.childswitouhtperson;

import com.vmfvmf.entity.mapping.ContactType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContactWithoutPerson {
	@Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String contact;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ContactType type;
		
//	@Column
//	private Long personId;
//
//	public Long getPessoaId() {
//		return personId;
//	}
//
//	public void setPersonId(Long personId) {
//		this.personId = personId;
//	}

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
