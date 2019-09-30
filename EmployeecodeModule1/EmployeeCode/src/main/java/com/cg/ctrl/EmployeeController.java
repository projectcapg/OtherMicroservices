package com.cg.ctrl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.beans.EmployeeCode;
import com.cg.dao.EmployeeRepository;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/employeecode")
public class EmployeeController 
{

	@Autowired
	EmployeeRepository repo;
	
	@GetMapping(value="/display/")
	public List<EmployeeCode> getAllEmployees()
	{
		return repo.findAll();
	}
	
	@GetMapping(value="/find/{id}")
	public EmployeeCode findEmployeeById (@PathVariable("id") int id)
	{
		return repo.findById(id).get();
	}
	
	@PostMapping(value="/addEmployee",consumes=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeCode add(@RequestBody EmployeeCode emp)
	{
		repo.save(emp);
		return emp;
	}
	
	@PutMapping(value="/modify")
	public int update(@RequestBody EmployeeCode emp) {
		repo.save(emp);
		return 1;
	}
	
	
	@DeleteMapping(value="/delete/{unm}")
	public String deleteEmployee(@PathVariable("unm") int unm)
	{
		System.out.println(unm);
		repo.deleteById(unm);
		return String.valueOf(unm)+"deleted";
	}
}
