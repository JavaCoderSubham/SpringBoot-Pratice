package com.spring.motivity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.motivity.entity.Manager;
import com.spring.motivity.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository repository;
	
	
	@Override
	public List<Manager> getAll() {
		return repository.findAll();
	}

	@Override
	public Manager getById(int id) {
		Manager manager = repository.findById(id).orElse(null);
		
		if(manager == null) 
			throw new NullPointerException("User Id Not Found");
		
		return manager;
	}

	@Override
	public Manager createData(Manager manager) {
		
		manager.setFullName(manager.getFirstName() + " " + manager.getLastName());
		
		return repository.save(manager);
	}

	@Override
	public String deleteData(int id) {
		
		repository.deleteById(id);
		
		return "id : "+id+" Delete Completed...";
	}

	@Override
	public Manager updateData(Manager manager) {
		
		Manager temp = getById(manager.getManagerId());
		
		temp.setDept(manager.getDept());
		temp.setEmpCode(manager.getEmpCode());
		temp.setFirstName(manager.getFirstName());
		temp.setLastName(manager.getLastName());
		temp.setSalary(manager.getSalary());
		temp.setFullName(manager.getFirstName() + " " + manager.getLastName());
		
		return repository.save(manager);
	}

	@Override
	public List<Manager> findByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}

	@Override
	public List<Manager> findByFirstNameAndLastName(String firstName, String lastName) {
		return repository.findByFirstNameAndLastName(firstName,lastName);
	}

	@Override
	public List<Manager> findByEmpCodeStartingWith(String empCode) {
		return repository.findByEmpCodeStartingWith(empCode);
	}

	@Override
	public List<Manager> findByEmpCodeEndingWith(String empCode) {
		return repository.findByEmpCodeEndingWith(empCode);
	}

	@Override
	public List<Manager> findByEmpCodeContains(String empCode) {
		return repository.findByEmpCodeContaining(empCode);
	}

	@Override
	public List<Manager> findByEmpCodeNotContains(String empCode) {
		return repository.findByEmpCodeNotContaining(empCode);
	}

	@Override
	public List<Manager> findByEmpCodeEqual(String empCode) {
		return repository.findByEmpCodeEquals(empCode);
	}

	@Override
	public List<Manager> findByEmpCodeNotEqual(String empCode) {
		return repository.findByEmpCodeNot(empCode);
	}

	@Override
	public List<Manager> findBySalaryBetween(int start, int end) {
		return repository.findBySalaryBetween(start, end);
	}

	@Override
	public List<Manager> findByFullNameLike(String fullName) {
		return repository.findByFullNameLike(fullName);
	}

	@Override
	public List<Manager> findBySalaryGreaterThanEqual(int salary) {
		return repository.findBySalaryGreaterThanEqual(salary);
	}

}
