package com.cg.pcm.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pcm.entity.Project;
import com.cg.pcm.exception.ProjectException;
import com.cg.pcm.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository repository;

	@Override
	public boolean validateProjectDescription(Project project) throws ProjectException {
		String pattern="^[A-Za-z0-9_]+$";
		if(project.getDescription()!=null && Pattern.matches(pattern, project.getDescription())) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean validateStartAndEndDate(Project project) throws ProjectException {
		 if (project.getStartDate()!=null && project.getEndDate()!=null && project.getEndDate().compareTo(project.getStartDate()) > 0)
			 return true;
		return false;
	}

	@Override
	public Project addProject(Project project) throws ProjectException {
		return repository.save(project);
	}

	@Override
	public Project updateProject(Project project) throws ProjectException {
		if (repository.findById(project.getId()).isPresent()) {
			return repository.save(project);
		}
		return null;
	}

	@Override
	public Project deleteProjectById(long id) throws ProjectException {
		Optional<Project> project = repository.findById(id);
		Project toBeReturned;
		if (project.isPresent()) {
			toBeReturned = project.get();
			repository.deleteById(id);
		} else {
			toBeReturned = null;
		}
		return toBeReturned;
	}

	@Override
	public ArrayList<Project> getAllProjects() throws ProjectException {
		return (ArrayList<Project>) repository.findAll();
	}

	@Override
	public Project getProjectById(long id) throws ProjectException {
		Optional<Project> project = repository.findById(id);
		if (project.isPresent()) {
			return project.get();
		}
		return null;
	}

}
