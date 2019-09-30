package com.cg.pcm.controller;

import java.util.ArrayList;

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

import com.cg.pcm.entity.Project;
import com.cg.pcm.exception.ProjectException;
import com.cg.pcm.service.ProjectService;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins="http://localhost:4200")
public class ProjectController {

	@Autowired
	ProjectService service;

	@GetMapping(path = "/{id}")
	public Project getProjectById(@PathVariable("id") long id) throws ProjectException {
		return service.getProjectById(id);
	}

	@DeleteMapping(path = "/{id}")
	public Project deleteProjectById(@PathVariable("id") long id) throws ProjectException {
		return service.deleteProjectById(id);
	}

	@GetMapping(path = "/")
	public ArrayList<Project> getAllProjects() throws ProjectException {
		return service.getAllProjects();
	}

	@PostMapping(path = "/")
	public Project addProject(@RequestBody Project project) throws ProjectException {
		if (service.validateProjectDescription(project) && service.validateStartAndEndDate(project)) {
			return service.addProject(project);
		}
		return null;
	}

	@PutMapping(path = "/")
	public Project updateProject(@RequestBody Project project) throws ProjectException {
		return service.updateProject(project);
	}
}
