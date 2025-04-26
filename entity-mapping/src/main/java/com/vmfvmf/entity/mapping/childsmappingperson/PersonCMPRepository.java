package com.vmfvmf.entity.mapping.childsmappingperson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("personCMPRepository")
public interface PersonCMPRepository extends JpaRepository<PersonCMP, Long> {

}
