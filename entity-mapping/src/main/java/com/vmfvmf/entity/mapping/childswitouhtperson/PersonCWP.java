package com.vmfvmf.entity.mapping.childswitouhtperson;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class PersonCWP {
	
	@Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "passport_id")
    private PassportWithoutPerson passport;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_id")
    private List<ContactWithoutPerson> contacts;
	
	public List<ContactWithoutPerson> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactWithoutPerson> contacts) {
		this.contacts = contacts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public PassportWithoutPerson getPassport() {
		return passport;
	}

	public void setPassport(PassportWithoutPerson passport) {
		this.passport = passport;
	}
}
