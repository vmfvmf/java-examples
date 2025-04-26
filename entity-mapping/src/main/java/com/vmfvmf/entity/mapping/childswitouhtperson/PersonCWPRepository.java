package com.vmfvmf.entity.mapping.childswitouhtperson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("personCWPRepository")
public interface PersonCWPRepository extends JpaRepository<PersonCWP, Long> {

}
