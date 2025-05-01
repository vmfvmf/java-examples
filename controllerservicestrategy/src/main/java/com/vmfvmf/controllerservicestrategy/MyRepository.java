package com.vmfvmf.controllerservicestrategy;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository("myRepository")
public interface MyRepository extends JpaRepository<MyEntity, Long> {

}
