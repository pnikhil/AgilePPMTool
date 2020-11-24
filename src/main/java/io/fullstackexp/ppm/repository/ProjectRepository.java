package io.fullstackexp.ppm.repository;

import io.fullstackexp.ppm.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    Iterable<Project> findAll();

    Project findByProjectIdentifier(String projectId);
}
