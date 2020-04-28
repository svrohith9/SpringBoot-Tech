package io.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdateProject(@RequestBody Project project) {

		return projectRepository.save(project);
	}

	public Project findProject(String projectId) {

		return projectRepository.findByProjectIdentifierIgnoreCase(projectId);
	}

	public Iterable<Project> findAllProjects() {
		return projectRepository.findAll();
	}

	public void deleteProject(@RequestBody String projectId) {
		if (findProject(projectId) != null) {
			projectRepository.delete(findProject(projectId));
		}
	}

}
