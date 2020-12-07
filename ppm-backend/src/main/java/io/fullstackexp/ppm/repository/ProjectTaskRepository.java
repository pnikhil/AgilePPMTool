package io.fullstackexp.ppm.repository;

import io.fullstackexp.ppm.domain.Backlog;
import io.fullstackexp.ppm.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
}
