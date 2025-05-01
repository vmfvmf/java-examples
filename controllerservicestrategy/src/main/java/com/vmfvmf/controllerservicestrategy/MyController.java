package com.vmfvmf.controllerservicestrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("my-entity")
public class MyController {
	
	@Autowired
	protected MyService myService;
	
	@PostMapping
	public ResponseEntity<MyEntityDto> create(@RequestBody MyEntityDto dto) {
	    MyEntityDto created = myService.create(dto);
	    return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<MyEntityDto> update(@PathVariable Long id, @RequestBody MyEntityDto dto) {
	    MyEntityDto updated = myService.patch(id, dto);
	    return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	    myService.delete(id);
	    return ResponseEntity.noContent().build();
	}
	
}
