package com.vmfvmf.controllerservicestrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service("myService")
public class MyService {
	
	@Autowired
	protected MyMapper myMapper;
	
	@Autowired
	protected MyRepository myRepository; 
	
	public MyEntityDto create(MyEntityDto dto) {
	    MyEntity entity = myMapper.toEntity(dto);
	    MyEntity saved = myRepository.save(entity);
	    return myMapper.toDto(saved);
	}
	
	public MyEntityDto patch(Long id, MyEntityDto dto) {
	    MyEntity entity = myRepository.findById(id)
	        .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
	    
	    myMapper.patch(dto, entity); // modifies the existing entity
	    MyEntity saved = myRepository.save(entity);
	    return myMapper.toDto(saved);
	}
	
	public void delete(Long id) {
	    if (!myRepository.existsById(id)) {
	        throw new EntityNotFoundException("Entity not found");
	    }
	    myRepository.deleteById(id);
	}
}
