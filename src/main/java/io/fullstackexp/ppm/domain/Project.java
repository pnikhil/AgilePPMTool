package io.fullstackexp.ppm.domain;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String projectIdentifier; // Adding customer identifier for project object (JPA problem, so not using projectId)
    private String description;
    private Date startDate;
    private Date endDate;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    @PrePersist
    protected void onCreate(){
        this.setCreatedDateTime(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate(){
        this.setUpdatedDateTime(LocalDateTime.now());
    }
}
