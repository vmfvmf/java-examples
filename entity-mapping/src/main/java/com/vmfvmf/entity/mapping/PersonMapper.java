package com.vmfvmf.entity.mapping;

import org.mapstruct.Mapper;

import com.vmfvmf.entity.mapping.childsmappingperson.ContactMappingPerson;
import com.vmfvmf.entity.mapping.childsmappingperson.PassportMappingPerson;
import com.vmfvmf.entity.mapping.childsmappingperson.PersonCMP;
import com.vmfvmf.entity.mapping.childswitouhtperson.ContactWithoutPerson;
import com.vmfvmf.entity.mapping.childswitouhtperson.PassportWithoutPerson;
import com.vmfvmf.entity.mapping.childswitouhtperson.PersonCWP;

@Mapper(config = AppMapperConfig.class)
public abstract class PersonMapper {
	
	public abstract PersonCMP toPersonPMP(PersonDto perDto);
	
	public abstract PersonCWP toPersonPWP(PersonDto perDto);
	
	public abstract PassportMappingPerson toPassportMP(PassportDto pasDto);

	public abstract PassportWithoutPerson toPassportWP(PassportDto pasDto);
	
	public abstract ContactMappingPerson toContactMP(ContactDto pasDto);
	
	public abstract ContactWithoutPerson toContactWP(ContactDto pasDto);
}
