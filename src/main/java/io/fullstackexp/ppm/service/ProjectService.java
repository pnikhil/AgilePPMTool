package io.fullstackexp.ppm.service;

import io.fullstackexp.ppm.domain.Project;
import io.fullstackexp.ppm.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        return projectRepository.save(project);
    }
}
