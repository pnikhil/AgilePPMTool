package io.fullstackexp.ppm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project Name is required")
    private String projectName;

    @NotBlank(message = "Project Identifier is required")
    @Size(min=4, max=5, message="Please use 4 to 5 characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier; // Adding customer identifier for project object (JPA problem, so not using projectId)

    @NotBlank(message = "Project Description is required")
    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
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
