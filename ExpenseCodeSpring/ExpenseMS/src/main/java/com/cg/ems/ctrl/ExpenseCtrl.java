package com.cg.ems.ctrl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.Exception.EMSNotFoundException;
import com.cg.ems.dao.Repo;
import com.cg.ems.dto.Expense;


@RestController
@RequestMapping(value = "/ExpenseCode")
@CrossOrigin(origins="http://localhost:4200")
public class ExpenseCtrl {

	@Autowired
	Repo repo;

	@PostMapping("/add/")
	public Expense add(@RequestBody Expense proj) {
		System.out.println(proj);
		repo.save(proj);
		return proj;

	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable("id") int code, @RequestBody Expense proj) throws EMSNotFoundException {
		Optional<Expense> exp = repo.findById(code);
		if (exp.isPresent()==false)
			throw new EMSNotFoundException("Code does not exist");
		else {
			proj.setExpenseCode(code);
			repo.save(proj);
		}

	}

	@GetMapping("/displayExpDet/{code}")
	public Optional<Expense> displayById(@PathVariable("code") int code) throws EMSNotFoundException {
		Optional<Expense> exp = repo.findById(code);
		if (exp.isPresent()==false)
			throw new EMSNotFoundException("Code does not exist");
		return exp;
	}

	@GetMapping("/displayall/")
	public ArrayList<Expense> displayall() throws EMSNotFoundException {
		ArrayList<Expense> expl=(ArrayList<Expense>) repo.findAll();
		if(expl.size()==0)
			throw new EMSNotFoundException("No Data found");
		return expl;
	}

	@DeleteMapping("/delete/{id}")
	public Optional<Expense> delete(@PathVariable("id") int id) throws EMSNotFoundException {
		Optional<Expense> exp = repo.findById(id);
		if (exp.isPresent()==false)
			throw new EMSNotFoundException("Code does not exist");
		repo.deleteById(id);
		return exp;

	}

}
