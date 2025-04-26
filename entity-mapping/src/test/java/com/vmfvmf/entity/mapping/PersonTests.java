package com.vmfvmf.entity.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.vmfvmf.entity.mapping.ContactDto;
import com.vmfvmf.entity.mapping.ContactType;
import com.vmfvmf.entity.mapping.PassportDto;
import com.vmfvmf.entity.mapping.PersonDto;
import com.vmfvmf.entity.mapping.PersonMapper;
import com.vmfvmf.entity.mapping.childsmappingperson.PersonCMP;
import com.vmfvmf.entity.mapping.childsmappingperson.PersonCMPRepository;
import com.vmfvmf.entity.mapping.childswitouhtperson.PersonCWP;
import com.vmfvmf.entity.mapping.childswitouhtperson.PersonCWPRepository;



@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonTests {
	
	
	@Autowired
	private PersonMapper personMapper;
	
	@Autowired
	private PersonCMPRepository personCMPRepository;
	
	@Autowired
	private PersonCWPRepository personPWPRepository;

    @Test
    @Order(1)
    void shouldPersistPersonCMP() {
    	PassportDto passDto = new PassportDto("123", LocalDate.of(2024, 10, 10));
    	
    	List<ContactDto> contacts = new ArrayList<>();
    	contacts.add(new ContactDto(null, "webmaster@vmfvmf.com", ContactType.EMAIL));
    	contacts.add(new ContactDto(null, "19997337677", ContactType.CELLPHONE));

        PersonDto perDto = new PersonDto(null, "Vinicius MF", passDto, contacts);        
        
        PersonCMP saved = personCMPRepository.save(personMapper.toPersonPMP(perDto));

        assertNotNull(saved.getId());
        assertEquals("Vinicius MF", saved.getName());
        assertNotNull(saved.getPassport());
        
        assertEquals(2, saved.getContacts().size());
        
        assertTrue(saved.getContacts().stream()
        		.anyMatch(c -> 
        		c.getType().equals(ContactType.CELLPHONE) && 
        		c.getContact().equals("19997337677")));
        
        assertTrue(saved.getContacts().stream()
        		.anyMatch(c -> 
        		c.getType().equals(ContactType.EMAIL) && 
        		c.getContact().equals("webmaster@vmfvmf.com")));
        
        PersonCMP person = personCMPRepository.findById(saved.getId()).orElse(null);

        assertNotNull(person);
        assertEquals("Vinicius MF", person.getName());
        
        // should persist passport
        assertNotNull(person.getPassport());
        
        person.setPassport(null);
        person.getContacts().clear(); // remember if the list is overwriten (.set(new ArrayList<>())) in java it will throw a error
        
        personCMPRepository.save(personMapper.toPersonPMP(perDto));
        
        PersonCMP personPMP = personCMPRepository.findById(saved.getId()).orElse(null);
        
        // should remove passport
        assertNull(personPMP.getPassport());
        
        // should delete all contacts
        assertEquals(0, saved.getContacts().size());
    }
    
    @Test
    @Order(1)
    void shouldPersistPersonCWP() {
    	// in this case isnt possible a relation only on the side of the person
    	PassportDto passDto = new PassportDto("123", LocalDate.of(2024, 10, 10));
    	
    	List<ContactDto> contacts = new ArrayList<>();
    	contacts.add(new ContactDto(null, "webmaster@vmfvmf.com", ContactType.EMAIL));
    	contacts.add(new ContactDto(null, "19997337677", ContactType.CELLPHONE));
    	
        PersonDto perDto = new PersonDto(null, "Vinicius MF", passDto, contacts);        
        
        PersonCWP saved = personPWPRepository.save(personMapper.toPersonPWP(perDto));

        assertNotNull(saved.getId());
        assertEquals("Vinicius MF", saved.getName());
        assertNotNull(saved.getPassport());   
        
        assertEquals(2, saved.getContacts().size());
        
        assertTrue(saved.getContacts().stream()
        		.anyMatch(c -> 
        		c.getType().equals(ContactType.CELLPHONE) && 
        		c.getContact().equals("19997337677")));
        
        assertTrue(saved.getContacts().stream()
        		.anyMatch(c -> 
        		c.getType().equals(ContactType.EMAIL) && 
        		c.getContact().equals("webmaster@vmfvmf.com")));
        
        PersonCWP person = personPWPRepository.findById(saved.getId()).orElse(null);

        assertNotNull(person);
        assertEquals("Vinicius MF", person.getName());
        
        // should persist passport
        assertNotNull(person.getPassport());
        
        person.setPassport(null);
        person.getContacts().clear();
        
        personPWPRepository.save(personMapper.toPersonPWP(perDto));
        
        PersonCWP personPWP = personPWPRepository.findById(saved.getId()).orElse(null);
        
        // should remove passport
        assertNull(personPWP.getPassport());
        
        // should delete all contacts
        assertEquals(0, saved.getContacts().size());
    }
}