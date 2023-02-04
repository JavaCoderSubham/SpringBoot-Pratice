package com.spring.motivity.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.motivity.entity.Manager;
import com.spring.motivity.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService service;
	
	private final static Logger log = LogManager.getLogger(ManagerController.class);
	
	@GetMapping
	public ResponseEntity<List<Manager>> getAll() {
		
		log.info("=========== Get All Method Start ===========");
		
		List<Manager> list = service.getAll();
		
		log.info("getAll() -> {}",list);
		
		log.info("=========== Get All Method End ===========");
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(list); 
	}
	
	@GetMapping("/user")
	public ResponseEntity<Manager> getById(@RequestParam int id) {
		
		log.info("=========== Get By ID Method Start =============");
		
		log.info("getById() -> id : ",id);
		Manager manager = service.getById(id);
		
		log.info("getById() -> {}",manager);
		
		log.info("=========== Get By ID Method End =============");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(manager);
	}
	
	@PostMapping
	public ResponseEntity<Manager> createData(@RequestBody Manager manager) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.createData(manager));
	}
	
	@PutMapping
	public ResponseEntity<Manager> updateData(@RequestBody Manager manager) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.updateData(manager));
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteById(@RequestParam int id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.deleteData(id));
	}
	
	@GetMapping("/firstName")
	public ResponseEntity<List<Manager>> findByFirstName(@RequestParam String firstName) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findByFirstName(firstName));
	}
	
	@GetMapping("/firstNameAndlastName")
	public ResponseEntity<List<Manager>> findByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findByFirstNameAndLastName(firstName, lastName));
	}
	
	@GetMapping("/empCodeStartingWith")
	public ResponseEntity<List<Manager>> findByEmpCodeStartingWith(@RequestParam String empCode) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findByEmpCodeStartingWith(empCode));
	}
	
	@GetMapping("/empCodeEndingWith")
	public ResponseEntity<List<Manager>> findByEmpCodeEndingWith(@RequestParam String empCode) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findByEmpCodeEndingWith(empCode));
	}
	
	@GetMapping("/empCodeContain")
	public ResponseEntity<List<Manager>> findByEmpCodeContain(@RequestParam String empCode) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findByEmpCodeContains(empCode));
	}
	
	@GetMapping("/empCodeNotContain")
	public ResponseEntity<List<Manager>> findByEmpCodeNotContain(@RequestParam String empCode) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findByEmpCodeNotContains(empCode));
	}
	
	@GetMapping("/empCodeEqual")
	public ResponseEntity<List<Manager>> findByEmpCodeEqual(@RequestParam String empCode) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findByEmpCodeEqual(empCode));
	}
	
	@GetMapping("/empCodeNotEqual")
	public ResponseEntity<List<Manager>> findByEmpCodeNotEqual(@RequestParam String empCode) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findByEmpCodeNotEqual(empCode));
	}
	
	@GetMapping("/salaryBetween")
	public ResponseEntity<List<Manager>> findBySalaryBetween(@RequestParam int start, 
														@RequestParam int end) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findBySalaryBetween(start, end));
	}
	
	@GetMapping("/fullnameLike")
	public ResponseEntity<List<Manager>> findByFullNameLike(@RequestParam String fullName) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findByFullNameLike(fullName));
	}
	
	@GetMapping("/salaryGreaterThan")
	public ResponseEntity<List<Manager>> findBySalaryGreaterThan(@RequestParam int salary) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.findBySalaryGreaterThanEqual(salary));
	}
	
	
	
	
	
}








