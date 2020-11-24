package io.fullstackexp.ppm.controller;

import io.fullstackexp.ppm.domain.Project;
import io.fullstackexp.ppm.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<Project> createNewProject(@RequestBody Project project){
        Project responseProject = projectService.saveOrUpdateProject(project);
        log.info("Ran the create new project method");
        return new ResponseEntity<>(responseProject, HttpStatus.CREATED);
    }
}
